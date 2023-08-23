package com.bitflow.spring_learn.a05;

import com.alibaba.druid.pool.DruidDataSource;
import com.bitflow.spring_learn.a05.component.Bean2;
import com.bitflow.spring_learn.a05.mapper.Mapper1;
import com.bitflow.spring_learn.a05.mapper.Mapper2;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Config class
 *
 * @author liyongqing
 * @date 2023/8/23
 */
@Configuration
@ComponentScan("com.bitflow.spring_learn.a05.component")
public class Config {

    public Bean2 bean2() {
        return new Bean2();
    }

    @Bean
    public Bean1 bean1() {
        return new Bean1();
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }

    @Bean(initMethod = "init")
    public DruidDataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/ssm?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        return dataSource;
    }

    @Bean
    public MapperFactoryBean<Mapper1> mapper1(SqlSessionFactory sqlSessionFactory) {
        MapperFactoryBean<Mapper1> factory = new MapperFactoryBean<>(Mapper1.class);
        factory.setSqlSessionFactory(sqlSessionFactory);
        return factory;
    }

//    @Bean
//    public MapperFactoryBean<Mapper2> mapper2(SqlSessionFactory sqlSessionFactory) {
//        MapperFactoryBean<Mapper2> factory = new MapperFactoryBean<>(Mapper2.class);
//        factory.setSqlSessionFactory(sqlSessionFactory);
//        return factory;
//    }


}
