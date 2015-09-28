package comapps.com.musicsearch;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by me on 9/25/2015.
 */
class TrackAdapter extends ArrayAdapter<Track> {

    private final Context context;
    private final List<Track> trackList;


    public TrackAdapter(Context context, List<Track> objects) {

        super(context, R.layout.searchresults, objects);
        this.context = context;
        this.trackList = objects;


    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent)  {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.searchresults, parent, false);

        Track track = trackList.get(position);
        final TextView tvTrackName = (TextView) view.findViewById(R.id.textViewTrackName);
        tvTrackName.setText(track.getTrackName());
        final TextView tvArtistName = (TextView) view.findViewById(R.id.textViewArtistName);
        tvArtistName.setText(track.getArtistName());
        final TextView tvAlbumName = (TextView) view.findViewById(R.id.textViewAlbumName);
        tvAlbumName.setText(track.getCollectionName());

        ImageView imageview = (ImageView) view.findViewById(R.id.imageView);




        Picasso.with(context).load(trackList.get(position).getArtworkUrl100()).fit().into(imageview);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intentShowLyrics = new Intent(context, ShowLyricsWebView.class);
                intentShowLyrics.putExtra("info", tvTrackName.getText() + "|" + tvArtistName.getText() + "|" + tvAlbumName.getText()
                        + "|" + trackList.get(position).getArtworkUrl100());

                context.startActivity(intentShowLyrics);
                ((Activity) context).overridePendingTransition(R.anim.fadeinanimationlong, R.anim.fadeoutanimation);


            }


        });

        return view;

    }

}
