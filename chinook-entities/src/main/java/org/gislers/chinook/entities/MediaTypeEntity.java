package org.gislers.chinook.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by:   jim
 * Created date: 9/6/15
 */
@Entity
@Table(name = "media_type", schema = "chinook")
public class MediaTypeEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="media_type_id")
    private long mediaTypeId;

    private String  name;

    @OneToMany(fetch= FetchType.LAZY, cascade= CascadeType.ALL, mappedBy="mediaTypeEntity")
    private List<TrackEntity> trackEntities;

    public MediaTypeEntity() {
    }

    public long getMediaTypeId() {
        return mediaTypeId;
    }

    public void setMediaTypeId(long mediaTypeId) {
        this.mediaTypeId = mediaTypeId;
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
