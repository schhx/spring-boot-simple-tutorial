package org.schhx.tutorial.req;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author schhx
 * @date 2020-04-05
 */
@Data
@Accessors(chain = true)
public class UpdateUserReq {

    @NotBlank(message = "id不能为空")
    private String id;

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotNull(message = "年龄不能为空")
    @Min(value = 18, message = "年龄不能小于18岁")
    @Max(value = 60, message = "年龄不能大于60岁")
    private Integer age;
}
