package com.smartdevs.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by johnnym on 30/05/15.
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MaxInputLengthValidator {
    int _1MB = 1 << 20;

    int value() default _1MB;
}
