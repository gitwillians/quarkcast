package io.github.gitwillians.base;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;


public abstract class BaseBusinessImpl<T, ID> implements BaseBusiness<T, ID> {

    protected abstract BaseRepositoy<T, ID> getRepository();

    @Transactional
    public T insert(T entity){
        if (entity == null)
            throw new RuntimeException("message");

        getRepository().persist(entity);
        return entity;
    }

    public T findById(ID id) {
        T entity = getRepository().findByIdOptional(id)
            .orElseThrow(() -> new NotFoundException("User not found"));

        return entity;
        
    }

}