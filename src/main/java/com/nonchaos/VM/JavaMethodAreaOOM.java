package com.nonchaos.VM;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 测试方法区内存溢出异常
 * VM Args：
 * -XX:PermSize=10M
 * -XX:MaxPermSize=10M
 */
public class JavaMethodAreaOOM {
  static class OOMObject {
  }
  public static void main(String[] args) {
    while (true) {
      Enhancer enhancer = new Enhancer();
      enhancer.setSuperclass(OOMObject.class);
      enhancer.setUseCache(false);
      enhancer.setCallback(new MethodInterceptor() {
        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
            throws Throwable {
          return methodProxy.invokeSuper(o, objects);
        }
      });
      enhancer.create();
    }
  }
}
