package org.springboot.annotation;


import org.springboot.config.WebServerAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ComponentScan
@Import(WebServerAutoConfiguration.class)
public @interface WenllarSpringbootApplication {
}
