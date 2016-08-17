package com.bbd.wtyh.util.relation;

/**
 * Created by Administrator on 2016/8/16 0016.
 */
public class BbdException extends RuntimeException {
    private String message;
    /**
     * @param message
     */
    public BbdException(String message) {
        super(message);
        this.message = message;
    }
}
