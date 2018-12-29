package com.gz.utils.VO;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: Gz
 * @Date: 2018/12/24 9:40
 */
@Data
public class ResultVO<T> implements Serializable {

    private static final long serialVersionUID = -3670089740466702271L;

    private Integer code;

    private Integer count;

    private String msg;

    private List<T> data;


}
