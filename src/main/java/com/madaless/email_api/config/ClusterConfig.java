package com.madaless.email_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.core.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;


/**
 * @author dpoddar
 */
@Configuration
@EnableCassandraRepositories(basePackages = "com.madaless.email_api.repository")
@ComponentScan(basePackages = "com.madaless.email_api")
@Profile("cassandra")
public class ClusterConfig extends AbstractCassandraConfiguration {

  @Override
  protected String getKeyspaceName() {
    return "marciszewski";
  }


  @Override
  @Bean
  public CassandraClusterFactoryBean cluster() {
    final CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
    cluster.setContactPoints("cassandra:3.11.5");
    cluster.setPort(9042);
    //LOGGER.info("Cluster created with contact points [" + environment.getProperty("cassandra.contactpoints") + "] " + "& port [" + Integer.parseInt(environment.getProperty("cassandra.port")) + "].");
    return cluster;
  }

  @Override
  @Bean
  public CassandraMappingContext cassandraMapping() throws ClassNotFoundException {
    return new BasicCassandraMappingContext();
  }
}