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
    public List<T> getAll() {

        return null;
    }

    @Override
    public Page getPage() {
        return null;
    }

    @Override
    public int insert() {
        return 0;
    }

    @Override
    public int update() {
        return 0;
    }

    @Override
    public int delete() {
        return 0;
    }
}
