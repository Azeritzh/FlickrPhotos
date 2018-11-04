package silverwing.christina.flickrphotos;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.util.Log;
import android.widget.GridView;

import com.codepath.oauth.OAuthLoginActivity;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class LoginActivity extends OAuthLoginActivity<FlickrClient> {
    private static final String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public void onLoginSuccess() {
        Intent loginIntent = new Intent(getApplicationContext(), MenuActivity.class);
        startActivity(loginIntent);
        /*FlickrClientApp.getRestClient().getInterestingnessList(new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    JSONArray photo_list = response.getJSONObject("photos").getJSONArray("photo");
                    Log.d(TAG, "PhotoList: " + photo_list);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                // Successfully got a response
            }
        });*/
    }

    @Override
    public void onLoginFailure(Exception e) {
        e.printStackTrace();
    }

    public void loginToRest(View view) {
        getClient().connect();
    }
}
