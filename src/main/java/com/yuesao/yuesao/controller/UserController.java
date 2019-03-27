package com.yuesao.yuesao.controller;

import com.yuesao.yuesao.dao.UserDao;
import com.yuesao.yuesao.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述：
 * yonghu
 *
 * @author sunshixiong
 * @date 2019/3/27-13:56
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

  @Autowired
  UserDao userDao;

  @PostMapping
  public void addUser(@RequestBody User user){
    userDao.save(user);
  }
}
