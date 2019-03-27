package com.yuesao.yuesao.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * 描述：
 * 用户信息
 *
 * @author sunshixiong
 * @date 2019/3/27-13:53
 */
@Data
@Entity
public class User {

  @Id
  @GeneratedValue
  private Integer id;

  private String name;

  private String passWorld;
}
