package com.yuesao.yuesao.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;


/**
 * Table:
 * @author sunshixiong on 2018/01/30.
 */
@Entity
@Data
public class CuitUser{
	@Id
	@GeneratedValue
   	private Integer id;
	private String userName;
	private String passWord;
	private String name;
	private String email;
	private String mobile;
	private String photo;
	private String sex;
	private String birthday;
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	private Timestamp creatTime;
	private String authority;
	private String description;
}