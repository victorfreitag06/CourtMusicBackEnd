package com.courtmusic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courtmusic.entities.Musica;
import com.courtmusic.repository.MusicaRepository;

@Service
public class MusicaService {

private final MusicaRepository musicaRepository;
	
	@Autowired
	public MusicaService(MusicaRepository musicaRepository) {
		this.musicaRepository = musicaRepository;
	}

	public List<Musica> getAllMusica() {
		return musicaRepository.findAll();
	}

	public Musica getMusicaById(Long id) {
		Optional<Musica> Musica = musicaRepository.findById(id);
		return Musica.orElse(null);
	}
	//Query Method
	//public List<Musica> getPorData(String data){
		//return musicaRepository.findByData(data);
	//}

	public Musica salvarMusica(Musica musica) {
		return musicaRepository.save(musica);
	}

	public Musica updateMusica(Long id, Musica updatedMusica) {
		Optional<Musica> existingMusica = musicaRepository.findById(id);
		if (existingMusica.isPresent()) {
			updatedMusica.setId(id);
			return musicaRepository.save(updatedMusica);
		}
		return null;
	}

	public boolean deleteMusica(Long id) {
		Optional<Musica> existingMusica = musicaRepository.findById(id);
		if (existingMusica.isPresent()) {
			musicaRepository.deleteById(id);
			return true;
		}
		return false;
	}

}



