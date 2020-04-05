package org.schhx.tutorial.service;

import org.schhx.tutorial.entity.User;

/**
 * @author shanchao
 * @date 2020-04-04
 */
public interface UserService {

    /**
     * 新增用户
     * @param username
     * @param age
     * @return
     */
    User create(String username, int age);

    /**
     * 删除用户
     * @param id
     */
    void delete(String id);

    /**
     * 修改用户
     * @param id
     * @param username
     * @param age
     * @return
     */
    User update(String id, String username, int age);

    /**
     * 查询用户
     * @param id
     * @return
     */
    User getById(String id);
}
