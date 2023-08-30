package com.bitflow.spring_learn.a13;

import com.bitflow.spring_learn.a13.A13.Foo;

import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;

/**
 * $Proxy0 class
 *
 * @author liyongqing
 * @date 2023/8/25
 */

public class $Proxy0 implements Foo {
    /**
     * Constructs a new {@code Proxy} instance from a subclass
     * (typically, a dynamic proxy class) with the specified value
     * for its invocation handler.
     *
     * @param h the invocation handler for this proxy instance
     * @throws NullPointerException if the given invocation handler, {@code h},
     *                              is {@code null}.
     */
//    protected $Proxy0(InvocationHandler h) {
//        super(h);
//    }

     private A13.InvocationHandler h;

    public $Proxy0(A13.InvocationHandler h) {
        this.h = h;
    }

    @Override
    public void foo() {
        try {
            h.invoke(this, foo, new Object[0]);
        } catch (RuntimeException | Error e) {
            throw e;
        } catch (Throwable e) { // 检查时异常
            throw new UndeclaredThrowableException(e); // 转换成运行时异常
        }
    }

    @Override
    public int bar() {
        try {
            Object result = h.invoke(this, bar, new Object[0]);
            return (int) result;
        } catch (RuntimeException | Error e) {
            throw e;
        } catch (Throwable e) { // 检查时异常
            throw new UndeclaredThrowableException(e); // 转换成运行时异常
        }
    }

    static Method foo;
    static Method bar;
    static {
        try {
             foo = Foo.class.getMethod("foo");
             bar = Foo.class.getMethod("bar");
        } catch (NoSuchMethodException e) {
            throw new NoSuchMethodError(e.getMessage());
        }
    }
}
