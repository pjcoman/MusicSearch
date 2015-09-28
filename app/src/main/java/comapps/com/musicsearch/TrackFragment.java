package comapps.com.musicsearch;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;

import java.util.List;

/**
 * Created by me on 9/27/2015.
 */
public class TrackFragment extends ListFragment {


    List<Track> trackList;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String uri = this.getActivity().getIntent().getStringExtra("URI_TO_SEARCH");

//        Log.d("Url is ", uri);

        requestData(uri);

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
                        Toast.makeText(getActivity(), ex.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });

        RequestQueue queue = Volley.newRequestQueue(getActivity());
        queue.add(request);


    }


    protected void updateDisplay() {



        TrackAdapter adapter = new TrackAdapter(TrackFragment.this.getActivity(), R.layout.searchresults, trackList);

        if (trackList == null) {

            Toast toast = Toast.makeText(getActivity(), "Apple does not know who they are, WTF?", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();



        } else {

            setListAdapter(adapter);


        }
    }





    }

