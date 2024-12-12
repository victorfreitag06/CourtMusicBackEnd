package com.courtmusic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courtmusic.entities.Cantor;
import com.courtmusic.repository.CantorRepository;

@Service
public class CantorService {

private final CantorRepository cantorRepository;
	
	@Autowired
	public CantorService(CantorRepository cantorRepository) {
		this.cantorRepository = cantorRepository;
	}

	public List<Cantor> getAllCantor() {
		return cantorRepository.findAll();
	}

	public Cantor getCantorById(Long id) {
		Optional<Cantor> Cantor = cantorRepository.findById(id);
		return Cantor.orElse(null);
	}
	//Query Method
	//public List<Cantor> getPorData(String data){
		//return cantorRepository.findByData(data);
	//}

	public Cantor salvarCantor(Cantor cantor) {
		return cantorRepository.save(cantor);
	}

	public Cantor updateCantor(Long id, Cantor updatedCantor) {
		Optional<Cantor> existingCantor = cantorRepository.findById(id);
		if (existingCantor.isPresent()) {
			updatedCantor.setId(id);
			return cantorRepository.save(updatedCantor);
		}
		return null;
	}

	public boolean deleteCantor(Long id) {
		Optional<Cantor> existingCantor = cantorRepository.findById(id);
		if (existingCantor.isPresent()) {
			cantorRepository.deleteById(id);
			return true;
		}
		return false;
	}

}




