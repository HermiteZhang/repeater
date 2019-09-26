package top.hermite.repeater.pigeon.organization.dao;

import org.springframework.stereotype.Repository;
import top.hermite.repeater.pigeon.core.base.dao.impl.MyBatisBaseDaoImpl;
import top.hermite.repeater.pigeon.organization.OrgElement;

import java.util.List;

/**
 * MIT License Copyright (c) 2019 HermiteZhang
 *
 * @Author HermiteZhang
 * @Email zhangw9409@gmail.com
 * @Date create in 23:12 2019/9/26
 * @Desc:
 */
@Repository("orgElementDao")
public class OrgElementDaoImpl extends MyBatisBaseDaoImpl<OrgElement>  implements OrgElementDao  {

    @Override
    public List<OrgElement> listAll(Class<OrgElement> cls) {
        System.out.println("this is orgDao");
        return this.getMapper(cls).selectAll();
    }
}
