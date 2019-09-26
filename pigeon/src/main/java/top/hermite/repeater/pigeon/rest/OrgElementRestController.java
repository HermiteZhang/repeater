package top.hermite.repeater.pigeon.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import top.hermite.repeater.pigeon.component.BaseResponse;
import top.hermite.repeater.pigeon.model.OrgElement;
import top.hermite.repeater.pigeon.service.OrgElementServ;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * MIT License Copyright (c) 2019 HermiteZhang
 *
 * @Author HermiteZhang
 * @Email zhangw9409@gmail.com
 * @Date create in 12:22 2019/9/26
 * @Desc:
 */
@RestController
@RequestMapping("/orgElement")
public class OrgElementRestController {
    @Resource
    BaseResponse baseResponse;
    @Autowired
    OrgElementServ orgElementServ;

    @PostMapping(value = "/save", produces = "application/json;charset=utf-8")
    public BaseResponse save(@RequestBody OrgElement element,
                             HttpServletRequest request) {

        try {
            baseResponse = orgElementServ.saveElement(element);
        } catch (Exception e) {

            baseResponse.error(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        }
        return baseResponse;
    }

    @GetMapping(value = "/{id}", produces = "application/json;charset=utf-8")
    public BaseResponse getById(@PathVariable String id,
                                HttpServletRequest request) {
        try {
            baseResponse = orgElementServ.getELement(id);
        } catch (Exception e) {
            baseResponse.error(HttpStatus.BAD_REQUEST.value(), "version code error");
        }
        return baseResponse;
    }

    @GetMapping(value = "/all", produces = "application/json;charset=utf-8")
    public BaseResponse all(HttpServletRequest request) {
        try {
            baseResponse = orgElementServ.listAllElement();
        } catch (Exception e) {
            baseResponse.error(HttpStatus.BAD_REQUEST.value(), "version code error");
        }
        return baseResponse;
    }

    @PutMapping(value = "/update", produces = "application/json;charset=utf-8")
    public BaseResponse update(@RequestBody OrgElement element,
                               HttpServletRequest request) {
        try {
            baseResponse = orgElementServ.updateElement(element);
        } catch (Exception e) {
            baseResponse.error(HttpStatus.BAD_REQUEST.value(), "version code error");
        }
        return baseResponse;
    }

    @DeleteMapping(value = "/{id}", produces = "application/json;charset=utf-8")
    public BaseResponse deleteById(@PathVariable String id,
                               HttpServletRequest request) {
        try {
            baseResponse = orgElementServ.removeElement(id);
        } catch (Exception e) {
            baseResponse.error(HttpStatus.BAD_REQUEST.value(), "version code error");
        }
        return baseResponse;
    }


}


