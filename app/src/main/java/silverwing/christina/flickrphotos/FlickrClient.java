package silverwing.christina.flickrphotos;

import android.content.Context;
import android.util.Log;

import com.codepath.oauth.OAuthBaseClient;
import com.github.scribejava.apis.FlickrApi;
import com.github.scribejava.core.builder.api.BaseApi;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class FlickrClient extends OAuthBaseClient{
    public static final BaseApi REST_API_INSTANCE = FlickrApi.instance(FlickrApi.FlickrPerm.READ);
    public static final String REST_URL = "https://www.flickr.com/services";
    public static final String REST_CONSUMER_KEY = "a41792f4c87d9dca4e3f4d896bbf854e";
    public static final String REST_CONSUMER_SECRET = "b59e218f94fd58f6";
    public static final String REST_CALLBACK_URL = "oauth://cprest";

    // Landing page to indicate the OAuth flow worked in case Chrome for Android 25+ blocks navigation back to the app.
    public static final String FALLBACK_URL = "https://codepath.github.io/android-rest-client-template/success.html";

    // See https://developer.chrome.com/multidevice/android/intents
    public static final String REST_CALLBACK_URL_TEMPLATE = "intent://%s#Intent;action=android.intent.action.VIEW;scheme=%s;package=%s;S.browser_fallback_url=%s;end";

    public FlickrClient(Context context) throws InterruptedException, ExecutionException, IOException {
        super(context, REST_API_INSTANCE, REST_URL, REST_CONSUMER_KEY, REST_CONSUMER_SECRET,
                String.format(REST_CALLBACK_URL_TEMPLATE, "cprest", "oauth", context.getPackageName(), FALLBACK_URL));
        setBaseUrl("https://api.flickr.com/services/rest");
    }

    public void getInterestingnessList(AsyncHttpResponseHandler handler) {
        String apiUrl = getApiUrl("?format=json&nojsoncallback=1&method=flickr.interestingness.getList");
        RequestParams params = new RequestParams();
        params.put("format", "json");
        client.get(apiUrl, params, handler);
    }
}