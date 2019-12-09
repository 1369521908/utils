package com.gz.entity;

import com.gz.crud.annotation.Field;

import java.util.Date;

/**
 * @Author Destiny_Xue
 * @Date 2019/12/7 22:41
 * @Description
 */
public class Base {

    @Field("CREATION_DATE")
    private Date creationDate;

    @Field("LAST_UPDATED_DATE")
    private Date lastUpdatedDate;

    @Field("CREATED_BY")
    private String createdBy;

    @Field("LAST_UPDATED_BY")
    private String lastUpdatedBy;

}
