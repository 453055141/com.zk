package com.zk.zkbootcrawler.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.util.Properties;

@Configuration
//@SpringBootApplication
// 扫描 Mapper 接口并容器管理
@MapperScan(basePackages = MasterDataSourceConfig.PACKAGE,sqlSessionFactoryRef = "masterSqlSessionFactory")
public class MasterDataSourceConfig {
    // 精确到 master 目录，以便跟其他数据源隔离
    static final String PACKAGE = "com.zk.zkbootpojo.mapper.masterMapper";
    static final String MAPPER_LOCATION = "classpath:com/zk/zkbootpojo/mapper/masterMapper/*.xml";


    @Value("${master.datasource.url}")
    private String url;

    @Value("${master.datasource.username}")
    private String user;

    @Value("${master.datasource.password}")
    private String password;

    @Value("${master.datasource.driverClassName}")
    private String driverClass;

//    //初始化数据库连接-无事务
//    @Bean(name = "masterDataSource")
//    @Primary
//    public DataSource masterDataSource() {
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setDriverClassName(driverClass);
//        dataSource.setUrl(url);
//        dataSource.setUsername(user);
//        dataSource.setPassword(password);
//        return dataSource;
//    }

    //初始化数据库连接-事务
    @Bean(name = "masterDataSource")
    @Primary
    public AtomikosDataSourceBean masterDataSource() {
        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setUniqueResourceName("masterDataSource");
        atomikosDataSourceBean.setXaDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlXADataSource");
//        atomikosDataSourceBean.setXaDataSourceClassName("com.alibaba.druid.pool.xa.DruidXADataSource");
        Properties properties = new Properties();
        properties.put("url",url);
        properties.put("user",user);
        properties.put("password",password);
        atomikosDataSourceBean.setXaProperties(properties);
        atomikosDataSourceBean.setPoolSize(3);
        atomikosDataSourceBean.setReapTimeout(20000);
        return atomikosDataSourceBean;
    }

//    //数据源事务管理器
//    @Bean(name = "masterTransactionManager")
//    @Primary
//    public DataSourceTransactionManager masterTransactionManager() {
//        return new DataSourceTransactionManager(masterDataSource());
//    }


    //创建Session -事务
    @Bean(name = "masterSqlSessionFactory")
    @Primary
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("masterDataSource") AtomikosDataSourceBean masterDataSource)
            throws Exception {
        //单例
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(masterDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(MasterDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }

}
