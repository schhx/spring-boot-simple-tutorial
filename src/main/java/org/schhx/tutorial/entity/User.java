package org.schhx.tutorial.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author shanchao
 * @date 2020-04-04
 */
@Data
@Accessors(chain = true)
public class User {

    private String id;

    private String username;

    private Integer age;
}
