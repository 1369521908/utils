package com.gz.crud.impl;

import cn.hutool.db.Page;
import com.gz.crud.BaseMapper;

import java.util.List;

/**
 * @Author Destiny_Xue
 * @Date 2019/12/7 19:58
 * @Description
 */
public class BaseMapperImpl<T extends Class> implements BaseMapper {


    @Override
    public List<T> getAll(Class clz) {
        return null;
    }

    @Override
    public Page getPage(Class clz) {
        return null;
    }

    @Override
    public int insert(Class clz) {
        return 0;
    }

    @Override
    public int update(Class clz) {
        return 0;
    }

    @Override
    public int delete(Class clz) {
        return 0;
    }
}
