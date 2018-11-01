package silverwing.christina.flickrphotos;

import android.content.Context;
import android.util.Log;

import com.codepath.oauth.OAuthBaseClient;
import com.github.scribejava.apis.FlickrApi;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.builder.api.BaseApi;
import com.github.scribejava.core.model.OAuth1AccessToken;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth10aService;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class FlickrClient extends OAuthBaseClient{
    public static final BaseApi REST_API_CLASS = FlickrApi.instance();

    public static final String REST_URL = "https://www.flickr.com/services";

    public static final String REST_CONSUMER_KEY = "a41792f4c87d9dca4e3f4d896bbf854e";

    public static final String REST_CONSUMER_SECRET = "b59e218f94fd58f6";

    public static final String REST_CALLBACK_URL = "oauth://cprest";

    public FlickrClient(Context context) throws InterruptedException, ExecutionException, IOException {
        super(context, REST_API_CLASS, REST_URL, REST_CONSUMER_KEY, REST_CONSUMER_SECRET,
                REST_CALLBACK_URL);
        setBaseUrl("https://api.flickr.com/services/rest");

        final OAuth10aService service = new ServiceBuilder(REST_CONSUMER_KEY )
                .apiSecret(REST_CONSUMER_SECRET)
                .build(FlickrApi.instance(FlickrApi.FlickrPerm.DELETE));
        final Scanner in = new Scanner(System.in);

        final OAuth1RequestToken requestToken = service.getRequestToken();

        final String authorizationUrl = service.getAuthorizationUrl(requestToken);
        final String oauthVerifier = in.nextLine();

        final OAuth1AccessToken accessToken = service.getAccessToken(requestToken, oauthVerifier);

        final String PROTECTED_RESOURCE_URL = "http://api.flickr.com/services/rest/";
        final OAuthRequest request = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL);
        request.addQuerystringParameter("method", "flickr.test.login");
        service.signRequest(accessToken, request);
        final Response response = service.execute(request);
    }

    public void getInterestingnessList(AsyncHttpResponseHandler handler) {
        String apiUrl = getApiUrl("?format=json&nojsoncallback=1&method=flickr.interestingness.getList");
        Log.d("DEBUG", "Sending API call to " + apiUrl);
        client.get(apiUrl, null, handler);
    }
}