package com.gz.entity;

import lombok.Data;

/**
 * @Author: Gz
 * @Date: 2018/12/28 9:13
 */
@Data
public class LayuiTableHeader {

    /**
     * 设定字段名。字段名的设定非常重要，且是表格数据列的唯一标识
     * 示例值  username
     */
    private String field;
    /**
     * 设定标题名称
     * 示例值  用户名
     */
    private String title;
    /**
     * 设定列宽，若不填写，则自动分配；若填写，则支持值为：数字、百分比
     * 请结合实际情况，对不同列做不同设定。
     * 示例值  200
     */
    private Integer width;
    /**
     * 设定列宽，若不填写，则自动分配；若填写，则支持值为：数字、百分比<code>@percentageWidth</code>
     * 请结合实际情况，对不同列做不同设定。
     * 示例值 30%
     */
    private String percentageWidth;
    /**
     * 局部定义当前常规单元格的最小宽度（默认：60），一般用于列宽自动分配的情况。其优先级高于基础参数中的 cellMinWidth
     * 示例值  100
     */
    private Integer minWidth;
    /**
     * 设定列类型。可选值有：
     * normal（常规列，无需设定）
     * checkbox（复选框列）
     * radio（单选框列，layui 2.4.0 新增）
     * numbers（序号列）
     * space（空列）
     * 示例值  任意一个可选值
     */
    private String type;
    /**
     * 是否全选状态（默认：false）。必须复选框列开启后才有效，如果设置 true，则表示复选框默认全部选中。
     * 示例值   true
     */
    private boolean LAY_CHECKED;
    /**
     * 固定列。可选值有：left（固定在左）、right（固定在右）。一旦设定，对应的列将会被固定在左或右，不随滚动条而滚动。
     * 注意：如果是固定在左，该列必须放在表头最前面；如果是固定在右，该列必须放在表头最后面。
     * 示例值  left（同 true）right
     */
    private String fixed;

    /**
     * 是否初始隐藏列，默认：false。layui 2.4.0 新增
     * 示例值  	true
     */
    private boolean hide;
    /**
     * 是否开启该列的自动合计功能，默认：false。layui 2.4.0 新增
     * 示例值  true
     */
    private boolean totalRow;
    /**
     * 用于显示自定义的合计文本。layui 2.4.0 新增
     * 示例值  	"合计："
     */
    private String totalRowText;
    /**
     * 是否允许排序（默认：false）。如果设置 true，则在对应的表头显示排序icon，从而对列开启排序功能。
     * 注意：不推荐对值同时存在“数字和普通字符”的列开启排序，因为会进入字典序比对。比如：'贤心' > '2' > '100'，这可能并不是你想要的结果，但字典序排列算法（ASCII码比对）就是如此。
     * 示例值  true
     */
    private boolean sort;
    /**
     * 是否禁用拖拽列宽（默认：false）。默认情况下会根据列类型（type）来决定是否禁用，如复选框列，会自动禁用。而其它普通列，默认允许拖拽列宽，当然你也可以设置 true 来禁用该功能。
     * 示例值  false
     */
    private boolean unresize;
    /**
     *单元格编辑类型（默认不开启）目前只支持：text（输入框）
     * 示例值  text
     */
    private String edit;
    /**
     * 自定义单元格点击事件名，以便在 tool 事件中完成对该单元格的业务处理
     * 示例值  任意字符
     */
    private String event;
    /**
     * 自定义单元格样式。即传入 CSS 样式
     * 示例值  background-color: #5FB878; color: #fff;
     */
    private String style;
    /**
     * 元格排列方式。可选值有：left（默认）、center（居中）、right（居右）
     * 示例值  center
     */
    private String align;
    /**
     * 单元格所占列数（默认：1）。一般用于多级表头
     * 示例值  3
     */
    private Integer colspan;
    /**
     * 单元格所占行数（默认：1）。一般用于多级表头
     * 示例值  2
     */
    private Integer rowspan;
    private Integer length;
    /**
     * 自定义列模板，模板遵循 laytpl 语法。这是一个非常实用的功能，你可借助它实现逻辑处理，以及将原始数据转化成其它格式，如时间戳转化为日期字符等
     * 示例值  详见自定义模板
     */
    private String templet;
    /**
     * 绑定列工具条。设定后，可在每行列中出现一些自定义的操作性按钮
     * 示例值  详见列工具条
     */
    private boolean toolbar;
}
