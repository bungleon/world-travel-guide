package com.api.worldtravelguide.domain.custom_repository;


import com.api.worldtravelguide.message.custom.request.SearchRequest;
import org.springframework.data.domain.Page;


public interface CustomRepository {

    <R, S> Page<R> search(Class<R> returnClassType, Class<S> entityType, SearchRequest objects);
}
