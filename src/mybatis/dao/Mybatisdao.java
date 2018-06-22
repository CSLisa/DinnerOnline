package mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

public interface Mybatisdao<T> {
	List<T> findByPaging(T condition,RowBounds rowBounds);
}
