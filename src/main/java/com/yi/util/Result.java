package com.yi.util;

public class Result {
    //状态码
    int code;
    //数据
    Object data;
    //消息提示
    String message;
    //数量
    int count;
    public Result() {
    }

    public Result(String message) {
        this.code = 1222;
        this.message = message;
    }
    public Result(int code, String message, Object data, int count) {
        this.code = code;
        this.data = data;
        this.message = message;
        this.count = count;
    }
    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }
    public Result(int code, String message, Object object) {
        this.code = code;
        this.message = message;
        this.data = object;
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    /**
     * successMessage
     * 正常返回，携带消息
     * code:1028
     *
     * @param message 消息
     *                data:null
     *                count:0
     * @return
     */
    public static Result successMessage(String message) {
        return new Result(1028, message);
    }
    /**
     * successMessage
     * 正常返回，携带消息和数据
     * code:1028
     *
     * @param message 消息
     *                data:null
     *                count:0
     * @return
     */
    public static Result successMessage(String message, Object obj) {
        return new Result(1028, message,obj);
    }

    /**
     * success
     * 成功方法 带数据返回
     * code:1224
     *
     * @param data  数据
     * @param count 总数
     * @return
     */
    public static Result success(Object data, int count) {
        return new Result(1224, "success", data, count);
    }

    /**
     * success
     * 成功方法 带数据返回
     * code:1224
     * message: success
     *
     * @param data 数据
     *             count :0
     * @return
     */
    public static Result success(Object data) {
        return new Result(1224, "success", data, 1);
    }

    /**
     * error
     * code:203
     * data:null
     * count:0
     *
     * @param message 错误信息
     * @return
     */
    public static Result error(String message) {
        return new Result(1203, message);
    }
    /**
     * error
     * code
     * data:null
     * count:0
     *
     * @param message 错误信息
     * @return
     */
    public static Result error(int code, String message) {
        return new Result(code, message);
    }
}
