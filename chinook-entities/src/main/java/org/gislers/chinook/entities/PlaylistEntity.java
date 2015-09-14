package org.gislers.chinook.entities;

import javax.persistence.*;

/**
 * Created by:   jim
 * Created date: 9/6/15
 */
@Entity
@Table(name = "playlist", schema = "chinook")
public class PlaylistEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="playlist_id")
    private long playlistId;

    private String  name;

    public PlaylistEntity() {
    }

    public long getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(long playlistId) {
        this.playlistId = playlistId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
