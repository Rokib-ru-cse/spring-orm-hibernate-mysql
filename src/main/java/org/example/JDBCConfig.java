package org.example;

import org.example.dao.UserImple;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = {"org.example"})
public class JDBCConfig {

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(ds());
    }

    @Bean
    public DriverManagerDataSource ds() {
        DriverManagerDataSource d = new DriverManagerDataSource();
        d.setDriverClassName("com.mysql.cj.jdbc.Driver");
        d.setUrl("jdbc:mysql://localhost:3306/javafirst");
        d.setUsername("root");
        d.setPassword("");
        return d;
    }

//
//    @Bean
//    public UserImple getUserDao() {
//        return new UserImple(getJdbcTemplate());
//    }
}
