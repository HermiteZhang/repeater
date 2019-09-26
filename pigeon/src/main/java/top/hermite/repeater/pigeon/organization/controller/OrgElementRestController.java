package top.hermite.repeater.pigeon.organization.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.hermite.repeater.pigeon.core.component.util.SpringUtil;
import top.hermite.repeater.pigeon.core.base.controller.BaseController;
import top.hermite.repeater.pigeon.organization.OrgElement;
import top.hermite.repeater.pigeon.organization.service.OrgElementServ;

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
public class OrgElementRestController extends BaseController<OrgElement> {

    private OrgElementServ orgElementServImpl;

    @Override
    protected OrgElementServ  getServiceImpl(){
        if(orgElementServImpl==null){
            orgElementServImpl= (OrgElementServ) SpringUtil.getBean("orgElementService");
        }
        return orgElementServImpl;
    }


}


