
1 初始化方法：
    a. @PostConstruct
    b. 实现 InitializingBean 接口
    c. 在 @Bean(initMethod = "init3")

    执行顺序：a b c

2 销毁方法
     a. @PreDestroy
     b. 实现 DisposableBean 接口
     c. 在 @Bean(destroyMethod = "destroy3")
