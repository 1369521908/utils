package com.gz.crud.annotation;

import java.lang.annotation.*;

/**
 * @author
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.FIELD)
public @interface FieldIgnore {

    /**
     * 手动映射的数据库字段名称
     *
     * @return
     */
    boolean value() default true;

}
