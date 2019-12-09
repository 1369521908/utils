package com.gz.entity;

import com.gz.crud.annotation.Field;
import com.gz.crud.annotation.Table;
import lombok.Data;

/**
 * @Author Destiny_Xue
 * @Date 2019/12/7 19:47
 * @Description
 */
@Data
@Table("demo")
public class Demo extends Base {

    @Field("note")
    private Integer id;

    @Field("name")
    private String name;

    @Field("sex")
    private String sex;

    @Field("num")
    private String num;

    // @Field("CONTACT_ID_LIST")
    private String contactList;
}
