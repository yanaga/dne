package me.yanaga.dne.app.bean;

import me.yanaga.dne.springdata.ListQueryDslPredicateExecutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogFaixaBairroRepository extends JpaRepository<LogFaixaBairro, LogFaixaBairroPK>,
        ListQueryDslPredicateExecutor<LogFaixaBairro> {
}
