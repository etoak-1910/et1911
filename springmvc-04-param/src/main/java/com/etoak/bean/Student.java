package com.etoak.bean;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*@Getter//get方法
@Setter//set方法
@ToString//tostring方法
*/
@Data  //get set tostring
@NoArgsConstructor//无参构造方法
@AllArgsConstructor//有参构造方法

public class Student {
	private Integer id;
	
	private String name;
	
	private Integer age;
	
	private List<String> hobbyList;
	
	private Map<String,Object> stuMap;



}
