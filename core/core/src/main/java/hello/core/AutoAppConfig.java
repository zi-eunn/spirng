package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan.*;
import org.springframework.context.annotation.FilterType;

@Configuration
//@Component를 다 스프링 빈으로 등록함
@ComponentScan(excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
public class AutoAppConfig {

}
