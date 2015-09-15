package org.gislers.chinook.rest.api.controller;

import org.gislers.chinook.service.ArtistService;
import org.gislers.chinook.service.dto.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by:   jgisle
 * Created date: 9/15/15
 */
@RestController
@RequestMapping(value="/api/artist")
public class ArtistController {

    private ArtistService artistService;

    @Autowired
    public void setArtistService(ArtistService artistService) {
        this.artistService = artistService;
    }

    @RequestMapping(
            value = "/id/{artistId}",
            method = RequestMethod.GET,
            produces= MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Artist> getArtistById( @PathVariable("artistId") long artistId ) {
        Artist artist = artistService.findArtist(artistId);
        if( artist == null ) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(artist, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/",
            method = RequestMethod.GET,
            produces= MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<Artist>> getAllArtists() {
        return new ResponseEntity<>(artistService.getAllArtists(), HttpStatus.OK);
    }
}
