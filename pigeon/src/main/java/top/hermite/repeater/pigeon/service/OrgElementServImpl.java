package top.hermite.repeater.pigeon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.hermite.repeater.pigeon.component.BaseResponse;
import top.hermite.repeater.pigeon.component.util.IDGenerator;
import top.hermite.repeater.pigeon.dao.OrgElementDao;
import top.hermite.repeater.pigeon.model.OrgElement;

/**
 * MIT License Copyright (c) 2019 HermiteZhang
 *
 * @Author HermiteZhang
 * @Email zhangw9409@gmail.com
 * @Date create in 12:15 2019/9/26
 * @Desc:
 */
@Service
public class OrgElementServImpl implements OrgElementServ {

    @Autowired
    OrgElementDao orgElementDao;
    @Autowired
    BaseResponse baseResponse;

    @Override
    public BaseResponse saveElement(OrgElement element) {
        element.setPdId(IDGenerator.generateID());
        String sid=element.getPdId();
        orgElementDao.saveElement(element);
        baseResponse.empty();
        baseResponse.success(sid);
        return  baseResponse;
    }

    @Override
    public BaseResponse removeElement(String pId) {
        orgElementDao.removeElement(pId);
        baseResponse.success("del");
        return baseResponse;
    }

    @Override
    public BaseResponse updateElement(OrgElement element) {
        orgElementDao.updateElement(element);
        baseResponse.success(element.getPdId());
        return baseResponse;
    }

    @Override
    public BaseResponse getELement(String pId) {
        baseResponse.success(orgElementDao.getELement(pId));
        return baseResponse;
    }

    @Override
    public BaseResponse listAllElement() {
        baseResponse.success(orgElementDao.listAllElement());
        return baseResponse;
    }
}
