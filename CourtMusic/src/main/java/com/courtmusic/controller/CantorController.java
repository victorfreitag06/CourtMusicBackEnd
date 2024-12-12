package com.courtmusic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.courtmusic.entities.Cantor;
import com.courtmusic.service.CantorService;

@RestController
@RequestMapping("/cantor")
public class CantorController {

	private final CantorService cantorService;
	@Autowired
	public CantorController(CantorService cantorService) {
		this.cantorService = cantorService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cantor> getCantorById(@PathVariable Long id) {
		Cantor cantor = cantorService.getCantorById(id);
		if (cantor != null) {
			return ResponseEntity.ok(cantor);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Cantor>> getAllCantor() {
		List<Cantor> cantor = cantorService.getAllCantor();
		return ResponseEntity.ok(cantor);
	}
	
	//@GetMapping("/data/{data}")
	//public ResponseEntity<List<Cantor>> getPorData(@PathVariable String data){
		//List<Cantor> cantor = cantorService.getPorData(data);
		//return ResponseEntity.ok(cantor);
	//}
	
	
	@PostMapping("/")
	public ResponseEntity<Cantor> criarCantor(@RequestBody Cantor cantor) {
		Cantor criarCantor = cantorService.salvarCantor(cantor);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarCantor);
	}
	


	@PutMapping("/{id}")
	public ResponseEntity<Cantor> updateCantor(@PathVariable Long id,@RequestBody Cantor cantor) {
		Cantor updatedCantor = cantorService.updateCantor(id, cantor);
		if (updatedCantor != null) {
			return ResponseEntity.ok(updatedCantor);
		} else {
			return ResponseEntity.notFound().build();
		}
		
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCantor(@PathVariable Long id) {
		boolean deleted = cantorService.deleteCantor(id);
		if (deleted) {
			return ResponseEntity.ok().body("O cantor foi excluído com sucesso.");
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
