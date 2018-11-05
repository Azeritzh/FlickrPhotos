package silverwing.christina.flickrphotos;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MyPhotosActivity extends Fragment {

    private static final String TAG = "MyPhotosActivity";

    private ArrayList<String> image_headers = new ArrayList<>();
    private ArrayList<String> image_URLs = new ArrayList<>();

    private ArrayList<String> public_images_list;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initPrivateImages();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_my_photos, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(image_headers, image_URLs,getContext());
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }

    private void constructImageUrl() {

    }

    private void initPrivateImages() {
        Log.d(TAG, "initPrivateImages: preparing private images.");

        image_URLs.add("https://cdn.pixabay.com/photo/2013/04/06/11/50/image-editing-101040_960_720.jpg");
        image_headers.add("Sheep on paper");

        image_URLs.add("http://2.bp.blogspot.com/-RoQQ5fACBTI/U1t3hEO8w3I/AAAAAAAAL4k/4gSg7FiYGqg/s1600/beautiful-images-wallpapers-(1).jpg");
        image_headers.add("Paper boats");
    }

    private void initPublicImages() {

    }
}
