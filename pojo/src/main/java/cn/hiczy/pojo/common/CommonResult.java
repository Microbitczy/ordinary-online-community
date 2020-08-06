package cn.hiczy.pojo.common;

import cn.hiczy.pojo.enums.ResultEnum;
import lombok.Data;

/****************************************************************************
 * Copyright 2020 czy77/czy_git@163.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ***************************************************************************
 */

@Data
public class CommonResult<T> {

    private CommonResult() {
        this.code = ResultEnum.SUCCESS.getCode();
        this.message = ResultEnum.SUCCESS.getMsg();
        this.data = null;
    }

    private Integer code;

    private String message;

    private T data;


    /**
     * 自定义返回结果
     *
     * @param code    自定义返回状态码
     * @param message 自定义返回消息
     * @param data    数据
     * @param <T>     数据类型
     * @return 通用返回结果
     */
    public static <T> CommonResult<T> create(Integer code, String message, T data) {
        CommonResult<T> result = new CommonResult<>();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;

    }


    /**
     * @param resultEnum 返回结果枚举
     * @param data       返回数据
     * @param <T>        返回数据类型
     * @return 通用返回结果
     */
    public static <T> CommonResult<T> create(ResultEnum resultEnum, T data) {
        return create(resultEnum.getCode(), resultEnum.getMsg(), data);
    }


    /**
     * 返回成功结果
     *
     * @return 返回成功结果
     */
    public static CommonResult ok() {
        return new CommonResult<>();
    }


    /**
     * 返回成功结果
     *
     * @param message 返回成功消息
     * @return 返回成功结果
     */
    public static CommonResult ok(String message) {
        CommonResult result = new CommonResult<>();
        result.setMessage(message);
        return result;
    }

    /**
     * 返回成功结果
     *
     * @param data 返回成功数据
     * @param <T>  返回成功数据类型
     * @return 返回成功结果
     */
    public static <T> CommonResult<T> ok(T data) {
        CommonResult<T> result = new CommonResult<>();
        result.setData(data);
        return result;
    }


    /**
     * 返回成功结果
     *
     * @param message 返回成功消息
     * @param data    返回成功数据
     * @param <T>     返回成功数据类型
     * @return 返回成功结果
     */
    public static <T> CommonResult<T> ok(String message, T data) {
        CommonResult<T> result = new CommonResult<>();
        result.setMessage(message);
        result.setData(data);
        return result;
    }


    /**
     * 返回错误结果
     *
     * @return 返回错误结果
     */
    public static CommonResult error() {
        return create(ResultEnum.SYSTEM_ERROR, null);
    }


    /**
     * 返回错误结果
     * @param message 返回错误消息
     * @return 返回错误结果
     */
    public static CommonResult error(String message) {
        return create(ResultEnum.SYSTEM_ERROR.getCode(), message, null);
    }


    /**
     * 返回错误结果
     * @param data    返回错误数据
     * @param <T>     返回错误数据类型
     * @return        返回错误结果
     */
    public static <T> CommonResult<T> error(T data) {
        return create(ResultEnum.SYSTEM_ERROR, data);
    }


    /**
     * 返回错误结果
     * @param message  返回错误消息
     * @param data     返回错误数据
     * @param <T>      返回错误数据类型
     * @return         返回错误结果
     */
    public static <T> CommonResult<T> error(String message, T data) {
        return create(ResultEnum.SYSTEM_ERROR.getCode(), message, data);
    }


}