package com.gz.utils.handler;

import com.gz.utils.entity.LayuiTableHeader;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: Gz
 * @Date: 2018/12/28 15:19
 */
@Slf4j
public class TableHandler {


    /**
     * 解析表格
     *
     * @param multipartFile 接受到上传的表格
     * @return 哈希表
     * @throws IOException 流异常
     */
    public static HashMap<String, Object> handleTable(MultipartFile multipartFile) throws IOException {
        HashMap<String, Object> hashMap = new HashMap<>();
        //检查是否接收到文件
        if (null == multipartFile) { //接受不到 返回结果
            hashMap.put("msg", "上传文件为空,请求失败");
            hashMap.put("code", 99);
            log.error(" [ 上传文件 ]  , 上传文件为空,请求失败 ");
            return hashMap;
        }
        //检查文件格式是否正确
        if (!multipartFile.getOriginalFilename().endsWith("xlsx")) {
            hashMap.put("msg", "文件格式必须为xlsx");
            hashMap.put("code", 0);
            log.error(" [ 上传文件 ]  , 文件格式必须为xlsx ");
            return hashMap;
        }
        //接受到文件 开始解析
        XSSFWorkbook workbook = new XSSFWorkbook(multipartFile.getInputStream());
        int numberOfSheets = workbook.getNumberOfSheets();//总工作表数
        XSSFSheet sheet = workbook.getSheetAt(0);//按照索引选择工作表,从 0开始

        int rowNum = sheet.getLastRowNum();//获取最后行索引
        Row row = sheet.getRow(0);//首行
        int numberOfCells = row.getPhysicalNumberOfCells();//首行的单元格数量

        List<List<LayuiTableHeader>> lists = new ArrayList<>();
        List<LayuiTableHeader> headerList = new ArrayList<>();
        LayuiTableHeader table;

        List<List<String>> dataRow = new ArrayList<>();
        List<String> col = new ArrayList<>();//数据
        String cell = "";

        HashMap<String, Object> cellHash = new HashMap<>();
        List<HashMap<String, Object>> cellHashList = new ArrayList<>();
        for (int i = 0; i < rowNum + 1; i++) {//遍历每一行 第一行是字段 从索引1开始是数据行

            if (i == 0) {
                ///////表头////////
//                for (int j = 0; j < row.getLastCellNum(); j++) { //表头抽出来
                for (int j = 0; j < numberOfCells; j++) { //表头抽出来
                    row.getCell(j).setCellType(CellType.STRING);//均设置为string类型输出
                    //设置表头样式
                    table = new LayuiTableHeader();
                    table.setField(row.getCell(j).getStringCellValue());//设置表头域
                    table.setTitle(row.getCell(j).getStringCellValue());//表头标题
                    table.setWidth(300);
                    table.setSort(true);//是否排序
//                    table.setToolbar(true);
                    table.setAlign("left");//对齐方式
                    table.setTotalRow(true);//是否显示汇总
                    table.setTotalRowText("合计:");//汇总标题
//                    table.setFixed("left");
                    headerList.add(table);
                }
            } else {
                row = sheet.getRow(i);
                col = new ArrayList<>();
                cellHash = new HashMap<>();
//            cellHashList = new ArrayList<>();
                System.out.println("-----------------------------");
//                for (int j = 0; j < row.getLastCellNum(); j++) { //遍历每一列 从索引0开始
                for (int j = 0; j < row.getLastCellNum()-1; j++) { //遍历每一列 从索引0开始
                    row.getCell(j).setCellType(CellType.STRING);//均设置为string类型输出
                    System.out.println(row.getCell(j).getStringCellValue());
//                cell="{"+row.getCell(j).getStringCellValue()+"},";
                    cell = row.getCell(j).getStringCellValue();
                    col.add(cell);
                    cellHash.put(headerList.get(j).getField(), row.getCell(j).getStringCellValue());

                }
//                dataRow.add(col);
                cellHashList.add(cellHash);
                System.out.println("*****************************");
                System.out.println();
            }

        }
        lists.add(headerList);
        hashMap.put("head", lists);//封装表头
//        hashMap.put("dataObj", cellHash);//封装表头
        hashMap.put("cellHashList", cellHashList);
//        hashMap.put("data", dataRow);//封装表头
        return hashMap;
    }
}
