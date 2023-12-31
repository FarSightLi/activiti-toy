package com.farsight.activititoy.uitl;

import com.farsight.activititoy.exception.BusinessException;
import com.farsight.activititoy.exception.CodeMsg;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class Result<T> implements Serializable {

    //api 状态码
    @ApiModelProperty(value = "状态码")
    private Integer code;

    //状态码说明
    @ApiModelProperty(value = "状态码说明")
    private String codeRemark;

    //业务信息
    @ApiModelProperty(value = "业务信息")
    private String message;

    //数据信息
    @ApiModelProperty(value = "数据信息")
    private T result;



    public Result(Integer code , String codeRemark, String message, T result ) {

        this.code = code;
        this.codeRemark = codeRemark;
        this.message = message;
        this.result = result;
    }

    private Result(CodeMsg codeMsg)  {
        if(codeMsg != null) {
            this.code = codeMsg.getCode();
            this.codeRemark = codeMsg.getCodeRemark();
        }
    }

    private Result(CodeMsg codeMsg, String message, T result){
        if(codeMsg != null){
            this.code = codeMsg.getCode();
            this.codeRemark = codeMsg.getCodeRemark();
        }
        this.message = message;
        this.result = result;
    }


    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static <T> Result<T> success(String message, T result) {
        return new Result(CodeMsg.SUCCESS,message,result);
    }


    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static <T> Result<List<T>> successForPage(List<T> list) {
        return new Result(CodeMsg.SUCCESS,null,list);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static <T> Result<T> success(T result) {
        return new Result(CodeMsg.SUCCESS,null,result);
    }

    @SuppressWarnings({ "rawtypes" })
    public static Result success() {
        return new Result(CodeMsg.SUCCESS);
    }

    @SuppressWarnings("rawtypes")
    public static Result error(BusinessException e) {
        return error(e.getCodeMsg(),e.getMessage());
    }

    @SuppressWarnings({ "rawtypes" })
    public static Result error(CodeMsg codeMsg) {
        return error(codeMsg,codeMsg.getCodeRemark());
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static Result error(CodeMsg codeMsg, String message) {
        return new Result(codeMsg,message,null);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static <T> Result<T> error(CodeMsg codeMsg, T result) {
        return new Result(codeMsg,null,result);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getCodeRemark() {
        return codeRemark;
    }

    public void setCodeRemark(String codeRemark) {
        this.codeRemark = codeRemark;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
