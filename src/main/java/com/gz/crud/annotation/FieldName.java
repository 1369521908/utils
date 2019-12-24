package com.gz.crud.annotation;

import java.lang.annotation.*;

/**
 * @author
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE})
public @interface FieldName {

    /**
     * 手动映射的数据库字段名称
     *
     * @return
     */
    String value();

}
