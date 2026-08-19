package io.github.gitwillians.base;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;


public abstract class BaseBusinessImpl<T extends BaseEntity, ID> implements BaseBusiness<T, ID> {

    protected abstract BaseRepositoy<T, ID> getRepository();

    @Transactional
    public T insert(T entity){
        if (entity == null)
            throw new RuntimeException("Erro");

        if (entity.getId() == null)
            getRepository().persist(entity);
        else 
            throw new RuntimeException("Erro");
        
        return entity;
    }

    public T findById(ID id) {
        T entity = getRepository().findByIdOptional(id)
            .orElseThrow(() -> new NotFoundException("User not found"));
        return entity;
    }

    public PageResponse<T> findPaged(PageDTO page) {
            
        Sort sort = page.getAscending() ? Sort.by(page.getSortBy()).ascending() : Sort.by(page.getSortBy()).descending();

        PanacheQuery<T> query = getRepository().findAll(sort);

        query.page(Page.of(page.getPageIndex(), page.getPageSize()));

        List<T> content = query.list();
        long totalElements = query.count();
        int totalPages = query.pageCount();

        return new PageResponse<>(content, page.getPageIndex(), page.getPageSize(), totalElements, totalPages);
    }

}