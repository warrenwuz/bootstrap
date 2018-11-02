package com.warren.bootstrap.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jndi.JndiObjectFactoryBean;

import javax.sql.DataSource;

/**
 * @author wuzhe1159@163.com
 * @date 2018/11/1 20:10
 */
@Configuration
public class DataSourceConfig {
	@Bean
	@Profile("dev")
	public DataSource embeddedDataSource() {
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("classpath:schema.sql").addScript("classpath:test-data.sql").build();
	}
	@Bean
	@Profile("prod")
	public DataSource jndiDataSource(){
		JndiObjectFactoryBean jndiObjectFactoryBean=new JndiObjectFactoryBean();
		jndiObjectFactoryBean.setJndiName("jdbc/myDs");
		jndiObjectFactoryBean.setResourceRef(true);
		jndiObjectFactoryBean.setProxyInterface(javax.sql.DataSource.class);
		return (DataSource) jndiObjectFactoryBean.getObject();

	}

}
