package org.schhx.tutorial.resp;

import org.schhx.tutorial.exception.BaseException;

/**
 * @author shanchao
 * @date 2020-04-05
 */
public class ErrorResp extends BaseResp {

    private ErrorResp(BaseException e) {
        super(e.getCode(), e.getMessage(), e.getCause() == null ? e.getMessage() : e.getCause().getMessage());
    }

    public static ErrorResp of(BaseException e) {
        return new ErrorResp(e);
    }
}
