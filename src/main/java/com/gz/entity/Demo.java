package com.gz.entity;

import com.gz.crud.annotation.FieldName;
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

    @FieldName("note")
    private Integer id;

    @FieldName("name")
    private String name;

    @FieldName("sex")
    private String sex;

    @FieldName("num")
    private String num;

    // @Field("CONTACT_ID_LIST")
    private String contactList;
}
