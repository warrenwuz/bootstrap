package com.warren.bootstrap.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author wuzhe1159@163.com
 * @date 2018/11/2 9:06
 */
public class MagicExistsCondition implements Condition {
	@Override
	public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
		Environment environment =conditionContext.getEnvironment();
		return environment.containsProperty("magic");
	}
}
