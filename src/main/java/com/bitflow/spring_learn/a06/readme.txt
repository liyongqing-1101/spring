
1 Aware 接口
    a. BeanNameAware    注入 bean 的名字

    b. BeanFactoryAware 注入 BeanFactory容器
    c. ApplicationContextAware
    d. EmbeddedValueResolvedAware ${}

    e. BeanClassLoaderAware

2 有同学说：b c d 的功能用 @Autowired 就能实现，为啥还要用 Aware 接口呢？
    简单地说：
        2.1 @Autowired 的解析需要用到 bean 后处理器，属于扩展功能
        2.2 而 Aware 接口属于内置功能，不加任何扩展，Spring能识别
    某些情况下，扩展功能会失效，但内置功能不会失效

    例1：你会发现用 Aware 注入 ApplicationContext 成功，而 @Autowired 注入会失败
