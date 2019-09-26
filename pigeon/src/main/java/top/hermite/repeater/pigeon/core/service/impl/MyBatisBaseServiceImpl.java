package top.hermite.repeater.pigeon.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;
import top.hermite.repeater.pigeon.core.component.util.GenericeClassUtils;
import top.hermite.repeater.pigeon.core.dao.BaseDao;
import top.hermite.repeater.pigeon.core.dao.impl.MyBatisBaseDaoImpl;
import top.hermite.repeater.pigeon.core.service.IBaseService;

import java.util.List;

@Service("baseMybatisService")
public class MyBatisBaseServiceImpl<T> implements IBaseService<T> {

    @SuppressWarnings("unchecked")
    protected Class<T> entityClass = (Class<T>) GenericeClassUtils.getSuperClassGenricType(this.getClass(), 0);

    protected <M extends Mapper<T>> M getMapper(Class cls) {
        return ((MyBatisBaseDaoImpl<T>) baseDao).getMapper(cls);
    }

    @Resource(name = "myBatisBaseDao")
    private BaseDao<T> baseDao;

    @Override
    public T getEntityById(Integer id) {
        return baseDao.getEntityById(entityClass, id);
    }

    @Override
    public List<T> listAll() {
        return baseDao.listAll(entityClass);
    }

    @Override
    public void insert(T entity) {
        baseDao.insert(entity);
    }

    @Override
    public void update(T entity) {
        baseDao.update(entity);
    }

    @Override
    public void deleteById(Integer id) {

        baseDao.delete(entityClass, id);
    }

}
