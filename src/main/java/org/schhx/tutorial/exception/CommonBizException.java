package org.schhx.tutorial.exception;

/**
 * @author shanchao
 * @date 2020-04-05
 */
public class CommonBizException extends BaseException {
    public CommonBizException(String message) {
        super(message);
    }

    public CommonBizException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public int getCode() {
        return 10001;
    }
}
