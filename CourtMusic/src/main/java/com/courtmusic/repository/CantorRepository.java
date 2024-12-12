package com.courtmusic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.courtmusic.entities.Cantor;

public interface CantorRepository extends JpaRepository <Cantor,Long> {
	
}
