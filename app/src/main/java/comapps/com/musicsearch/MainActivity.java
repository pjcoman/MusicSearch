package comapps.com.musicsearch;

import android.app.ListActivity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


public class MainActivity extends ListActivity {

    final static String LOGTAG = "MUSICSEARCH";


    ProgressBar pb;
    List<MyTask> tasks;
    SearchView search;
    List<Track> trackList;

    String url = "https://itunes.apple.com/search?term=";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/MAFW.TTF")
                .setFontAttrId(R.attr.fontPath)
                .build());


        setContentView(R.layout.activity_main);






       

        pb = (ProgressBar) findViewById(R.id.progressBar);
        pb.setVisibility(View.INVISIBLE);

        search = (SearchView) findViewById(R.id.searchView);
        search.setQueryHint("SearchView");

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



        tasks = new ArrayList<>();

        // xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

        ImageView iv = (ImageView) findViewById(R.id.imageView2);
        iv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getWindow().getCurrentFocus().getWindowToken(), 0);
                return false;
            }
        });
        // xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx



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
        if (item.getItemId() == R.id.action_get_data) {
            if (isOnline()) {
                requestData(url);
            } else {
                Toast.makeText(this, "Network isn't available.", Toast.LENGTH_SHORT).show();
            }
        }

        return false;
    }



    private void requestData(String uri) {

        StringRequest request = new StringRequest(uri, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    trackList = TrackJSONParser.parseFeed(response);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                updateDisplay();
            }
        },
                new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError ex) {
                        Toast.makeText(MainActivity.this, ex.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);

      //  MyTask task = new MyTask();
      //  task.execute(uri);
    }


    protected void updateDisplay() {

        TrackAdapter adapter = new TrackAdapter(this, R.layout.searchresults, trackList);

        if (trackList == null) {

            Toast toast = Toast.makeText(MainActivity.this, "Apple does not know who they are, WTF?", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, -500);
                    toast.show();



        } else {

            setListAdapter(adapter);


        }
    }

    protected boolean isOnline()

    {

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();

        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        } else {
            return false;
        }

    }

   private class MyTask extends AsyncTask<String, String, String>  {

       @Override
       protected void onPreExecute() {

        //   updateDisplay("Starting task");

           if (tasks.size() == 0) {
               pb.setVisibility(View.VISIBLE);

           }

           tasks.add(this);
       }



       @Override
       protected String doInBackground(String... params) {

           String content = null;
           try {
               content = HttpManager.getData(params[0]);
           } catch (IOException e) {
               e.printStackTrace();
           }

           return content;

       }

       @Override
       protected void onPostExecute(String result) {

           try {
               trackList = TrackJSONParser.parseFeed(result);
           } catch (JSONException e) {
               e.printStackTrace();
           }



           updateDisplay();


           tasks.remove(this);

           if (tasks.size() == 0) {

               pb.setVisibility(View.INVISIBLE);
           }
       }

       @Override
       protected void onProgressUpdate(String... values) {

       //    updateDisplay(values[0]);

       }
   }

    @Override
    protected void attachBaseContext(Context newBase) {

        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));

    }




}
