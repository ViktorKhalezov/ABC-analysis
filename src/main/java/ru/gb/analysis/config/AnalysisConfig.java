package ru.gb.analysis.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import ru.gb.analysis.service.ProductGateway;

@Configuration
@EnableFeignClients(basePackageClasses = {ProductGateway.class})
public class AnalysisConfig {

}
