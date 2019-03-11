package com.yuesao.yuesao.controller;

import com.yuesao.yuesao.dao.CuitUserDao;
import com.yuesao.yuesao.model.CuitUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author sunshixiong
 * @date 2019/3/11 23:06
 */
@Slf4j
@RestController
@RequestMapping(value = "/user")
public class UserController {

  @Autowired
  private PasswordEncoder passwordEncoder;
  @Autowired
  private CuitUserDao cuitUserDao;

  /**
   * 增加一条数据
   * @see   @Valid使Hibernate Validator生效(调试的时候，spring data jpa 也会做一次验证，具体有待研究)
   * @param entity
   * @return
   */
  @PostMapping
  public CuitUser add(@Valid @RequestBody CuitUser entity) {

    entity.setPassWord(passwordEncoder.encode(entity.getPassWord()));
    return cuitUserDao.saveAndFlush(entity);
  }
}
