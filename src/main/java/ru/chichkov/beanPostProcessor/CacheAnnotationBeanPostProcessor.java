package ru.chichkov.beanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import ru.chichkov.Annotation.Cache;
import ru.chichkov.reflection.Reflections;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

// Задача 9.3.5
@Component
public class CacheAnnotationBeanPostProcessor implements BeanPostProcessor {
    private List<String> beanNames = new ArrayList<>();
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Method[] methods = bean.getClass().getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Cache.class)) {
                beanNames.add(beanName);
                return bean;
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanNames.contains(beanName)) {
            return Reflections.cache(bean, bean.getClass());
        }
        return bean;
    }
}
