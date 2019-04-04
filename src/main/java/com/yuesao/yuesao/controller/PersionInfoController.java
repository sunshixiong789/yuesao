package com.yuesao.yuesao.controller;

import com.yuesao.yuesao.dao.PersonInfoDao;
import com.yuesao.yuesao.model.PersonInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 月嫂详情
 *
 * @author sunshixiong
 * @date 2019/3/11 21:35
 */
@RestController
@RequestMapping(value = "/personInfo")
public class PersionInfoController {

  @Autowired
  PersonInfoDao personInfoDao;

  @GetMapping
  public Page<PersonInfo> getPersonInfo(PersonInfo entity
          , @PageableDefault(size = 500, sort = "id"
          , direction = Sort.Direction.ASC) Pageable pageable) {
    ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("name",matcher1 -> matcher1.contains()).withIgnorePaths("status");
    Example example = Example.of(entity,matcher);
    return personInfoDao.findAll(example, pageable);
  }

  /**
   * 修改
   * @param personInfo
   * @return
   */
  @PutMapping
  public PersonInfo upDataPersonInfo(@RequestBody PersonInfo personInfo){
    return personInfoDao.save(personInfo);
  }
  /**
   * 修改
   * @param personInfo
   * @return
   */
  @PostMapping
  public PersonInfo addPersonInfo(@RequestBody PersonInfo personInfo){
    personInfo.setStatus(true);
    return personInfoDao.save(personInfo);
  }

  @DeleteMapping
  public void deletePersonInfo(@RequestBody PersonInfo personInfo){
     personInfoDao.delete(personInfo);
  }
}
