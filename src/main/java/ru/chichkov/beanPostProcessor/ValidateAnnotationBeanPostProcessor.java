package ru.chichkov.beanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import ru.chichkov.Annotation.Validate;
import ru.chichkov.reflection.Reflections;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

// Задача 9.3.4
@Component
public class ValidateAnnotationBeanPostProcessor implements BeanPostProcessor {
    private List<String> beanNames = new ArrayList<>();
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Method[] methods = bean.getClass().getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Validate.class)) {
                beanNames.add(beanName);
                return bean;
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanNames.contains(beanName)) {
            Reflections.validate(bean);
        }
        return bean;
    }
}
