package comapps.com.musicsearch;

/**
 * Created by me on 9/25/2015.
 */
public class Track {
    /**
     * wrapperType : track
     * kind : song
     * artistId : 83964
     * collectionId : 189218996
     * trackId : 189219134
     * artistName : Tom Waits
     * collectionName : Mule Variations
     * trackName : Hold On
     * collectionCensoredName : Mule Variations
     * trackCensoredName : Hold On
     * artistViewUrl : https://itunes.apple.com/us/artist/tom-waits/id83964?uo=4
     * collectionViewUrl : https://itunes.apple.com/us/album/hold-on/id189218996?i=189219134&uo=4
     * trackViewUrl : https://itunes.apple.com/us/album/hold-on/id189218996?i=189219134&uo=4
     * previewUrl : http://a1307.phobos.apple.com/us/r1000/091/Music/4a/d0/25/mzm.wysvhueq.aac.p.m4a
     * artworkUrl30 : http://is5.mzstatic.com/image/thumb/Music/b7/c3/06/mzi.qenwsmmj.jpg/30x30bb-85.jpg
     * artworkUrl60 : http://is2.mzstatic.com/image/thumb/Music/b7/c3/06/mzi.qenwsmmj.jpg/60x60bb-85.jpg
     * artworkUrl100 : http://is3.mzstatic.com/image/thumb/Music/b7/c3/06/mzi.qenwsmmj.jpg/100x100bb-85.jpg
     * collectionPrice : 9.99
     * trackPrice : 1.29
     * releaseDate : 1999-04-16T07:00:00Z
     * collectionExplicitness : notExplicit
     * trackExplicitness : notExplicit
     * discCount : 1
     * discNumber : 1
     * trackCount : 16
     * trackNumber : 3
     * trackTimeMillis : 333627
     * country : USA
     * currency : USD
     * primaryGenreName : Rock
     * radioStationUrl : https://itunes.apple.com/station/idra.189219134
     * isStreamable : true
     */

    private String wrapperType;
    private String kind;
    private int artistId;
    private int collectionId;
    private int trackId;
    private String artistName;
    private String collectionName;
    private String trackName;
    private String collectionCensoredName;
    private String trackCensoredName;
    private String artistViewUrl;
    private String collectionViewUrl;
    private String trackViewUrl;
    private String previewUrl;
    private String artworkUrl30;
    private String artworkUrl60;
    private String artworkUrl100;
    private double collectionPrice;
    private double trackPrice;
    private String releaseDate;
    private String collectionExplicitness;
    private String trackExplicitness;
    private int discCount;
    private int discNumber;
    private int trackCount;
    private int trackNumber;
    private int trackTimeMillis;
    private String country;
    private String currency;
    private String primaryGenreName;
    private String radioStationUrl;
    private boolean isStreamable;

    public void setWrapperType(String wrapperType) {
        this.wrapperType = wrapperType;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public void setCollectionId(int collectionId) {
        this.collectionId = collectionId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public void setCollectionCensoredName(String collectionCensoredName) {
        this.collectionCensoredName = collectionCensoredName;
    }

    public void setTrackCensoredName(String trackCensoredName) {
        this.trackCensoredName = trackCensoredName;
    }

    public void setArtistViewUrl(String artistViewUrl) {
        this.artistViewUrl = artistViewUrl;
    }

    public void setCollectionViewUrl(String collectionViewUrl) {
        this.collectionViewUrl = collectionViewUrl;
    }

    public void setTrackViewUrl(String trackViewUrl) {
        this.trackViewUrl = trackViewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    public void setArtworkUrl30(String artworkUrl30) {
        this.artworkUrl30 = artworkUrl30;
    }

    public void setArtworkUrl60(String artworkUrl60) {
        this.artworkUrl60 = artworkUrl60;
    }

    public void setArtworkUrl100(String artworkUrl100) {
        this.artworkUrl100 = artworkUrl100;
    }

    public void setCollectionPrice(double collectionPrice) {
        this.collectionPrice = collectionPrice;
    }

    public void setTrackPrice(double trackPrice) {
        this.trackPrice = trackPrice;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setCollectionExplicitness(String collectionExplicitness) {
        this.collectionExplicitness = collectionExplicitness;
    }

    public void setTrackExplicitness(String trackExplicitness) {
        this.trackExplicitness = trackExplicitness;
    }

    public void setDiscCount(int discCount) {
        this.discCount = discCount;
    }

    public void setDiscNumber(int discNumber) {
        this.discNumber = discNumber;
    }

    public void setTrackCount(int trackCount) {
        this.trackCount = trackCount;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    public void setTrackTimeMillis(int trackTimeMillis) {
        this.trackTimeMillis = trackTimeMillis;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setPrimaryGenreName(String primaryGenreName) {
        this.primaryGenreName = primaryGenreName;
    }

    public void setRadioStationUrl(String radioStationUrl) {
        this.radioStationUrl = radioStationUrl;
    }

    public void setIsStreamable(boolean isStreamable) {
        this.isStreamable = isStreamable;
    }

    public String getWrapperType() {
        return wrapperType;
    }

    public String getKind() {
        return kind;
    }

    public int getArtistId() {
        return artistId;
    }

    public int getCollectionId() {
        return collectionId;
    }

    public int getTrackId() {
        return trackId;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public String getTrackName() {
        return trackName;
    }

    public String getCollectionCensoredName() {
        return collectionCensoredName;
    }

    public String getTrackCensoredName() {
        return trackCensoredName;
    }

    public String getArtistViewUrl() {
        return artistViewUrl;
    }

    public String getCollectionViewUrl() {
        return collectionViewUrl;
    }

    public String getTrackViewUrl() {
        return trackViewUrl;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public String getArtworkUrl30() {
        return artworkUrl30;
    }

    public String getArtworkUrl60() {
        return artworkUrl60;
    }

    public String getArtworkUrl100() {
        return artworkUrl100;
    }

    public double getCollectionPrice() {
        return collectionPrice;
    }

    public double getTrackPrice() {
        return trackPrice;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getCollectionExplicitness() {
        return collectionExplicitness;
    }

    public String getTrackExplicitness() {
        return trackExplicitness;
    }

    public int getDiscCount() {
        return discCount;
    }

    public int getDiscNumber() {
        return discNumber;
    }

    public int getTrackCount() {
        return trackCount;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public int getTrackTimeMillis() {
        return trackTimeMillis;
    }

    public String getCountry() {
        return country;
    }

    public String getCurrency() {
        return currency;
    }

    public String getPrimaryGenreName() {
        return primaryGenreName;
    }

    public String getRadioStationUrl() {
        return radioStationUrl;
    }

    public boolean getIsStreamable() {
        return isStreamable;
    }
}
