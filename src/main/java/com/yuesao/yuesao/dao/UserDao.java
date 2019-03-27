package com.yuesao.yuesao.dao;

import com.yuesao.yuesao.model.PersonInfo;
import com.yuesao.yuesao.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 描述：
 * yonghu
 *
 * @author sunshixiong
 * @date 2019/3/27-13:55
 */
public interface UserDao extends JpaRepository<User,Integer> {
}
