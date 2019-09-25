package top.hermite.repeater.pigeon.rest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import top.hermite.repeater.pigeon.component.BaseResponse;
import top.hermite.repeater.pigeon.component.util.GenericeClassUtils;
import top.hermite.repeater.pigeon.dao.PigeonRepeaterDao;
import top.hermite.repeater.pigeon.model.PigeonRepeaterEntity;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;


/**
 * @author hermite
 */
@RestController
public class PigeonRepeaterRestController<T extends PigeonRepeaterEntity> {

    // 异常信息拦截，统一处理返回，为了兼容IE8，用流方式输出
//    @ExceptionHandler(Exception.class)   //在Controller类中添加该注解方法即可(注意：添加到某个controller，只针对该controller起作用)
//    public void exceptionHandler(Exception ex, HttpServletResponse response, HttpServletRequest request) throws IOException {
//
//        response.setContentType("text/html;charset=utf-8");
//        response.getWriter().write(new Gson().toJson(resultDataDto));
//    }
//

    private final static Logger logger = LoggerFactory.getLogger(PigeonRepeaterRestController.class);

    @Resource
    BaseResponse baseResponse;

    @GetMapping(value = "/repeater", produces = "application/json;charset=utf-8")
    public BaseResponse repeater(@RequestParam(value = "say", required = false) String say,
                                 HttpServletRequest request) {
        logger.info(">> GET upgradeApp >>");
        try {
            String call = say + new Date().toString();
            baseResponse.success(call);
        } catch (Exception e) {
            baseResponse.error(HttpStatus.BAD_REQUEST.value(), "version code error");
        }
        return baseResponse;
    }

    @SuppressWarnings("unchecked")
    protected Class<T> entityClass = (Class<T>) GenericeClassUtils.getSuperClassGenricType(this.getClass(), 0);

    @Resource(name = "pigeonRepeaterDao")
    protected PigeonRepeaterDao<T> baseDao;

    /**
     * 根据Id查询实体
     */
    @RequestMapping(value = "/getEntityById/{id}", method = RequestMethod.GET)
    public @ResponseBody
    BaseResponse getEntityById(@PathVariable(value = "id") final Integer id) {
        T entity = baseDao.getEntityById(entityClass, id);
        return new BaseResponse(entity);
    }

    /**
     * 新增实体
     */

    @RequestMapping(value = "/addEntity", method = RequestMethod.POST, consumes = "application/json")
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    public @ResponseBody
    BaseResponse addEntity(@RequestBody final T entity) {
        baseDao.addEntity(entity);
        return new BaseResponse();
    }

    /**
     * 更新实体
     */

    @RequestMapping(value = "/updateEntity", method = RequestMethod.PUT, consumes = "application/json")
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    public @ResponseBody
    BaseResponse updateEntity(@RequestBody final T entity) {
        baseDao.updateEntity(entity);
        return new BaseResponse();
    }

    /**
     * 根据Id删除实体
     */

    @RequestMapping(value = "/deleteEntityById/{id}", method = RequestMethod.DELETE)
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    public @ResponseBody
    BaseResponse deleteEntityById(@PathVariable(value = "id") final Integer id) {
        baseDao.deleteEntityById(entityClass, id);
        return new BaseResponse();
    }

    /**
     * 查询所有实体
     */

    @SuppressWarnings({"rawtypes", "unchecked"})
    @RequestMapping(value = "/findAllEntitys", method = RequestMethod.GET)
    public @ResponseBody
    BaseResponse findAllEntitys() {
        List list = baseDao.selectAll(entityClass);
        return new BaseResponse();
    }


}
