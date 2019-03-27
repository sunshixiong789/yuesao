package com.yuesao.yuesao.model;

import com.yuesao.yuesao.convert.JsonConverter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 简历信息
 * @author sunshixiong
 * @date 2019/3/11 19:47
 */
@Entity
@Data
@ApiModel(value = "用户简历")
public class PersonInfo {

  @Id
  @GeneratedValue
  @ApiModelProperty(value = "id")
  private Integer id;

  @ApiModelProperty(value = "姓名")
  private String name;

  @ApiModelProperty(value = "状态:空闲，工作中")
  private boolean status = true;

  @ApiModelProperty(value = "种类，月嫂 1，育儿嫂 2")
  private String kind;

  @ApiModelProperty(value = "价格")
  private String Price;

  @ApiModelProperty(value = "工作年限")
  @Convert(converter = JsonConverter.class)
  private Object workingLife;

  @ApiModelProperty(value = "头像")
  @Convert(converter = JsonConverter.class)
  private Object headPortrait;

  @ApiModelProperty(value = "性别")
  private String sex;
  @ApiModelProperty(value = "婚否")
  private String marriage;

  @ApiModelProperty(value = "籍贯")
  private String nativePlace;

  @ApiModelProperty(value = "出生日期")
  private String birthday;

  @ApiModelProperty(value = "健康状况")
  private String health;

  @ApiModelProperty(value = "省份证")
  private String idCard;

  @ApiModelProperty(value = "名族")
  private String nationalists;

  @ApiModelProperty(value = "身高")
  private String height;

  @ApiModelProperty(value = "体重")
  private String weight;

  @ApiModelProperty(value = "家庭住址")
  private String address;

  @ApiModelProperty(value = "参加培训")
  @Convert(converter = JsonConverter.class)
  private Object training;

  @ApiModelProperty(value = "政治面貌")
  @Convert(converter = JsonConverter.class)
  private Object politicsStatus;

  @ApiModelProperty(value = "户口所在地")
  private String domicilePlace;

  @ApiModelProperty(value = "文化程度")
  private String standardCulture;

  @ApiModelProperty(value = "月嫂服务-产妇护理")
  @Convert(converter = JsonConverter.class)
  private Object maternalCare;

  @ApiModelProperty(value = "月嫂服务-婴儿护理")
  @Convert(converter = JsonConverter.class)
  private Object babyCare;

  @ApiModelProperty(value = "职业道德")
  @Convert(converter = JsonConverter.class)
  private Object professionalEthics;

  @ApiModelProperty(value = "工作经验")
  @Convert(converter = JsonConverter.class)
  private Object workExperience;

  @ApiModelProperty(value = "生活照")
  @Convert(converter = JsonConverter.class)
  private Object lifePhotos;


}
