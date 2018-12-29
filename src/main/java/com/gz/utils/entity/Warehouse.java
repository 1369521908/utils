package com.gz.utils.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 仓库
 * @Author: Gz
 * @Date: 2018/12/24 9:12
 */
@Data
@TableName(value = "MTL_INV")
public class Warehouse implements Serializable {

    private static final long serialVersionUID = 5853016747443054813L;
    /**
     * 仓库ID
     */
    @TableId(value = "INV_ID",type = IdType.UUID)
    private String invId;
    /**
     * 仓库代码
     */
    private String invCode;
    /**
     * 仓库名称
     */
    private String invName;
    /**
     * 仓库类型(1级库,机旁库)
     */
    private String invType;
    /**
     * 所属公司id
     */
    private String corpId;
    /**
     * 所属部门id
     */
    private String deptId;
    /**
     * 成本中心
     */
    private String costCode;
    /**
     * 状态(0-编辑;1-确定;9-失效)
     */
    private Integer status;
    /**
     * 备注
     */
    private String note;
    /**
     * 更新时间
     */
    private Date lastUpdateDate;
    /**
     * 更新人
     */
    private String lastUpdateBy;
    /**
     * 创建时间
     */
    private Date creationDate;
    /**
     * 创建人
     */
    private String createdBy;

}

