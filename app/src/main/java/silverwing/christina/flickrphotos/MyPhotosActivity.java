package silverwing.christina.flickrphotos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class MyPhotosActivity extends AppCompatActivity {

    private static final String TAG = "MyPhotosActivity";

    private ArrayList<String> image_headers = new ArrayList<>();
    private ArrayList<String> image_URLs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_photos);
        Log.d(TAG, "onCreate: started.");

        initPrivateImages();
    }

    private void initPrivateImages() {
        Log.d(TAG, "initPrivateImages: preparing private images.");

        image_URLs.add("https://cdn.pixabay.com/photo/2013/04/06/11/50/image-editing-101040_960_720.jpg");
        image_headers.add("Sheep on paper");

        image_URLs.add("http://2.bp.blogspot.com/-RoQQ5fACBTI/U1t3hEO8w3I/AAAAAAAAL4k/4gSg7FiYGqg/s1600/beautiful-images-wallpapers-(1).jpg");
        image_headers.add("Paper boats");

        initRecyclerView();
    }

    private void initPublicImages() {

    }

    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: init recycler view");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(image_headers, image_URLs, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
