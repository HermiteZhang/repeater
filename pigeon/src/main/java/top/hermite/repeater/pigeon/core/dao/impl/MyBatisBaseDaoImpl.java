package top.hermite.repeater.pigeon.core.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import top.hermite.repeater.pigeon.core.annotation.MapperClass;
import top.hermite.repeater.pigeon.core.dao.BaseDao;

import javax.annotation.Resource;
import java.util.List;

/**
 * MIT License Copyright (c) 2019 HermiteZhang
 *
 * @Author HermiteZhang
 * @Email zhangw9409@gmail.com
 * @Date create in 16:46 2019/9/26
 * @Desc: 通用接口的mybatis/mysql实现
 */
@Repository("myBatisBaseDao")
@SuppressWarnings("unchecked")
public class MyBatisBaseDaoImpl<T> implements BaseDao<T>  {

    @Resource
    @Qualifier("sessionFactory")
    private SqlSessionFactory sqlSessionFactory;

    private SqlSession sqlSession;

    /**
     * 获取mappClass 实体
     * @param cls
     * @param <M>
     * @return
     */
    @SuppressWarnings("rawtypes")
    public <M extends Mapper<T>> M getMapper(Class cls){
        MapperClass mapperClass = (MapperClass) cls.getAnnotation(MapperClass.class);
        if(null == mapperClass){
            throw new RuntimeException("没有注解MapperClass");
        }
        System.out.println(mapperClass.value());
        return (M) getSqlSession().getMapper(mapperClass.value());
    }

    @Override
    public T getEntityById(Class<T> cls, Integer id) {
        return this.getMapper(cls).selectByPrimaryKey(id);
    }

    @Override
    public List<T> listAll(Class<T> cls) {
        return this.getMapper(cls).selectAll();
    }

    @Override
    public void insert(T entity) {
        this.getMapper(entity.getClass()).insert(entity);
    }

    @Override
    public void update(T entity) {
        this.getMapper(entity.getClass()).updateByPrimaryKey(entity);
    }

    @Override
    public void delete(Class<T> cls, Integer id) {
        this.getMapper(cls).deleteByPrimaryKey(id);
    }

    public SqlSession getSqlSession(){
        if (null == sqlSession){
            synchronized (MyBatisBaseDaoImpl.class) {
                this.sqlSession = new SqlSessionTemplate(sqlSessionFactory);
            }
        }
        return this.sqlSession;
    }
}
