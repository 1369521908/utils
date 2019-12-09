package com.gz.crud;

import cn.hutool.db.Page;

import java.util.List;

/**
 * @Author Destiny_Xue
 * @Date 2019/12/7 19:56
 * @Description
 */
public interface BaseMapper<T extends Class> {

    List<T> getAll();

    Page getPage();

    int insert();

    int update();

    int delete();
}
