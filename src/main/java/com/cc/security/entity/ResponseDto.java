package com.cc.security.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author CaiCang
 * @Date 2020/9/1 14:59
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@ApiModel("通用返回体")
public class ResponseDto<T> implements Serializable {
    @ApiModelProperty("返回代码")
    Integer code;
    @ApiModelProperty("返回状态")
    String status;
    @ApiModelProperty("消息体")
    T body;

    public static <T> ResponseDto build(Integer code, String status, T body) {
        return new ResponseDto<T>(code, status, body);
    }

    public static ResponseDto build(Integer code, String status) {
        return new ResponseDto(code, status);
    }

    public ResponseDto(Integer code, String status) {
        this.code = code;
        this.status = status;
    }
}
