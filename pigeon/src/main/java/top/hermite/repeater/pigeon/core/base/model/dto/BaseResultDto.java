package top.hermite.repeater.pigeon.core.base.model.dto;


import lombok.Data;
import org.springframework.http.HttpStatus;
import top.hermite.repeater.pigeon.core.base.exception.RuntimeFunctionException;
import top.hermite.repeater.pigeon.core.base.exception.RuntimeOtherException;
import top.hermite.repeater.pigeon.core.base.exception.RuntimeServiceException;
import top.hermite.repeater.pigeon.core.base.exception.RuntimeWebException;

import java.util.List;


@Data
public class BaseResultDto {

    private static final Integer OK_CODE = HttpStatus.OK.value();
    private static final String OK_MSG = "操作成功";

    /**
     * 500-业务逻辑错误
     */
    public final static Integer ERROR_SERVICE_CODE = HttpStatus.INTERNAL_SERVER_ERROR.value();

    /**
     * 501-功能不完善，无对应方法
     */
    public final static Integer ERROR_FUNCTION_CODE = HttpStatus.NOT_IMPLEMENTED.value();

    /**
     * 502-网络异常
     */
    public final static Integer ERROR_WEB_CODE = HttpStatus.BAD_GATEWAY.value();
    /**
     * 503-未知其它
     */
    public final static Integer ERROR_OTHER_CODE = HttpStatus.SERVICE_UNAVAILABLE.value();


    //结果编码
    private int code;

    private String msg;

    private Object data;

    //constructor
    public BaseResultDto() {
        this.code = OK_CODE;
    }

    public BaseResultDto(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    //异常类构造函数
    /**
     * 500-业务逻辑错误
     */
    public BaseResultDto(RuntimeServiceException rex) {
        super();
        this.code = ERROR_SERVICE_CODE;
        this.msg = rex.getMessage();
    }

    /**
     * 501-功能不完善，无对应方法
     */
    public BaseResultDto(RuntimeFunctionException rex) {
        super();
        this.code = ERROR_FUNCTION_CODE;
        this.msg = rex.getMessage();
    }

    /**
     * 502-网络异常
     */
    public BaseResultDto(RuntimeWebException rex) {
        super();
        this.code = ERROR_WEB_CODE;
        this.msg = rex.getMessage();
    }

    /**
     * 503-未知其它
     */
    public BaseResultDto(RuntimeOtherException rex) {
        super();
        this.code =ERROR_OTHER_CODE;
        this.msg = rex.getMessage();
    }


    //基本操作返回值

    public static BaseResultDto insertOk(String pdId) {
        return new BaseResultDto(OK_CODE, OK_MSG, pdId);
    }

    public static BaseResultDto getOk(Object object) {
        return new BaseResultDto(OK_CODE, OK_MSG, object);
    }

    public static BaseResultDto listOk(List list) {
        return new BaseResultDto(OK_CODE, OK_MSG, list);
    }

    public static BaseResultDto deleteOk(String pdId) {
        return new BaseResultDto(OK_CODE, OK_MSG, pdId);
    }

    public static BaseResultDto updateOk(String pdId) {
        return new BaseResultDto(OK_CODE, OK_MSG, pdId);
    }
    //其他方法
    public static BaseResultDto error(int code , String msg){
        return new BaseResultDto(code,msg,"");
    }

    public static BaseResultDto success(){
        return new BaseResultDto(OK_CODE,OK_MSG,"");
    }

    public static BaseResultDto Ok(Object obj){
        return new BaseResultDto(OK_CODE,OK_MSG,obj);
    }

    public static BaseResultDto errorException(Exception ex){
        return new BaseResultDto(0,ex.getMessage(),"");
    }


}