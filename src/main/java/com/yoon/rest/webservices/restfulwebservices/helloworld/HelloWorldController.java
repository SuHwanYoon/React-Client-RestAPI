package com.yoon.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
//개별 크로스 오리진 설정 - class 단위 or  method단위에 지정가능
 //@CrossOrigin(origins = "http://localhost:3000" , allowCredentials = "true")
public class HelloWorldController {

	//기본인증 URL
	@GetMapping(path = "/basicauth")
	public String basicAuthCheck() {
		return "Success"; 
	}

	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World v2"; 
	}
	
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World Bean v1"); 
	}
	
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s", name)); 
	}	
}