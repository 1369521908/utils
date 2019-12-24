package com.gz.entity;

import com.gz.crud.annotation.FieldName;

import java.util.Date;

/**
 * @Author Destiny_Xue
 * @Date 2019/12/7 22:41
 * @Description
 */
public class Base {

    @FieldName("CREATION_DATE")
    private Date creationDate;

    @FieldName("LAST_UPDATED_DATE")
    private Date lastUpdatedDate;

    @FieldName("CREATED_BY")
    private String createdBy;

    @FieldName("LAST_UPDATED_BY")
    private String lastUpdatedBy;

}
