package top.hermite.repeater.pigeon.organization.service;

import org.springframework.stereotype.Service;
import top.hermite.repeater.pigeon.core.base.dao.BaseDao;
import top.hermite.repeater.pigeon.core.base.model.dto.BaseResultDto;
import top.hermite.repeater.pigeon.core.base.service.impl.MyBatisBaseServiceImpl;
import top.hermite.repeater.pigeon.core.component.util.SpringUtil;
import top.hermite.repeater.pigeon.organization.OrgElement;
import top.hermite.repeater.pigeon.organization.dao.OrgElementDao;

import javax.annotation.Resource;

/**
 * MIT License Copyright (c) 2019 HermiteZhang
 *
 * @Author HermiteZhang
 * @Email zhangw9409@gmail.com
 * @Date create in 12:15 2019/9/26
 * @Desc:
 */
@Service("orgElementService")
public class OrgElementServImpl extends MyBatisBaseServiceImpl<OrgElement> implements OrgElementServ {

    private OrgElementDao orgElementDaoImpl;
    @Override
    protected OrgElementDao getDao(){
        if(orgElementDaoImpl==null){
            orgElementDaoImpl= (OrgElementDao)SpringUtil.getBean("orgElementDao");
        }
        return orgElementDaoImpl;
    }

    @Override
    public BaseResultDto listAll() {
        System.out.println("重写示例");
        return super.listAll();
    }
}
