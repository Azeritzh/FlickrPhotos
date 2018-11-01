package silverwing.christina.flickrphotos;

import android.os.Bundle;

import com.codepath.oauth.OAuthLoginActivity;

public class LoginActivity extends OAuthLoginActivity<FlickrClient> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /*Button loginButton = (Button)findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(loginIntent);
            }
        });*/
    }

    @Override
    public void onLoginSuccess() {

    }

    @Override
    public void onLoginFailure(Exception e) {

    }
}
