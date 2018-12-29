package com.gz.utils.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gz.utils.entity.Warehouse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Gz
 * @Date: 2018/12/24 9:27
 */
@Mapper
@Repository
public interface WarehouseMapper extends BaseMapper<Warehouse> {

    public List<Warehouse> getAllWarehouse();
}
