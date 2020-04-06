package org.schhx.tutorial.exception;

/**
 * @author schhx
 * @date 2020-04-06
 */
public class RequestException extends BaseException {
    public RequestException(String message) {
        super(message);
    }

    public RequestException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public int getCode() {
        return 10002;
    }
}
