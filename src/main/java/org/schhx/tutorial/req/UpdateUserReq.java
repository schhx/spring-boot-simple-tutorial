package org.schhx.tutorial.req;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author shanchao
 * @date 2020-04-05
 */
@Data
@Accessors(chain = true)
public class UpdateUserReq {

    private String id;

    private String username;

    private Integer age;
}
