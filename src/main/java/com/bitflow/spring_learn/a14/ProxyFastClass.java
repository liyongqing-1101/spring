package com.bitflow.spring_learn.a14;

import org.springframework.cglib.core.Signature;
import org.springframework.cglib.reflect.FastClass;

/**
 * ProxyFastClass class
 *
 * @author liyongqing
 * @date 2023/8/30
 */

public class ProxyFastClass {

    public int getIndex(Signature signature) {
        return 1;
    }

    public Object invoke(int index, Object target, Object[] args) {
        return null;
    }

    public static void main(String[] args) {

    }

}
