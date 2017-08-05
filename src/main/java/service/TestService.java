package service;

import org.springframework.beans.factory.annotation.Value;

public class TestService{
	
	@Value("${test.param}")
	private String teString = "abc";
	
	public String test(){
		System.out.println("this is test servcie");
//		Random random = new Random();
//		return "this is test service=" + random.nextFloat() * random.nextFloat();
		System.out.println(teString);
		return teString;
	}
	
}
