package hello.core.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE) //타입이니까 클래스에 붙음
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {
}
