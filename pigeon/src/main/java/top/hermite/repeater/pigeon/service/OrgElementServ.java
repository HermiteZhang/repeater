package top.hermite.repeater.pigeon.service;

import top.hermite.repeater.pigeon.component.BaseResponse;
import top.hermite.repeater.pigeon.model.OrgElement;

import java.util.List;

/**
 * MIT License Copyright (c) 2019 HermiteZhang
 *
 * @Author HermiteZhang
 * @Email zhangw9409@gmail.com
 * @Date create in 12:14 2019/9/26
 * @Desc:
 */
public interface OrgElementServ {
    BaseResponse saveElement(OrgElement element);

    BaseResponse removeElement(String pId);

    BaseResponse updateElement(OrgElement element);

    BaseResponse getELement(String pId);

    BaseResponse listAllElement();
}
