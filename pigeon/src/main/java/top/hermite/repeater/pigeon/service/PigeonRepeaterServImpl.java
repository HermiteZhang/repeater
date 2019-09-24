package top.hermite.repeater.pigeon.service;

import tk.mybatis.mapper.common.Mapper;
import top.hermite.repeater.pigeon.component.util.GenericeClassUtils;
import top.hermite.repeater.pigeon.dao.PigeonRepeaterDao;
import top.hermite.repeater.pigeon.model.PigeonRepeaterEntity;

import javax.annotation.Resource;
import java.util.List;

public class PigeonRepeaterServImpl<T extends PigeonRepeaterEntity>  implements PigeonRepeaterServ<T>{
    @SuppressWarnings("unchecked")
    protected Class<T> entityClass = (Class<T>) GenericeClassUtils.getSuperClassGenricType(this.getClass(), 0);

    protected  <M extends Mapper<T>> M getMapper(Class cls){
        return ((PigeonRepeaterServImpl<T>) baseDao).getMapper(cls);
    }

    @Resource(name = "myBatisBaseDao")
    private PigeonRepeaterDao<T> baseDao;

    @Override
    public T getEntityById(Integer id) {
        return baseDao.getEntityById(entityClass, id);
    }

    @Override
    public void addEntity(T entity) {
        baseDao.addEntity(entity);
    }

    @Override
    public void updateEntity(T entity) {
        baseDao.updateEntity(entity);
    }

    @Override
    public void deleteEntityById(Integer id) {
        baseDao.deleteEntityById(entityClass, id);
    }

    @Override
    public List<T> selectAll() {
        return baseDao.selectAll(entityClass);
    }
}
