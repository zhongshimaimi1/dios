package com.jack.dios.compnent;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: peng.du1
 * @Date: 2020/4/11 22:14
 */
public class MapperProxy implements InvocationHandler {

    private Class<?> interfac;
    private Map<Method,MapperMethod> method2MapperMethod=new HashMap<>();

    public MapperProxy(Class interfac){
        this.interfac=interfac;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MapperMethod mapperMethod = method2MapperMethod.get(method);
        return mapperMethod.invoke();
    }
}
