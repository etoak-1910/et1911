package com.etoak.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

/**
 * 全局异常处理器
 * 注解 @ControllerAdvice会在所有被@Controller注解的方法上加一个拦截器
 * 
 * @author lenovo
 *
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
	/**
	 * 表示只拦截ParamException.class异常
	 * @param e
	 * @return
	 */
	@ExceptionHandler(ParamException.class)
	public ModelAndView handleParamException(ParamException e) {
		
		//异常信息
		String message = e.getMessage();
		log.error(message,e);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("paramError",message);
		
		mv.setViewName("car/add");
		return mv;
	}
}
