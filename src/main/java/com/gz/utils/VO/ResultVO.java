package com.gz.utils.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: Gz
 * @Date: 2018/12/24 9:40
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultVO<T> implements Serializable {

    private static final long serialVersionUID = -3670089740466702271L;

    private Integer code;

    private Integer count;

    private String msg;

    private List<T> data;

    public ResultVO(Integer code) {
        this.code = code;
    }

    public ResultVO(Integer code, Integer count) {
        this.code = code;
        this.count = count;
    }

    public ResultVO(Integer code, Integer count, String msg) {
        this.code = code;
        this.count = count;
        this.msg = msg;
    }

}
