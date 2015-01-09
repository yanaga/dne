package me.yanaga.dne.springdata;

import com.mysema.query.types.OrderSpecifier;
import com.mysema.query.types.Predicate;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.util.List;

public interface ListQueryDslPredicateExecutor<T> extends QueryDslPredicateExecutor<T> {

    @Override
    public List<T> findAll(Predicate predicate);

    @Override
    public List<T> findAll(Predicate predicate, OrderSpecifier<?>... orders);

}