package top.hermite.repeater.pigeon.dao;

import java.util.List;

import tk.mybatis.mapper.entity.Example;
import top.hermite.repeater.pigeon.model.PigeonRepeaterEntity;
import top.hermite.repeater.pigeon.model.PigeonRepeaterPageDto;

public interface PigeonRepeaterDao <T extends PigeonRepeaterEntity> {

    /**
     * 根据Id查询实体
     */
    public T getEntityById(final Class<T> cls, final Integer id);

    /**
     * 新增实体
     */
    public void addEntity(final T entity);

    /**
     * 更新实体
     */
    public void updateEntity(final T entity);

    /**
     * 根据Id删除实体
     */
    public void deleteEntityById(final Class<T> cls, final Integer id);

    /**
     * 查询全部
     */
    public List<T> selectAll(Class<T> cls);

    /**
     * 单表模糊查询
     */
    public List<T> findByLike(Example example);

    /**
     * 根据模糊分页查询
     */
    public List<T> findByPage(Example example, PigeonRepeaterPageDto pageDto);

    /**
     * 单表模糊查询总记录数
     */
    public int findRowCount(Example example);


}

