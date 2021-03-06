package org.schhx.tutorial.exception;

/**
 * @author schhx
 * @date 2020-04-05
 */
public abstract class BaseException extends RuntimeException {

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public abstract int getCode();
}
