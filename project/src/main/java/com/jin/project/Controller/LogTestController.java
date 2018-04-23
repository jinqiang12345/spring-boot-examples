package com.jin.project.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jin.project.ExceptionEnum;
import com.jin.project.NoPermissions;

@RestController
public class LogTestController {
	
	protected static Logger logger = LoggerFactory.getLogger(HelloController.class);

	@RequestMapping("/test")
	public String Test(@RequestParam(value="role") Integer role) throws Exception {
		logger.info("visit controller");
		int i = role;
		if(i < 0) {
			throw new NoPermissions(ExceptionEnum.WRONG_PERMISSONS.toString());
		}
		else {
			return "666";
		}
	}
}
