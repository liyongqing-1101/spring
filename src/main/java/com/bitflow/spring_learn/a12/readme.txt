
1 jdk动态代理: 代理对象（类）和目标对象（类）是兄弟关系，都实现了接口
  cglib动态代理：代理对象和目标对象是子父类关系
  // cglib代理的限制是目标类不能是final修饰的，否则会报错：java.lang.IllegalArgumentException
  // 父类方法也不能是final的，否则不能增强