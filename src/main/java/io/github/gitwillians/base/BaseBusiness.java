package io.github.gitwillians.base;

public interface BaseBusiness<T, ID> {

    public T insert(T entity);

    public T findById(ID id);

    public PageResponse<T> findPaged(PageDTO page);
	
}