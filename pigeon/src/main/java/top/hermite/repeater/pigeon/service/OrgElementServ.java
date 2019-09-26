package top.hermite.repeater.pigeon.service;

import top.hermite.repeater.pigeon.core.component.BaseResponse;
import top.hermite.repeater.pigeon.core.service.IBaseService;
import top.hermite.repeater.pigeon.organization.OrgElement;

/**
 * MIT License Copyright (c) 2019 HermiteZhang
 *
 * @Author HermiteZhang
 * @Email zhangw9409@gmail.com
 * @Date create in 12:14 2019/9/26
 * @Desc:
 */
public interface OrgElementServ  extends IBaseService<OrgElement> {
    BaseResponse saveElement(OrgElement element);

    BaseResponse removeElement(String pId);

    BaseResponse updateElement(OrgElement element);

    BaseResponse getELement(String pId);

    BaseResponse listAllElement();
}
