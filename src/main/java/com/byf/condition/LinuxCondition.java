package com.byf.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class LinuxCondition implements Condition {
    /**
     * ConditionContext：判断条件能使用上下文（环境）
     * AnnotatedTypeMetada：注释信息
     * @param context
     * @param metadata
     * @return
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment environment = context.getEnvironment();
        //4、获取bean定义的注册类
        BeanDefinitionRegistry beanDefinitionRegistry = context.getRegistry();
        String os = environment.getProperty("os.name");
        if (os.contains("Linux")){
            return true;
        }
        return false;
    }
}
