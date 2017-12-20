package com.chenfeng.app.springbootvue.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.AbstractEndpoint;
import org.springframework.boot.actuate.health.HealthAggregator;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HealthConfig extends AbstractEndpoint<Integer> {

    public HealthConfig(){
        super("health_docker",
                false);
    }

    @Override
    public Integer invoke() {

        return 0;
    }
}
