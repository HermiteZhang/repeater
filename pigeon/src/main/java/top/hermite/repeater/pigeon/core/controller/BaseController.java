package top.hermite.repeater.pigeon.core.controller;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import top.hermite.repeater.pigeon.core.component.BaseResponse;
import top.hermite.repeater.pigeon.core.component.jackson.JsonUtil;
import top.hermite.repeater.pigeon.core.component.util.GenericeClassUtils;
import top.hermite.repeater.pigeon.core.component.util.SpringUtil;
import top.hermite.repeater.pigeon.core.service.IBaseService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * MIT License Copyright (c) 2019 HermiteZhang
 *
 * @Author HermiteZhang
 * @Email zhangw9409@gmail.com
 * @Date create in 17:38 2019/9/26
 * @Desc:
 */
public class BaseController<T> {
    // 异常信息拦截，统一处理返回，为了兼容IE8，用流方式输出
    @ExceptionHandler(Exception.class)   //在Controller类中添加该注解方法即可(注意：添加到某个controller，只针对该controller起作用)
    public void exceptionHandler(Exception ex, HttpServletResponse response, HttpServletRequest request) throws IOException {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.error(0,ex.getMessage());
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(baseResponse.toString());
    }


//    protected Object getServiceImpl(String name) {
//        try{
//            return SpringUtil.getBean(name);
//        }catch(BeansException be){
//            String startMode = String.valueOf(((WebApplicationContext)SpringUtil.getApplicationContext()).getServletContext().getInitParameter("pluginMode"));
//            if("safe".equalsIgnoreCase(startMode)){
//                //安全模式下，允许某些类找不到
//                System.out.println("安全模式下，允许某些类找不到");
//                return null;
//            }else{
//                throw new RuntimeException(be);
//            }
//        }
//    }
    IBaseService myBatisBaseServiceImpl;
    protected IBaseService getServiceImpl(){
        if(myBatisBaseServiceImpl==null){
            myBatisBaseServiceImpl= (IBaseService)SpringUtil.getBean("baseMybatisService");
        }
        System.out.println("base");
        return myBatisBaseServiceImpl;
    };

    @SuppressWarnings("unchecked")
    protected Class<T> entityClass = (Class<T>) GenericeClassUtils.getSuperClassGenricType(this.getClass(), 0);


    /**
     * 根据Id查询实体
     */

    @GetMapping(value = "/{id}", produces = "application/json;charset=utf-8")
    public  BaseResponse getEntityById(@PathVariable(value = "id") final Integer id) {
       // T entity = baseDao.getEntityById(entityClass, id);
        //return new ResultDataDto(entity);
        return null;
    }

    /**
     * 新增实体
     */

    @PostMapping(value = "/insert", produces = "application/json;charset=utf-8")
    public  BaseResponse insert(@RequestBody final T entity) {
        System.out.println(JsonUtil.obj2str(entity));

        return null;
    }

    /**
     * 更新实体
     */

    @PutMapping(value = "/update", produces = "application/json;charset=utf-8")
    public  BaseResponse updateEntity(@RequestBody final T entity) {
        return null;
    }

    /**
     * 根据Id删除实体
     */

    @DeleteMapping(value = "/{id}", produces = "application/json;charset=utf-8")
    public  BaseResponse deleteEntityById(@PathVariable(value = "id") final Integer id) {
        return null;
    }

    /**
     * 查询所有实体
     */
    @GetMapping(value = "/all", produces = "application/json;charset=utf-8")
    public BaseResponse findAllEntitys() {

        System.out.println("all");

        getServiceImpl().listAll();
        return null;
    }



}
