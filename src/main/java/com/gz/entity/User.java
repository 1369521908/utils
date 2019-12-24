package com.gz.entity;

import com.gz.crud.annotation.FieldIgnore;
import com.gz.crud.annotation.Table;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Table("user")
public class User implements Serializable {

    private static final long serialVersionUID = 4221940750991557547L;

    private Long id = 0L;

    /**
     * 性别
     */
    private String sex;

    /**
     * 账号
     */
    private String account = "";

    /**
     * 姓名
     */
    private String username = "";

    /**
     * 密码
     */
    private String password = "";

    /**
     * 标签
     */
    private String tag = "";

    /**
     * 头像
     */
    private String avatar = "";

    /**
     * 联系人列表
     */
    private String contactIdList;

    /**
     * 图片列表
     */
    private String pictureList;

    /**
     * 添加时间
     */
    private Date date = new Date();

    /**
     * token令牌
     */
    @FieldIgnore
    private String token = "";
}
