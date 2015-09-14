package org.gislers.chinook.service.exceptions;

/**
 * Created by jim
 * Created on 9/13/15.
 */
public class ChinookServiceException extends RuntimeException {

    public ChinookServiceException(String message) {
        super(message);
    }

    public ChinookServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
