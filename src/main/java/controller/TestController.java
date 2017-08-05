package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.TestService;
import util.SpringUtils;

@Controller
@RequestMapping(value="/Test")
public class TestController{
	
	@RequestMapping(value="/test.do")
	@ResponseBody
	public String test(HttpServletRequest request){
		TestService testService = SpringUtils.getBean("testService");
		return testService.test();
	}
}
