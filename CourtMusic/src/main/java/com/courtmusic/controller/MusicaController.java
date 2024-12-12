package com.courtmusic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.courtmusic.entities.Musica;
import com.courtmusic.service.MusicaService;

@RestController
@RequestMapping("/musica")
@CrossOrigin(origins = "*")
public class MusicaController {

	private final MusicaService musicaService;
	@Autowired
	public MusicaController(MusicaService musicaService) {
		this.musicaService = musicaService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Musica> getMusicaById(@PathVariable Long id) {
		Musica musica = musicaService.getMusicaById(id);
		if (musica != null) {
			return ResponseEntity.ok(musica);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Musica>> getAllMusica() {
		List<Musica> musica = musicaService.getAllMusica();
		return ResponseEntity.ok(musica);
	}
	
	//@GetMapping("/data/{data}")
	//public ResponseEntity<List<Musica>> getPorData(@PathVariable String data){
		//List<Musica> musica = musicaService.getPorData(data);
		//return ResponseEntity.ok(musica);
	//}
	
	
	@PostMapping("/")
	public ResponseEntity<Musica> criarMusica(@RequestBody Musica musica) {
		Musica criarMusica = musicaService.salvarMusica(musica);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarMusica);
	}
	


	@PutMapping("/{id}")
	public ResponseEntity<Musica> updateMusica(@PathVariable Long id,@RequestBody Musica musica) {
		Musica updatedMusica = musicaService.updateMusica(id, musica);
		if (updatedMusica != null) {
			return ResponseEntity.ok(updatedMusica);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteMusica(@PathVariable Long id) {
		boolean deleted = musicaService.deleteMusica(id);
		if (deleted) {
			return ResponseEntity.ok().body("O musica foi excluído com sucesso.");
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
