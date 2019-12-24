package com.gz.util;

import com.gz.entity.User;
import com.gz.reflect.ConvertUtil;

import java.sql.SQLException;

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

        String all = ConvertUtil.getAll(User.class);
        // SerializeConfig config = new SerializeConfig();
        // config.propertyNamingStrategy = PropertyNamingStrategy.SnakeCase;
        // all = config.propertyNamingStrategy.translate(all);
        System.out.println(all);



    }

    public static void getAll() {

    }


}
