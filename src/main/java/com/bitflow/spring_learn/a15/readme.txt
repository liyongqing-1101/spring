
两个切面概念：

aspect =
        通知1（advice）+ 切点1（pointcut）
        通知2（advice）+ 切点2（pointcut）
        通知3（advice）+ 切点3（pointcut）
        ...
advisor = 更细粒度的切面，包含一个通知和切点


什么时候用jdk动态代理，什么时候用cglib代理呢？
    1. 创建代理
        a. proxyTargetClass = false, 如果目标实现了接口，用jdk实现
        b. proxyTargetClass = false, 如果目标没有实现接口，用cglib实现
        c. proxyTargetClass = true, 总是使用 cglib 实现