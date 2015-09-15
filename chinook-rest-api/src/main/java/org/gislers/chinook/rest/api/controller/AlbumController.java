package org.gislers.chinook.rest.api.controller;

import org.gislers.chinook.service.AlbumService;
import org.gislers.chinook.service.dto.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by:   jgisle
 * Created date: 9/8/15
 */
@Controller
@RequestMapping(value = "/api/album")
public class AlbumController {

    private AlbumService albumService;

    @Autowired
    public void setAlbumService(AlbumService albumService) {
        this.albumService = albumService;
    }

    @RequestMapping(value = "/id/{albumId}", method = RequestMethod.GET)
    public ResponseEntity<Album> getAlbumById( @PathVariable("albumId") long albumId ) {
        Album album = albumService.findAlbum(albumId);
        if( album == null ) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(album, HttpStatus.OK);
    }
}
