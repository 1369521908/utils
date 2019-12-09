package com.gz.reflect;

import cn.hutool.core.util.ReflectUtil;
import cn.hutool.log.StaticLog;
import com.alibaba.fastjson.JSONObject;
import com.sun.istack.internal.NotNull;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @Author Destiny_Xue
 * @Date 2019/12/7 19:48
 * @Description
 */
public class ConvertUtil {

    private static final String TARGET = ConvertUtil.class.getName();

    private static final String SELECT = " SELECT ";

    private static final String TON = " , ";

    private static final String FROM = " FROM ";

    private static final String WHERE = " WHERE ";

    private static final String INSERT = " INSERT ";

    private static final String INTO = " INTO ";

    private static final String UPDATE = " UPDATE ";

    private static final String SET = " SET ";

    private static final String VALUES = " VALUES ";

    private static final String BRACKET_LEFT = " ( ";

    private static final String BRACKET_RIGHT = " ) ";

    private static final String SINGLE_QUOTE = "'";

    private static final String TO_DATE = "TO_DATE";

    private static final String DATE_PATTERN = "yyyy-mm-dd";

    private static final String DATE_HOUR_PATTERN = "YYYY-MM-DD : HH:MM:SS";

    /**
     * 给定类,转换成查询全部字段的sql语句
     *
     * @param clz 需要转换成sql的Entity
     * @return sql语句
     */
    public static <T> String getAll(@NotNull Class<T> clz) {
        return SELECT + fieldsConvert(clz) + FROM + clz.getSimpleName();
    }

    /**
     * 给定类,转换字段成sql拼接语句
     * 返回值参考: id, name
     *
     * @param clz Entity
     * @return sql拼接语句
     */
    private static String tableConvert(@NotNull Class clz) {
        // 获取类名称
        String simpleName = clz.getSimpleName();
        if (haveAnnotation(clz.getAnnotation(clz))) {
            // TODO
        }
        return null;
    }

    /**
     * 给定类,转换字段成sql拼接语句
     * 返回值参考: id, name
     *
     * @param clz Entity
     * @return sql拼接语句
     */
    private static String fieldsConvert(@NotNull Class clz) {

        // 获取类的字段列表
        Field[] fields = ReflectUtil.getFields(clz);

        // 空格占位
        StringBuilder fieldAppend = new StringBuilder("  ");

        for (int i = 0; i < fields.length; i++) {

            // 冗余字段过滤


            // 拼接
            fieldAppend.append(calField(fields[i]));
            if (fields.length - i != 1) {
                // field => field ,
                fieldAppend.append(TON);
            }
        }

        if (fields.length != 0) {
            return fieldAppend.toString();
        } else {
            StaticLog.error("\n在[{}]中的错误,类[{}]中没有字段...,类转换sql失败...", TARGET, clz.getName());
            // throw new NoSuchFieldException("\n{},给定类没有字段");
            return null;
        }
    }

    /**
     * 计算字段相对于数据库的映射列
     *
     * @param field 字段
     * @return 字段对应的数据库列
     */
    private static String calField(@NotNull Field field) {

        String fieldName = field.getName();

        for (Annotation annotation : field.getAnnotations()) {
            if (haveAnnotation(annotation)) {
                fieldName = JSONObject.parseObject(JSONObject.toJSONString(annotation)).getString("value");
            }
        }
        return fieldName;
    }

    /**
     * 判断字段是否有注解
     *
     * @param annotation 自定义注解
     * @return 判断结果
     */
    private static boolean haveAnnotation(@NotNull Annotation annotation) {
        //用哈希码判断
        if (Integer.toHexString(annotation.hashCode()).
                equals("value")) {
            return true;
        }
        return false;
    }
}
