package com.jin.project;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
@Aspect
public class UserAccessAspect {

	@Pointcut(value="@annotation(com.jin.project.UserAccess)")
	public void access() {
		
	}
	
	@Before("access()")
	public void doBefore(JoinPoint joinPoint) throws Throwable {
		System.out.println("second before");
	}
	
	@Around("@annotation(userAccess)")
	public Object around(ProceedingJoinPoint point, UserAccess userAccess) {
		
		ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		System.out.println(request.getRequestURI().toString());
		System.out.println(request.getMethod());
		System.err.println(request.getHeader("key"));
		System.out.println("second around" + userAccess.desc());
		try {
			return point.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
			return null;// TODO: handle exception
		}
	}
}
