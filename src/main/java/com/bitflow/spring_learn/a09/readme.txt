
1 一个scope为singleton的bean不能注入其他scope的bean，必须要:
        （1）@Lazy注解 创建代理   <推荐>
        （2）@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
        （3）private ObjectFactory<F3> f3;  // 使用 ObjectFactory
        （4）通过注入 ApplicationContext, 通过context获取