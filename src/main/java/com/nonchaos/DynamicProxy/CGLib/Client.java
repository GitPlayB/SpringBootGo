package com.nonchaos.DynamicProxy.CGLib;

import org.springframework.cglib.proxy.Enhancer;

public class Client {
  public static void main(String[] args) throws ClassNotFoundException {
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(HelloServiceImpl.class);
    enhancer.setCallback(new HelloMethodInterceptor());
    HelloServiceImpl helloService = (HelloServiceImpl)enhancer.create();
    helloService.sayHello();
    HelloMethodInterceptor a = new HelloMethodInterceptor();
    Class i = a.getClass();
    System.out.println(Class.forName(i.getName(), false, new ClassLoader() {
      @Override public Class<?> loadClass(String name) throws ClassNotFoundException {
        return super.loadClass(name);
      }
    }) == i);
  }
}
