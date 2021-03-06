package suncodes.spring.aop.proxyfactorybean.jdk.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * TODO 注册成一个bean
 */
@Component
@Slf4j
public class LogAdvice implements MethodBeforeAdvice {

    /**
     * 前置通知
     * @param method
     * @param objects
     * @param o
     * @throws Throwable
     */
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        log.info("proxyFactoryBean前置通知：目标类：{}，方法名：{}，参数：{}",
                o.getClass().getName(), method.getName(), objects);
    }
}
