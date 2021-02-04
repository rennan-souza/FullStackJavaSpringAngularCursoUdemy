package br.com.somenteparaestudosetestes.repository;

import br.com.somenteparaestudosetestes.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
