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

import com.courtmusic.entities.Usuario;
import com.courtmusic.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	private final UsuarioService usuarioService;
	@Autowired
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
		Usuario usuario = usuarioService.getUsuarioById(id);
		if (usuario != null) {
			return ResponseEntity.ok(usuario);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Usuario>> getAllUsuario() {
		List<Usuario> usuario = usuarioService.getAllUsuario();
		return ResponseEntity.ok(usuario);
	}
	
	//@GetMapping("/data/{data}")
	//public ResponseEntity<List<Usuario>> getPorData(@PathVariable String data){
		//List<Usuario> usuario = usuarioService.getPorData(data);
		//return ResponseEntity.ok(usuario);
	//}
	
	
	@PostMapping("/")
	public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario) {
		Usuario criarUsuario = usuarioService.salvarUsuario(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarUsuario);
	}
	


	@PutMapping("/{id}")
	public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id,@RequestBody Usuario usuario) {
		Usuario updatedUsuario = usuarioService.updateUsuario(id, usuario);
		if (updatedUsuario != null) {
			return ResponseEntity.ok(updatedUsuario);
		} else {
			return ResponseEntity.notFound().build();
		}
		
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUsuario(@PathVariable Long id) {
		boolean deleted = usuarioService.deleteUsuario(id);
		if (deleted) {
			return ResponseEntity.ok().body("O usuario foi excluído com sucesso.");
		} else {
			return ResponseEntity.notFound().build();
		}
	

}

}
