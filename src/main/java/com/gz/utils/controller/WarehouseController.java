package com.gz.utils.controller;

import com.gz.utils.VO.ResultVO;
import com.gz.utils.entity.LayuiTableHeader;
import com.gz.utils.entity.User;
import com.gz.utils.entity.Warehouse;
import com.gz.utils.handler.TableHandler;
import com.gz.utils.service.impl.WarehouseServiceImpl;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: Gz
 * @Date: 2018/12/24 9:33
 */
@Controller
@RequestMapping(value = "/Warehouse")
public class WarehouseController {

    @Autowired
    public WarehouseServiceImpl warehouseService;

    /**
     * 临时储存上传的文件
     */
    private MultipartFile multipartFile;

    /**
     * 临时的数据哈希
     */
    HashMap<String, Object> hashMap;

    /**
     * 执行上传xls文件动作  99标识请求失败
     *
     * @param multipartFile 接受的上传文件
     * @return resultVO
     */
    @ResponseBody
    @RequestMapping(value = "/uploadAction")
    public HashMap<String, Object> uploadAction(@RequestParam(value = "file", required = false, defaultValue = "") MultipartFile multipartFile) throws IOException {
        this.multipartFile = multipartFile;//储存文件
        HashMap<String, Object> hashMap = TableHandler.handleTable(multipartFile);
        this.hashMap = hashMap;
        return hashMap;
    }


    /**
     * 测试获取全部仓库信息的API
     */
    @ResponseBody
    @RequestMapping(value = "/list")
    public ResultVO<Warehouse> getAllWarehouse() {
        List<Warehouse> allWarehouse = warehouseService.getAllWarehouse();
        ResultVO<Warehouse> resultVO = new ResultVO<>();
        resultVO.setCode(0);
        resultVO.setMsg("请求成功");
        resultVO.setData(allWarehouse);
        return resultVO;
    }

    @ResponseBody
    @RequestMapping(value = "/data")
    public ResultVO table() {
        ResultVO resultVO ;
        try {
            List<List<String>> data = (List<List<String>>) hashMap.get("cellHashList");
            resultVO = new ResultVO();
            resultVO.setCode(0);
            resultVO.setCount(data.size());
            resultVO.setMsg("请求成功");
            resultVO.setData(data);
        }
        catch (NullPointerException e){
            resultVO = new ResultVO();
            resultVO.setCode(-99);
            resultVO.setCount(null);
            resultVO.setMsg("请求数据查询为空,请先上传文件后再渲染表格");
            resultVO.setData(null);
        }

        //重置哈希
//        hashMap = null;
        return resultVO;
    }

    @ResponseBody
    @RequestMapping(value = "/header")
    public List<List<LayuiTableHeader>> header() {
        List<List<LayuiTableHeader>> lists = new ArrayList<>();
        List<LayuiTableHeader> tableList = new ArrayList<>();
        LayuiTableHeader table = new LayuiTableHeader();
        LayuiTableHeader table2 = new LayuiTableHeader();
        table.setField("id");
        table.setTitle("id");
        table2.setField("name");
        table2.setTitle("name");
        table.setWidth(100);
        table.setWidth(200);
        table.setSort(true);
        table2.setSort(true);
        table.setFixed("left");
        tableList.add(table);
        tableList.add(table2);
        lists.add(tableList);
        return lists;
    }

    @ResponseBody
    @RequestMapping(value = "/hash")
    public HashMap<String, Object> hashMap() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("header", "表头");
        hashMap.put("data", "数据");
        return hashMap;
    }

}
