package top.hermite.repeater.pigeon.dao;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;
import top.hermite.repeater.pigeon.component.annotation.MapperClass;
import top.hermite.repeater.pigeon.model.PigeonRepeaterEntity;
import top.hermite.repeater.pigeon.model.PigeonRepeaterPageDto;

import javax.annotation.Resource;
import java.util.List;

/**
 * MIT License Copyright (c) 2019 HermiteZhang
 *
 * @Author HermiteZhang
 * @Email zhangw9409@gmail.com
 * @Date create in 15:16 2019/9/25
 * @Desc:
 */
@Repository(" pigeonRepeaterDao")
@SuppressWarnings("unchecked")
public class PigeonRepeaterDaoImpl<T extends PigeonRepeaterEntity> implements PigeonRepeaterDao<T> {

    @Resource
    @Qualifier("sessionFactory")
    private SqlSessionFactory sqlSessionFactory;

    private SqlSession sqlSession;

    @SuppressWarnings("rawtypes")
    public <M extends Mapper<T>> M getMapper(Class cls){
        MapperClass mapperClass = (MapperClass) cls.getAnnotation(MapperClass.class);
        if(null == mapperClass){
            throw new RuntimeException("没有注解MapperClass");
        }
        return (M) getSqlSession().getMapper(mapperClass.value());
    }

    @Override
    public T getEntityById(Class<T> cls, Integer id) {
        return this.getMapper(cls).selectByPrimaryKey(id);
    }

    @Override
    public void addEntity(T entity) {
        this.getMapper(entity.getClass()).insert(entity);
    }

    @Override
    public void updateEntity(T entity) {
        this.getMapper(entity.getClass()).updateByPrimaryKey(entity);
    }

    @Override
    public void deleteEntityById(Class<T> cls, Integer id) {
        this.getMapper(cls).deleteByPrimaryKey(id);
    }

    @Override
    public List<T> selectAll(Class<T> cls) {
        return this.getMapper(cls).selectAll();
    }

    @Override
    public List<T> findByLike(Example example) {
        return this.getMapper(example.getEntityClass()).selectByExample(example);
    }

    @Override
    public List<T> findByPage(Example example, PigeonRepeaterPageDto pageDto) {

        RowBounds rowBounds = new RowBounds(pageDto.getOffset(), pageDto.getRp());
        return this.getMapper(example.getEntityClass()).selectByExampleAndRowBounds(example, rowBounds);
    }

    @Override
    public int findRowCount(Example example) {
        return this.getMapper(example.getEntityClass()).selectCountByExample(example);
    }

    public SqlSession getSqlSession(){
        if (null == sqlSession){
            synchronized (PigeonRepeaterDaoImpl.class) {
                this.sqlSession = new SqlSessionTemplate(sqlSessionFactory);
            }
        }
        return this.sqlSession;
    }

}
