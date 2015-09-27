package comapps.com.musicsearch;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by me on 9/25/2015.
 */
public class TrackJSONParser {

    public static List<Track> parseFeed(String content) throws JSONException {

        try {

            JSONObject jsonObj = new JSONObject(content);

            JSONArray trackArray = jsonObj.getJSONArray("results");

         //   JSONArray trackArray = new JSONArray(content);
            List<Track> trackList = new ArrayList<>();

            for (int i = 0; i < trackArray.length(); i++) {

                JSONObject obj = trackArray.getJSONObject(i);
                Track track = new Track();

                track.setWrapperType(obj.getString("wrapperType"));
                track.setKind(obj.getString("kind"));
                track.setArtistId(obj.getInt("artistId"));
                track.setCollectionId(obj.getInt("collectionId"));
                track.setTrackId(obj.getInt("trackId"));
                track.setArtistName(obj.getString("artistName"));
                track.setCollectionName(obj.getString("collectionName"));
                track.setTrackName(obj.getString("trackName"));
                track.setCollectionCensoredName(obj.getString("collectionCensoredName"));
                track.setTrackCensoredName(obj.getString("trackCensoredName"));
                track.setArtistViewUrl(obj.getString("artistViewUrl"));
                track.setCollectionViewUrl(obj.getString("collectionViewUrl"));
                track.setTrackViewUrl(obj.getString("trackViewUrl"));
                track.setPreviewUrl(obj.getString("previewUrl"));
                track.setArtworkUrl30(obj.getString("artworkUrl30"));
                track.setArtworkUrl60(obj.getString("artworkUrl60"));
                track.setArtworkUrl100(obj.getString("artworkUrl100"));
                track.setCollectionPrice(obj.getDouble("collectionPrice"));
                track.setTrackPrice(obj.getDouble("trackPrice"));
                track.setReleaseDate(obj.getString("releaseDate"));
                track.setCollectionExplicitness(obj.getString("collectionExplicitness"));
                track.setTrackExplicitness(obj.getString("trackExplicitness"));
                track.setDiscCount(obj.getInt("discCount"));
                track.setDiscNumber(obj.getInt("discNumber"));
                track.setTrackCount(obj.getInt("trackCount"));
                track.setTrackNumber(obj.getInt("trackNumber"));
                track.setTrackTimeMillis(obj.getInt("trackTimeMillis"));
                track.setCountry(obj.getString("country"));
                track.setCurrency(obj.getString("currency"));
                track.setPrimaryGenreName(obj.getString("primaryGenreName"));
                track.setRadioStationUrl(obj.getString("radioStationUrl"));
                track.setIsStreamable(obj.getBoolean("isStreamable"));

                trackList.add(track);

            }

            return trackList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;

        }

    }
}
