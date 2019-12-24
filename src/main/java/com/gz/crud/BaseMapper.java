package com.gz.crud;

import cn.hutool.db.Page;

import java.util.List;

/**
 * @Author Destiny_Xue
 * @Date 2019/12/7 19:56
 * @Description
 */
public interface BaseMapper<T> {

    /**
     * 对象条件查询全部
     *
     * @param clz
     * @return
     */
    List<T> getAll(Class<T> clz);

    /**
     * 对象条件查询分页
     *
     * @param clz
     * @return
     */
    Page getPage(Class<T> clz);

    /**
     * 新增
     *
     * @param clz
     * @return
     */
    int insert(Class<T> clz);

    /**
     * 更新
     *
     * @param clz
     * @return
     */
    int update(Class<T> clz);

    /**
     * 删除
     *
     * @param clz
     * @return
     */
    int delete(Class<T> clz);
}
