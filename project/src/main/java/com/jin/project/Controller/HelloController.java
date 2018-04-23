package com.jin.project.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jin.project.UserAccess;

@RestController
public class HelloController {

	@RequestMapping(value="/second")
	@UserAccess(desc="second")
	public String second() {
		return "second controller";
	}
}
