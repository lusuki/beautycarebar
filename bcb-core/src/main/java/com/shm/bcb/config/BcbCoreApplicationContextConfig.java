package com.shm.bcb.config;

import cn.fanciers.sth.infrastructure.biz.config.BasicBizConfig;
import cn.fanciers.sth.infrastructure.config.CommonApplicationContextConfig;
import cn.fanciers.sth.infrastructure.config.security.EnbaleSthSecurityEncryption;
import cn.fanciers.sth.infrastructure.persist.jpa.hiberbate.interceptor.SthHibernateInterceptor;
import com.shm.bcb.core.service.BcbServices;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.annotation.Resource;

@Configuration
@EnableTransactionManagement
@EnbaleSthSecurityEncryption
@Import({ CommonApplicationContextConfig.class, BcbCoreJpaRepositoryConfig.class, BasicBizConfig.class})
@ComponentScan(basePackageClasses = { BcbServices.class })
public class BcbCoreApplicationContextConfig implements TransactionManagementConfigurer {
    public static final String PROJECT_NAME = "BCB";

    static {
        SthHibernateInterceptor.initApplicationName(PROJECT_NAME);
    }

    @Resource
    private PlatformTransactionManager transactionManager;

    @Override public PlatformTransactionManager annotationDrivenTransactionManager() {
        return this.transactionManager;
    }
}
