package com.api.worldtravelguide.domain.custom_repository;

import com.api.worldtravelguide.exception.DomainException;
import com.api.worldtravelguide.message.custom.request.SearchRequest;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class CustomSpecs {
    private static final ObjectMapper mapper;

    static {
        mapper = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
    }

    static <R> Specification<R> search(Class<R> type, SearchRequest searchRequest) {
        return (root, query, cb) -> {

            JSONObject equals = null;
            JSONObject equalsNull = null;

            try {
                if (searchRequest.getEquals() != null) {
                    equals = new JSONObject(mapper.writeValueAsString(searchRequest.getEquals()));
                }
                if (searchRequest.getEqualsNull() != null) {
                    equalsNull = new JSONObject(mapper.writeValueAsString(searchRequest.getEqualsNull()));
                }
            } catch (JSONException | JsonProcessingException e) {
                e.printStackTrace();
                throw new DomainException("Cannot parse JSONObject");
            }


            List<Predicate> predicates = new ArrayList();
            if (equals != null) {
                setPredicate(predicates, root, cb, equals, root);
            }
            if (equalsNull != null) {
                setPredicateNull(predicates, root, cb, equalsNull, root);
            }


            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }

    private static void setPredicate(List<Predicate> predicates, Root root, CriteriaBuilder cb, JSONObject searchRequest, Path path) {
        for (int i = 0; i < searchRequest.length(); i++) {
            try {
                System.out.println(searchRequest);
                String pathVariable = (String) searchRequest.names().get(i);
                String value = (String) searchRequest.get((String) searchRequest.names().get(i));
                predicates.add(cb.and(cb.equal(root.get(pathVariable), value)));
            } catch (Exception e) {
                String pathVariable;
                try {
                    pathVariable = (String) searchRequest.names().get(i);
                } catch (JSONException e1) {
                    throw new DomainException("Cannot parse Query");
                }
                try {
                    setPredicate(predicates, root, cb, (JSONObject) searchRequest.get((String) searchRequest.names().get(i)), getPath(path, pathVariable));
                } catch (JSONException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    private static void setPredicateNull(List<Predicate> predicates, Root root, CriteriaBuilder cb, JSONObject searchRequest, Path path) {
        for (int i = 0; i < searchRequest.length(); i++) {
            try {
                System.out.println(searchRequest);
                String pathVariable = (String) searchRequest.names().get(i);
                String value = (String) searchRequest.get((String) searchRequest.names().get(i));
                predicates.add(cb.and(cb.equal(root.get(pathVariable), null)));
            } catch (Exception e) {
                String pathVariable;
                try {
                    pathVariable = (String) searchRequest.names().get(i);
                } catch (JSONException e1) {
                    throw new DomainException("Cannot parse Query");
                }
                try {
                    setPredicate(predicates, root, cb, (JSONObject) searchRequest.get((String) searchRequest.names().get(i)), getPath(path, pathVariable));
                } catch (JSONException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    private static Path getPath(Path path, String key) {
        return path.get(key);
    }
}
