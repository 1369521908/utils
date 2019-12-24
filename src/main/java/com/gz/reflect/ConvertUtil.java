package com.gz.reflect;

import cn.hutool.core.util.ReflectUtil;
import cn.hutool.log.StaticLog;
import com.alibaba.fastjson.JSONObject;
import com.gz.crud.annotation.FieldIgnore;
import com.gz.crud.annotation.FieldName;
import com.sun.istack.internal.NotNull;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @Author Destiny_Xue
 * @Date 2019/12/7 19:48
 * @Description
 */
public class ConvertUtil {

    /**
     * 反射的字段名称
     */
    private static final String FIELD_NAME = "name";

    /**
     * 序列化id名称
     */
    private static final String SERIAL_VERSION_UID = "serialVersionUID";

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
    public static String getAll(@NotNull Class clz) {
        return SELECT + fieldsConvert(clz) + FROM + clz.getSimpleName();
    }

    /**
     * 给定类,新增语句
     *
     * @param clz
     * @return
     */
    public static String insert(@NotNull Class clz) {
        return SELECT + fieldsConvert(clz) + FROM + clz.getSimpleName();
    }

    /**
     * 给定类,更新语句
     *
     * @param clz
     * @return
     */
    public static String update(@NotNull Class clz) {
        return SELECT + fieldsConvert(clz) + FROM + clz.getSimpleName();
    }

    /**
     * 给定类,删除语句
     *
     * @param clz
     * @return
     */
    public static String delete(@NotNull Class clz) {
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
        // String simpleName = clz.getSimpleName();
        // if (haveAnnotation(clz.getAnnotation(clz))) {
        //     // TODO
        // }
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

        if (!clz.isAnnotationPresent(Field.class)) {
            System.out.println("注意!!!,该类没有使用Field注解:" + clz.getName());
        }

        // 获取类的字段列表
        Field[] fields = ReflectUtil.getFields(clz);
        System.out.println(JSONObject.toJSONString(fields));
        // 空格占位
        StringBuilder fieldAppend = new StringBuilder("  ");

        /**
         * Info infoAnno = (Info) clazz.getAnnotation(Info.class);
         * System.out.println("person.name :" + infoAnno.value() + ",person.isDelete:" + infoAnno.isDelete());
         *
         */

        for (int i = 0; i < fields.length; i++) {

            // 拼接
            String field = calField(fields[i]);

            // 冗余字段过滤start
            if (SERIAL_VERSION_UID.equals(field)) {
                continue;
            }

            // 冗余字段过滤end

            fieldAppend.append(field);
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
            fieldName = JSONObject.parseObject(JSONObject.toJSONString(annotation)).getString(FIELD_NAME);
            FieldName fieldAnnotation = field.getAnnotation(FieldName.class);
            FieldIgnore ignoreAnnotation = field.getAnnotation(FieldIgnore.class);
            // 有注解值就取注解的值
            if (null != fieldAnnotation) {
                fieldName = fieldAnnotation.value();
            }
            if (null != ignoreAnnotation) {
                if (ignoreAnnotation.value()) {
                    break;
                }
            }
        }
        return fieldName;
    }
}
