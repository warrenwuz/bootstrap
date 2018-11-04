package com.warren.bootstrap.SpringEl;

import com.warren.bootstrap.bean.Student;
import lombok.extern.apachecommons.CommonsLog;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author wuzhe1159@163.com
 * @date 2018/11/2 16:42
 */
@RunWith(SpringRunner.class)
@Slf4j
public class SpringElTest {
	@Test
	public void testSpringEl(){
		ExpressionParser parser=new SpelExpressionParser();
		Expression expression = parser.parseExpression("'Hello World'.bytes.length");
	//	log.info(expression.getValue());
		Object value = parser.parseExpression("new String('hello world').toUpperCase()").getValue();
		log.info("解析值:{}",(String)value);
		GregorianCalendar calendar=new GregorianCalendar();
		calendar.set(1994,12,6);
		Student student=new Student("吴哲",calendar.getTime(),"中国");
			expression=parser.parseExpression("name");
			//表示一个context上下文 将student放入该上下文中
		EvaluationContext context=new StandardEvaluationContext(student);
		context.setVariable("name","wuzhe");
		//从context寻找符合该expression的表达式
		log.info("解析对象名字:{}",expression.getValue(context));
		log.info("解析名字:{}",expression.getValue(student));
		//可以解析一个BigDecimal 类
		expression=parser.parseExpression("10*(2+1)/4.5");
		log.info("SpEL表达式计算结果是:{}",expression.getValue(BigDecimal.class).setScale(2,BigDecimal.ROUND_HALF_UP));
		expression=parser.parseExpression("10*(2+1)/4.5<0?:20");
		log.info("?:计算结果:{}",expression.getValue());
		log.info("BigDecimal的进位结果：{}",new BigDecimal("20.81").setScale(1,BigDecimal.ROUND_UP));
	}
}
