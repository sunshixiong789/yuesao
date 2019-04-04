package com.yuesao.yuesao.dao;

import com.yuesao.yuesao.model.PersonInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户
 * @author sunshixiong
 * @date 2019/3/11 21:10
 */
public interface PersonInfoDao extends JpaRepository<PersonInfo,Integer> {


}
