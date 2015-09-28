package comapps.com.musicsearch;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.SearchView;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


public class MainActivity extends AppCompatActivity  {

    final static String LOGTAG = "MUSICSEARCH";



    private SearchView search;


    private final String url = "https://itunes.apple.com/search?term=";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/MAFW.TTF")
                .setFontAttrId(R.attr.fontPath)
                .build());


        setContentView(R.layout.activity_main);






       



        search = (SearchView) findViewById(R.id.searchView);
        search.setQueryHint("Enter Artist Name");

        //*** setOnQueryTextFocusChangeListener ***
        search.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                // TODO Auto-generated method stub


            }
        });

        //*** setOnQueryTextListener ***
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                // TODO Auto-generated method stub

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(search.getWindowToken(), 0);



                Log.d("query is ", query);

                // replace space with + for url
                query = query.replaceAll("\\s", "+");
                query = url + query;
                // make sure it f@#$@@7' worked
                Log.d("Url is ", query);

                requestData(query);





                return true;



            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // TODO Auto-generated method stub


                return false;
            }
        });





        // hide keyboard

        ImageView iv = (ImageView) findViewById(R.id.imageView2);
        iv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getWindow().getCurrentFocus().getWindowToken(), 0);
                return false;
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
                //noinspection SimplifiableIfStatement


        return false;
    }

    private void requestData(String uri) {



        Intent trackResults = new Intent(this, TrackResultsManager.class);
        trackResults.putExtra("URI_TO_SEARCH", uri);
       startActivity(trackResults);



    }








    @Override
    protected void attachBaseContext(Context newBase) {

        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));

    }




}
