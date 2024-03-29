package com.spot.refactoring.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "com.spot.refactoring")
@EnableJpaRepositories(basePackages = {"com.spot.refactoring"})
public class JpaConfig{
}
