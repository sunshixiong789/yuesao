package com.yuesao.yuesao.dao;

import com.yuesao.yuesao.model.CuitUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author sunshixiong
 * @date 2019/3/11 21:47
 */
public interface CuitUserDao extends JpaRepository<CuitUser,Integer> {

  public CuitUser findByUserName(String userName);

}
