package com.exception;

public class DataServiceException extends RuntimeException{

    public DataServiceException(String msg, Throwable cause) {
        super(msg,cause);
    }

    public DataServiceException(String msg) {

        super(msg);
    }
    public DataServiceException() {
        super();
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }


    @Override
    public synchronized Throwable getCause() {
        return super.getCause();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
