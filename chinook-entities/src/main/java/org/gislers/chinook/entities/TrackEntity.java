package org.gislers.chinook.entities;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by:   jim
 * Created date: 9/6/15
 */
@Entity
@Table(name = "track", schema = "chinook")
public class TrackEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="track_id")
    private long trackId;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="album_id")
    private AlbumEntity albumEntity;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="media_type_id")
    private MediaTypeEntity mediaTypeEntity;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="genre_id")
    private GenreEntity genreEntity;

    private String name;
    private String  composer;
    private Integer milliseconds;
    private Integer bytes;

    @Column(name="unit_price")
    private BigDecimal unitPrice;

    public TrackEntity() {
    }

    public long getTrackId() {
        return trackId;
    }

    public void setTrackId(long trackId) {
        this.trackId = trackId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public Integer getMilliseconds() {
        return milliseconds;
    }

    public void setMilliseconds(Integer milliseconds) {
        this.milliseconds = milliseconds;
    }

    public Integer getBytes() {
        return bytes;
    }

    public void setBytes(Integer bytes) {
        this.bytes = bytes;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public AlbumEntity getAlbumEntity() {
        return albumEntity;
    }

    public void setAlbumEntity(AlbumEntity albumEntity) {
        this.albumEntity = albumEntity;
    }

    public MediaTypeEntity getMediaTypeEntity() {
        return mediaTypeEntity;
    }

    public void setMediaTypeEntity(MediaTypeEntity mediaTypeEntity) {
        this.mediaTypeEntity = mediaTypeEntity;
    }

    public GenreEntity getGenreEntity() {
        return genreEntity;
    }

    public void setGenreEntity(GenreEntity genreEntity) {
        this.genreEntity = genreEntity;
    }
}
