package me.yanaga.dne.app.bean;

import me.yanaga.dne.springdata.ListQueryDslPredicateExecutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogBairroRepository extends JpaRepository<LogBairro, Integer>,
		ListQueryDslPredicateExecutor<Integer> {

}