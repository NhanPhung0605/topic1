package com.fpt.test.topic1.exception;

/**
 * @author : Admin
 * @created : 12-Aug-21
 **/
public class FileStorageException extends RuntimeException{
    public FileStorageException(String message){
        super(message);
    }
    public FileStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
