package com.consul.model.response;

/**
 * 封装Response的错误码
 *
 * @author He.Yong
 * @since 2022-03-11 18:33:39
 */
public interface IErrorCode {
    Integer getCode();
    String getMessage();
}
