package cc.margay.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Gender {
    int value() default 0;
    String desc() default "not define gender";
}
