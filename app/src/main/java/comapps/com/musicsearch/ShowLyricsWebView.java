package comapps.com.musicsearch;

import android.content.Context;
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

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


public class ShowLyricsWebView extends AppCompatActivity {
    private WebView webView;

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

        webView = (WebView) findViewById(R.id.webview1);
        webView.setWebViewClient(new MyWebViewClient());



        String url = "http://lyrics.wikia.com/api.php?func=getSong&artist=" + artist + "&song=" + song + "&fmt=text";

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
}
