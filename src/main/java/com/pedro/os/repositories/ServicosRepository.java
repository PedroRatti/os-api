package com.pedro.os.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedro.os.domain.Servicos;

@Repository
public interface ServicosRepository extends JpaRepository<Servicos, Integer>{
	
	
	
}
