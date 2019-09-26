package top.hermite.repeater.pigeon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.hermite.repeater.pigeon.core.component.BaseResponse;
import top.hermite.repeater.pigeon.core.component.util.IDGenerator;
import top.hermite.repeater.pigeon.core.service.impl.MyBatisBaseServiceImpl;
import top.hermite.repeater.pigeon.organization.OrgElement;

import java.util.List;

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

//    @Autowired
//    BaseDao myBatisBaseDao;


    @Autowired
    BaseResponse baseResponse;
    @Override
    public List<OrgElement> listAll() {
        System.out.println("12312");
        return super.listAll();
    }

    @Override
    public BaseResponse saveElement(OrgElement element) {
        element.setPdId(IDGenerator.generateID());
        String sid=element.getPdId();
      //  myBatisBaseDao.insert(element);
     //  orgElementDao.insert(element);

        baseResponse.empty();
        baseResponse.success(sid);
        return  baseResponse;
    }

    @Override
    public BaseResponse removeElement(String pId) {
       // orgElementDao.removeElement(pId);
        baseResponse.success("del");
        return baseResponse;
    }

    @Override
    public BaseResponse updateElement(OrgElement element) {
        //orgElementDao.updateElement(element);
        baseResponse.success(element.getPdId());
        return baseResponse;
    }

    @Override
    public BaseResponse getELement(String pId) {
       // baseResponse.success(orgElementDao.getELement(pId));
        return baseResponse;
    }

    @Override
    public BaseResponse listAllElement() {
       // baseResponse.success(orgElementDao.listAllElement());
        return baseResponse;
    }
}
