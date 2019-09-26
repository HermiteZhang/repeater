package top.hermite.repeater.pigeon.core.base.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;
import top.hermite.repeater.pigeon.core.component.util.GenericeClassUtils;
import top.hermite.repeater.pigeon.core.component.util.IDGenerator;
import top.hermite.repeater.pigeon.core.base.dao.BaseDao;
import top.hermite.repeater.pigeon.core.base.dao.impl.MyBatisBaseDaoImpl;
import top.hermite.repeater.pigeon.core.base.model.BaseEntity;
import top.hermite.repeater.pigeon.core.base.model.dto.BaseResultDto;
import top.hermite.repeater.pigeon.core.base.service.IBaseService;

@Service("baseMybatisService")
public class MyBatisBaseServiceImpl<T extends BaseEntity> implements IBaseService<T> {

    @SuppressWarnings("unchecked")
    protected Class<T> entityClass = (Class<T>) GenericeClassUtils.getSuperClassGenricType(this.getClass(), 0);

    protected <M extends Mapper<T>> M getMapper(Class cls) {
        return ((MyBatisBaseDaoImpl<T>) baseDao).getMapper(cls);
    }

    @Resource(name = "myBatisBaseDao")
    private BaseDao<T> baseDao;

    @Override
    public BaseResultDto getEntityById(String id) {
        try{
            return BaseResultDto.getOk(baseDao.getEntityById(entityClass, id));
        }catch (Exception ex){
            return BaseResultDto.errorException(ex);
        }
    }

    @Override
    public BaseResultDto listAll() {
        try{
            return BaseResultDto.listOk(baseDao.listAll(entityClass));
        }catch (Exception ex){
            return BaseResultDto.errorException(ex);
        }
    }

    @Override
    public BaseResultDto insert(T entity) {
        try{
            entity.setPdId( IDGenerator.generateID());
            baseDao.insert(entity);
            return BaseResultDto.insertOk(entity.getPdId());
        }catch (Exception ex){
            return BaseResultDto.errorException(ex);
        }
    }

    @Override
    public BaseResultDto update(T entity) {
        try{
            baseDao.update(entity);
            return BaseResultDto.updateOk(entity.getPdId());
        }catch (Exception ex){
            return BaseResultDto.errorException(ex);
        }
    }

    @Override
    public BaseResultDto deleteById(String id) {

        try{
            baseDao.delete(entityClass, id);
            return BaseResultDto.deleteOk(id);
        }catch (Exception ex){
            return BaseResultDto.errorException(ex);
        }

    }

}
