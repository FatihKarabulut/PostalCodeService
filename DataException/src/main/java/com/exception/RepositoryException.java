package com.exception;

public class RepositoryException extends RuntimeException{

    public RepositoryException(String msg, Throwable cause) {
        super(msg,cause);
    }

    public RepositoryException(String msg) {

        super(msg);
    }
    public RepositoryException() {
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
