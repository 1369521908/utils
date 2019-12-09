package com.gz.util;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.alibaba.fastjson.JSONObject;
import com.gz.entity.User;
import com.gz.reflect.ConvertUtil;

import java.sql.SQLException;
import java.util.List;

// @SpringBootApplication
public class UtilApplication {

    public static void main(String[] args) {
        // SpringApplication.run(UtilApplication.class, args);
        try {
            demo();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void demo() throws SQLException {

        // SerializeConfig config = new SerializeConfig();
        // config.propertyNamingStrategy = PropertyNamingStrategy.SnakeCase;
        // all = config.propertyNamingStrategy.translate((String) all);

        String all = ConvertUtil.getAll(User.class);

        List<Entity> query = Db.use().query(all);
        System.out.println(JSONObject.toJSONString(query));



    }

    public static void getAll() {

    }


}
