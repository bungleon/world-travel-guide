package com.api.worldtravelguide.domain.custom_repository;

import com.api.worldtravelguide.message.custom.request.SearchRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class CustomRepositoryImpl implements CustomRepository {
    private final EntityManager entityManager;

    public CustomRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public <R, S> Page<R> search(Class<R> returnClassType, Class<S> entityType, SearchRequest searchRequest) {
        //Integer pageNumber = transactionSearchRequest.getPage() == null || transactionSearchRequest.getPage() <= 1 ? 0 : transactionSearchRequest.getPage() - 1;

        Specification<S> specification = CustomSpecs.search(entityType, searchRequest);
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<R> query = cb.createQuery(returnClassType);
        Root<S> root = query.from(entityType);

        query.where(cb.and(specification.toPredicate(root, query, cb)));

        query.multiselect(root);

        Integer firstResult = 0;

        List<R> list = entityManager.createQuery(query)
                .setFirstResult(firstResult)
                .setMaxResults(25)
                .getResultList();


        return new PageImpl<>(list, new PageRequest(0, 25, Sort.Direction.DESC, "updateDate"), 100);
    }
}
