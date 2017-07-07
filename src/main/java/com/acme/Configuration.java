package com.acme;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Taras Oleksiuk
 * @since 05.07.2017
 */

@org.springframework.context.annotation.Configuration
@EnableJpaRepositories(basePackages = "com.acme.repository")
@EntityScan(basePackages = "com.acme.entity")


public class Configuration {

}
