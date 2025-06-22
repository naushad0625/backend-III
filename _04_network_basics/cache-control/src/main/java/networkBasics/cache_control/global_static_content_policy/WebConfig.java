package networkBasics.cache_control.global_static_content_policy;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;

/*
 * This class introduces global cache-control by configuring springMVC
 * This policy is used to serve static content like images, css etc.
 * */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static")
                .setCacheControl(
                        CacheControl.maxAge(3600, TimeUnit.SECONDS)
                                .sMaxAge(86000, TimeUnit.SECONDS)
                                .cachePublic()
                );
    }
}
