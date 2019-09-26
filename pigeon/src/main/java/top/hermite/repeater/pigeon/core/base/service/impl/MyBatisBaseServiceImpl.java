package top.hermite.repeater.pigeon.core.base.service.impl;

import org.springframework.stereotype.Service;
import top.hermite.repeater.pigeon.core.base.dao.BaseDao;
import top.hermite.repeater.pigeon.core.base.model.BaseEntity;
import top.hermite.repeater.pigeon.core.base.model.dto.BaseResultDto;
import top.hermite.repeater.pigeon.core.base.service.IBaseService;
import top.hermite.repeater.pigeon.core.component.util.GenericeClassUtils;
import top.hermite.repeater.pigeon.core.component.util.IDGenerator;
import top.hermite.repeater.pigeon.core.component.util.SpringUtil;

@Service("baseMybatisService")
public class MyBatisBaseServiceImpl<T extends BaseEntity> implements IBaseService<T> {

    @SuppressWarnings("unchecked")
    protected Class<T> entityClass = (Class<T>) GenericeClassUtils.getSuperClassGenricType(this.getClass(), 0);


    private BaseDao baseDao;
    protected BaseDao getDao(){
        if(baseDao==null){
            baseDao= (BaseDao)SpringUtil.getBean("myBatisBaseDao");
        }
        return baseDao;
    }

    @Override
    public BaseResultDto getEntityById(String id) {
        try{
            return BaseResultDto.getOk(getDao().getEntityById(entityClass, id));
        }catch (Exception ex){
            return BaseResultDto.errorException(ex);
        }
    }

    @Override
    public BaseResultDto listAll() {
        try{
            return BaseResultDto.listOk(getDao().listAll(entityClass));
        }catch (Exception ex){
            return BaseResultDto.errorException(ex);
        }
    }

    @Override
    public BaseResultDto insert(T entity) {
        try{
            entity.setPdId( IDGenerator.generateID());
            getDao().insert(entity);
            return BaseResultDto.insertOk(entity.getPdId());
        }catch (Exception ex){
            return BaseResultDto.errorException(ex);
        }
    }

    @Override
    public BaseResultDto update(T entity) {
        try{
            getDao().update(entity);
            return BaseResultDto.updateOk(entity.getPdId());
        }catch (Exception ex){
            return BaseResultDto.errorException(ex);
        }
    }

    @Override
    public BaseResultDto deleteById(String id) {

        try{
            getDao().delete(entityClass, id);
            return BaseResultDto.deleteOk(id);
        }catch (Exception ex){
            return BaseResultDto.errorException(ex);
        }

    }

}
