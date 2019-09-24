package top.hermite.repeater.pigeon.rest;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.hermite.repeater.pigeon.component.BaseResponse;
import top.hermite.repeater.pigeon.component.jackson.JsonUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;


/**
 * @author hermite
 */
@RestController
public class PigeonRepeaterRestController
{

    private final static Logger logger = LoggerFactory.getLogger(PigeonRepeaterRestController.class);

    @Resource
    BaseResponse baseResponse;

    @GetMapping(value = "/repeater", produces = "application/json;charset=utf-8")
    public BaseResponse repeater(@RequestParam(value = "say", required = false) String say,
                                   HttpServletRequest request)
    {
        logger.info(">> GET upgradeApp >>");
        try
        {
            String call = say+ new Date().toString();
            baseResponse.success(call);
        }
        catch (Exception e)
        {
            baseResponse.error(HttpStatus.BAD_REQUEST.value(), "version code error");
        }
        return baseResponse;
    }
}
