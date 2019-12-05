package com.ssm.block.spring.spel;

import java.util.Map;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * 测试propertySource
 */
public class MainTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AppConfig.class);
		context.refresh();
		
		ExpressionParser parser = new SpelExpressionParser();
//		Expression exp = parser.parseExpression("'Hello World'"); 
		Expression exp = parser.parseExpression("new String('hello world').toUpperCase()"); 
		String message = (String) exp.getValue();
		System.out.println(message);
		
		Map inventorInfo = (Map) parser.parseExpression("{name:'Nikola',dob:'10-July-1856'}").getValue();
		System.out.println(inventorInfo);
	}
}

