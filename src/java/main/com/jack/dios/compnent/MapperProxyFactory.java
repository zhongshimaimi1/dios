package com.jack.dios.compnent;

import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @Author: peng.du1
 * @Date: 2020/4/11 22:22
 */
public class MapperProxyFactory {



     public static <T> T getMapper(Class<T> type){
         if(type.isInterface()){
            return  (T)Proxy.newProxyInstance(MapperProxyFactory.class.getClassLoader(),new Class[] {type},new MapperProxy(type));
         }else{
             return null;
         }
    }
    
    public static void main(String[] args){
        PersonMapper mapper = MapperProxyFactory.getMapper(PersonMapper.class);
        int count = mapper.count();

    }
}
