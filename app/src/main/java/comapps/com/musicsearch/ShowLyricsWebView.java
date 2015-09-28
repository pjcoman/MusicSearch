package comapps.com.musicsearch;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.StringTokenizer;

import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.ResponseHandler;
import cz.msebera.android.httpclient.client.methods.HttpGet;
import cz.msebera.android.httpclient.impl.client.BasicResponseHandler;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


public class ShowLyricsWebView extends AppCompatActivity {

    private static final String LOGTAG="MUSICSEARCH";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webviewshowlyrics);

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/MAFW.TTF")
                .setFontAttrId(R.attr.fontPath)
                .build());



        Bundle extras = getIntent().getExtras();

        String infoAlongForTheRide = extras.getString("info");




        Log.d("info from mainactivity", infoAlongForTheRide);
        StringTokenizer st = new StringTokenizer(infoAlongForTheRide, "|");
        String song = st.nextToken();
        String artist = st.nextToken();
        String album = st.nextToken();
        String imageLink = st.nextToken();


        final TextView tvTrackName = (TextView) findViewById(R.id.textViewTrackName);
        tvTrackName.setText(song);
        final TextView tvArtistName = (TextView) findViewById(R.id.textViewArtistName);
        tvArtistName.setText(artist);
        final TextView tvAlbumName = (TextView) findViewById(R.id.textViewAlbumName);
        tvAlbumName.setText(album);

        ImageView imageview = (ImageView) findViewById(R.id.imageView);
        Picasso.with(ShowLyricsWebView.this).load(imageLink).fit().into(imageview);







        song.replaceAll(" ", "_");
        artist.replaceAll(" ", "_");
        Log.d("song", song);
        Log.d("artist", artist);



//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setIcon(R.drawable.ic_launcher);

        WebView webView = (WebView) findViewById(R.id.webview1);
        webView.setWebViewClient(new MyWebViewClient());



        String url = "http://lyrics.wikia.com/api.php?func=getSong&artist=" + artist + "&song=" + song + "&fmt=text";
        url = url.replaceAll("\\s", "_");

        Log.d("url is ", url);

       new RequestTask().execute(url);


        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);




    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {


            view.loadUrl(url);



            return true;
        }
    }




    public void close(View v) {


        finish();

    }

    @Override
    protected void attachBaseContext(Context newBase) {

        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));

    }


    class RequestTask extends AsyncTask<String, String, String>{

        @Override
// username, password, message, mobile
        protected String doInBackground(String... url) {

            Log.d("url in asynch thread is", url[0]);
            // constants

            HttpClient client = new DefaultHttpClient();
            HttpGet httpget = new HttpGet(url[0]);
            ResponseHandler<String> handler = new BasicResponseHandler();
            String response = "";

            try {
                response = client.execute(httpget,handler);

                return response;
            } catch (Exception e) {
                Log.w("MyApp", "Download Exception : " + e.toString());
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            // do something with result
            Log.d("lyrics are " ,result);
        }
    }


}
