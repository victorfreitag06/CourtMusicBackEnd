package com.courtmusic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.courtmusic.entities.Musica;
@Repository
public interface MusicaRepository extends JpaRepository <Musica,Long> {

}
