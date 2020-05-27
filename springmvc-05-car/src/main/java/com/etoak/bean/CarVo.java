package com.etoak.bean;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CarVo extends Car {
	//级别名称
	private String levelName;
	//变速箱名称
	private String gearboxName;
	//排量名称
	private String outputVolumeName;
	//传到sql的条件
	@JsonIgnore //spring mvc 不返回带@JsonIgnore注解的属性
	private List<Map<String,Integer>> priceMapList;
	
	//接收前端的车龄条件
	@JsonIgnore //spring mvc 不返回带@JsonIgnore注解的属性
	private String vehicleAge;
	
	//传到sql的条件
	@JsonIgnore //spring mvc 不返回带@JsonIgnore注解的属性
	private Integer startYear;
	//传到sql的条件
	@JsonIgnore //spring mvc 不返回带@JsonIgnore注解的属性
	private Integer endYear;

}
