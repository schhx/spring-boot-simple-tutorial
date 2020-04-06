package org.schhx.tutorial.resp;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author schhx
 * @date 2020-04-05
 */
@Data
@AllArgsConstructor
public abstract class BaseResp {

    private int code;

    private String message;

    private Object data;
}
