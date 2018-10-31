package silverwing.christina.flickrphotos;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_my_photos:
                    mTextMessage.setText(R.string.app_header_my_photos);
                    Intent myPhotosIntent = new Intent(getApplicationContext(), MyPhotosActivity.class);
                    startActivity(myPhotosIntent);
                    return true;
                case R.id.navigation_public_photos:
                    mTextMessage.setText(R.string.app_header_public_photos);
                    Intent publicPhotosIntent = new Intent(getApplicationContext(), MyPhotosActivity.class);
                    startActivity(publicPhotosIntent);
                    return true;
                case R.id.navigation_map:
                    mTextMessage.setText(R.string.app_header_map);
                    Intent mapIntent = new Intent(getApplicationContext(), MapsActivity.class);
                    startActivity(mapIntent);
                    return true;
                case R.id.navigation_profile:
                    mTextMessage.setText(R.string.app_header_profile);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
