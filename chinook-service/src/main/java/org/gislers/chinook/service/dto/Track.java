package org.gislers.chinook.service.dto;

/**
 * Created by:   jgisle
 * Created date: 9/15/15
 */
public class Track {

    private long trackId;
    private String trackTitle;
    private long trackDuration;

    public Track() {
    }

    public long getTrackId() {
        return trackId;
    }

    public void setTrackId(long trackId) {
        this.trackId = trackId;
    }

    public String getTrackTitle() {
        return trackTitle;
    }

    public void setTrackTitle(String trackTitle) {
        this.trackTitle = trackTitle;
    }

    public long getTrackDuration() {
        return trackDuration;
    }

    public void setTrackDuration(long trackDuration) {
        this.trackDuration = trackDuration;
    }
}
