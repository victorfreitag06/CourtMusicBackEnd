package com.courtmusic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.courtmusic.entities.Usuario;

public interface UsuarioRepository extends JpaRepository <Usuario,Long>{

}
