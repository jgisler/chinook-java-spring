package org.gislers.chinook.entities;

import javax.persistence.*;

/**
 * Created by:   jim
 * Created date: 9/6/15
 */
@Entity
@Table(name = "playlist_track", schema = "chinook")
public class PlaylistTrackEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="playlist_track_id")
    private long playlistTrackId;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="playlist_id")
    private PlaylistEntity playlistEntity;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="track_id")
    private TrackEntity trackEntity;

    public PlaylistTrackEntity() {
    }

    public long getPlaylistTrackId() {
        return playlistTrackId;
    }

    public void setPlaylistTrackId(long playlistTrackId) {
        this.playlistTrackId = playlistTrackId;
    }

    public PlaylistEntity getPlaylistEntity() {
        return playlistEntity;
    }

    public void setPlaylistEntity(PlaylistEntity playlistEntity) {
        this.playlistEntity = playlistEntity;
    }

    public TrackEntity getTrackEntity() {
        return trackEntity;
    }

    public void setTrackEntity(TrackEntity trackEntity) {
        this.trackEntity = trackEntity;
    }
}
