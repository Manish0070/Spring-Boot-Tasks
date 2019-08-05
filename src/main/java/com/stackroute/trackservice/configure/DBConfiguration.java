//package com.stackroute.trackservice.configure;
//
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Profile;
//
//@ConfigurationProperties(prefix = "app")
//
//public class DBConfiguration {
//    private String driverClassName;
//    private String url;
//    @Profile("dev")
//    @Bean
//    public String  devDbConfiguraton(){
//        System.out.println("DEV-DB-H2");
//        System.out.println(driverClassName);
//        System.out.println(url);
//        return "Data Base Connection for h2";
//    }
//    @Profile("dev")
//    @Bean
//    public String  devSqlConfig(){
//        System.out.println("DEV-DB-Sql");
//
//        return "Data Base Connection for sql";
//    }
//}
