package br.com.fiap.challenge.repository;

import br.com.fiap.challenge.entity.Financeiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinanceiroRepository extends JpaRepository<Financeiro, Long> {
}