package silverwing.christina.flickrphotos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MenuBarFragment extends Fragment {
    public static final String ARG_TITLE = "arg_title";
    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(getArguments().getString(ARG_TITLE, "") == "MyPhotos") {
            View rootView = inflater.inflate(R.layout.activity_my_photos, container, false);
            return rootView;
        }
        else if(getArguments().getString(ARG_TITLE, "") == "PublicPhotos"){
            View rootView = inflater.inflate(R.layout.activity_my_photos, container, false);
            return rootView;
        }
        else if(getArguments().getString(ARG_TITLE, "") == "Map"){
            View rootView = inflater.inflate(R.layout.activity_maps, container, false);
            return rootView;
        }
        else if(getArguments().getString(ARG_TITLE, "") == "Profile") {
            View rootView = inflater.inflate(R.layout.activity_profile, container, false);
            return rootView;
        }

        //textView = (TextView) rootView.findViewById(R.id.main_test);

        //String title = getArguments().getString(ARG_TITLE, "");
        //textView.setText(title);

        //return rootView;
        return null;
    }
}
