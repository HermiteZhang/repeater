package top.hermite.repeater.pigeon.core.base.controller;

import org.springframework.web.bind.annotation.*;
import top.hermite.repeater.pigeon.core.base.model.BaseEntity;
import top.hermite.repeater.pigeon.core.base.model.dto.BaseResultDto;
import top.hermite.repeater.pigeon.core.component.util.SpringUtil;
import top.hermite.repeater.pigeon.core.base.service.IBaseService;

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
public class BaseController<T extends BaseEntity> {

    // 异常信息拦截，统一处理返回，为了兼容IE8，用流方式输出
    @ExceptionHandler(Exception.class)   //在Controller类中添加该注解方法即可(注意：添加到某个controller，只针对该controller起作用)
    public void exceptionHandler(Exception ex, HttpServletResponse response, HttpServletRequest request) throws IOException {
        BaseResultDto baseResponse = new BaseResultDto();
        baseResponse.error(0,ex.getMessage());
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(baseResponse.toString());
    }

    private IBaseService myBatisBaseServiceImpl;
    protected IBaseService getServiceImpl(){
        if(myBatisBaseServiceImpl==null){
            myBatisBaseServiceImpl= (IBaseService)SpringUtil.getBean("baseMybatisService");
        }
        return myBatisBaseServiceImpl;
    }

    /**
     * 根据Id查询实体
     */

    @GetMapping(value = "/{id}", produces = "application/json;charset=utf-8")
    public BaseResultDto getEntityById(@PathVariable(value = "id") final String id) {
         return getServiceImpl().getEntityById(id);
    }

    /**
     * 新增实体
     */

    @PostMapping(value = "/insert", produces = "application/json;charset=utf-8")
    public BaseResultDto insert(@RequestBody final T entity) {
        return getServiceImpl().insert(entity);
    }

    /**
     * 更新实体
     */

    @PutMapping(value = "/update", produces = "application/json;charset=utf-8")
    public BaseResultDto updateEntity(@RequestBody final T entity) {
        return getServiceImpl().update(entity);
    }

    /**
     * 根据Id删除实体
     */

    @DeleteMapping(value = "/{id}", produces = "application/json;charset=utf-8")
    public BaseResultDto deleteEntityById(@PathVariable(value = "id") final String id) {
        return getServiceImpl().deleteById(id);
    }

    /**
     * 查询所有实体
     */
    @GetMapping(value = "/all", produces = "application/json;charset=utf-8")
    public BaseResultDto findAllEntitys() {
        return   getServiceImpl().listAll();
    }



}
