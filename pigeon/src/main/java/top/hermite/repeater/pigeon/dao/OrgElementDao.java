package top.hermite.repeater.pigeon.dao;

import top.hermite.repeater.pigeon.model.OrgElement;

import java.util.List;

/**
 * MIT License Copyright (c) 2019 HermiteZhang
 *
 * @Author HermiteZhang
 * @Email zhangw9409@gmail.com
 * @Date create in 11:28 2019/9/26
 * @Desc:
 */
public interface OrgElementDao {
    void saveElement(OrgElement element);

    void removeElement(String pdId);

    void updateElement(OrgElement element);

    OrgElement getELement(String pdId);

    List<OrgElement> listAllElement();
}
