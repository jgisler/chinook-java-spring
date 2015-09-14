package org.gislers.chinook.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by:   jim
 * Created date: 9/6/15
 */
@Entity
@Table(name = "genre", schema = "chinook")
public class GenreEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="genre_id")
    private long genreId;

    private String name;

    @OneToMany(fetch= FetchType.LAZY, cascade= CascadeType.ALL, mappedBy="genreEntity")
    private List<TrackEntity> trackEntities;

    public GenreEntity() {
    }

    public long getGenreId() {
        return genreId;
    }

    public void setGenreId(long genreId) {
        this.genreId = genreId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TrackEntity> getTrackEntities() {
        return trackEntities;
    }

    public void setTrackEntities(List<TrackEntity> trackEntities) {
        this.trackEntities = trackEntities;
    }
}
