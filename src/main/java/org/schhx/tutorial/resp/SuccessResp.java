package org.schhx.tutorial.resp;

/**
 * @author schhx
 * @date 2020-04-05
 */
public class SuccessResp extends BaseResp {

    private SuccessResp(Object data) {
        super(10000, "success", data);
    }

    public static SuccessResp of(Object data) {
        return new SuccessResp(data);
    }
}
