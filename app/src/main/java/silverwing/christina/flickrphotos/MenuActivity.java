package silverwing.christina.flickrphotos;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {
    private static final String MY_PHOTOS_FRAGMENT = "my_photos_fragment ";
    private static final String PUBLIC_PHOTOS_FRAGMENT = "public_photos_fragment";
    private static final String MAP_FRAGMENT = "map_fragment";
    private static final String PROFILE_FRAGMENT = "profile_fragment";

    private List<MenuBarFragment> fragments = new ArrayList<>(4);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        buildFragmentsList();
        switchFragment(0,MY_PHOTOS_FRAGMENT);
        MyPhotosActivity fragment = new MyPhotosActivity();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frame_fragmentholder, fragment);
        fragmentTransaction.commit();
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_my_photos:
                    switchFragment(0, MY_PHOTOS_FRAGMENT);

                    MyPhotosActivity fragment = new MyPhotosActivity();
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.add(R.id.frame_fragmentholder, fragment);
                    fragmentTransaction.commit();
                    return true;

                case R.id.navigation_public_photos:
                    switchFragment(1, PUBLIC_PHOTOS_FRAGMENT);
                    MyPhotosActivity fragmentP = new MyPhotosActivity();
                    FragmentManager fragmentManagerP = getSupportFragmentManager();
                    FragmentTransaction fragmentTransactionP = fragmentManagerP.beginTransaction();
                    fragmentTransactionP.add(R.id.frame_fragmentholder, fragmentP);
                    fragmentTransactionP.commit();
                    return true;

                case R.id.navigation_map:
                    switchFragment(2, MAP_FRAGMENT);
                    return true;

                case R.id.navigation_profile:
                    switchFragment(3, PROFILE_FRAGMENT);
                    return true;
            }
            return false;
        }
    };

    private void buildFragmentsList() {
        MenuBarFragment myPhotosFragment = buildFragment("MyPhotos");
        MenuBarFragment publicPhotosFragment = buildFragment("PublicPhotos");
        MenuBarFragment mapFragment = buildFragment("Map");
        MenuBarFragment profileFragment = buildFragment("Profile");

        fragments.add(myPhotosFragment);
        fragments.add(publicPhotosFragment);
        fragments.add(mapFragment);
        fragments.add(profileFragment);
    }

    private MenuBarFragment buildFragment(String title) {
        MenuBarFragment fragment = new MenuBarFragment();
        Bundle bundle = new Bundle();
        bundle.putString(MenuBarFragment.ARG_TITLE, title);
        fragment.setArguments(bundle);
        return fragment;
    }

    private void switchFragment(int pos, String tag) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_fragmentholder, fragments.get(pos), tag)
                .commit();
    }
}
