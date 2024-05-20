package br.com.fiap.challenge.repository;

import br.com.fiap.challenge.entity.Cadastro;
import br.com.fiap.challenge.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CadastroRepository extends JpaRepository<Cadastro, Long> {
}