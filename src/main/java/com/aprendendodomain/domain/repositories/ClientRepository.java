package com.aprendendodomain.domain.repositories;

import com.aprendendodomain.domain.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
