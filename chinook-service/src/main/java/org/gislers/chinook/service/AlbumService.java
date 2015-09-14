package org.gislers.chinook.service;

import org.gislers.chinook.service.dto.Album;

/**
 * Created by jim
 * Created on 9/13/15.
 */
public interface AlbumService {

    Album findAlbum(long albumId);

}
