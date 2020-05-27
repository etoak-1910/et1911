package com.etoak.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.etoak.bean.Car;
import com.etoak.bean.CarVo;
import com.etoak.bean.PageVo;

public interface CarService {
	
	int addCar(Car car);
	
	PageVo<CarVo> queryList(int pageNum,int pageSize,CarVo carVo, String[] priceList);
	
	//获取所有品牌
		List<String> getAllBrand();
		/**
		 * 根据品牌查询车系
		 * @param brand
		 * @return
		 */
		List<String> getSeriesByBrand(@Param("brand") String brand);

}
