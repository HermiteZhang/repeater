package top.hermite.repeater.pigeon.component;


import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import top.hermite.repeater.pigeon.component.jackson.JsonUtil;
import top.hermite.repeater.pigeon.model.PigeonRepeaterEntity;


@Component
@Data
public class BaseResponse
{

    private int code;

    private String data;

    public void create(int code, String data)
    {
        this.code = code;
        this.data = data;
    }

    public void success(Object object)
    {
        this.code = HttpStatus.OK.value();
        this.data = JsonUtil.obj2str(object);
    }

    public void error(int code, String msg)
    {
        this.code = code;
        this.data = msg;
    }

    public void empty()
    {
        this.code = HttpStatus.NO_CONTENT.value();
        this.data = "no content";
    }

    public void judge(boolean judgement, int errorcode, String errorMsg, String successMsg)
    {
        if (judgement)
        {
            this.success(successMsg);
        }
        else
        {
            this.error(errorcode, errorMsg);
        }
    }

    public String toJson()
    {
        return JsonUtil.obj2str(this);
    }

    public boolean isSuccess()
    {
        return this.code == HttpStatus.OK.value();
    }

    public<T extends PigeonRepeaterEntity> BaseResponse(T entity){
        this.code = HttpStatus.OK.value();
        this.data = JsonUtil.obj2str(entity);
    }

    public BaseResponse(){
        this.code = HttpStatus.OK.value();
    }
}