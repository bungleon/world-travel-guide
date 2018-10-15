package com.api.worldtravelguide.domain.country;

import com.api.worldtravelguide.domain.custom_repository.CustomRepository;
import com.api.worldtravelguide.message.custom.request.SearchRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CountryRepository extends CustomRepository, JpaRepository<Country, UUID> {
    Country findByIdAndDeletedFalse(UUID id);

    Country findByBinaryCodeAndDeletedFalse(String binaryCode);

    List<Country> findAllByDeletedFalse();

    <R, S> Page<R> search(Class<R> returnClassType, Class<S> type2, SearchRequest object);
}
