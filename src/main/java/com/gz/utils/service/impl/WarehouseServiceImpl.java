package com.gz.utils.service.impl;

import com.gz.utils.entity.Warehouse;
import com.gz.utils.mapper.WarehouseMapper;
import com.gz.utils.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Gz
 * @Date: 2018/12/24 9:30
 */
@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    private WarehouseMapper warehouseMapper;

    @Override
    public List<Warehouse> getAllWarehouse() {
        return warehouseMapper.getAllWarehouse();
    }
}
