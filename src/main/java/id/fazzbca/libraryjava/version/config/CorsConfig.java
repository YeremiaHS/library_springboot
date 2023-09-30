package id.fazzbca.libraryjava.version.config;

import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import org.springframework.context.annotation.Configuration;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        CorsRegistration corsRegristration = registry.addMapping("/**");
        corsRegristration.allowedMethods("*");
        corsRegristration.allowedOriginPatterns("*");
    }
}
