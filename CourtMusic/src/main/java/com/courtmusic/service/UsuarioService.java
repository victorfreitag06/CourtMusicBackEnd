package com.courtmusic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courtmusic.entities.Usuario;
import com.courtmusic.repository.UsuarioRepository;

@Service
public class UsuarioService {

private final UsuarioRepository usuarioRepository;
	
	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public List<Usuario> getAllUsuario() {
		return usuarioRepository.findAll();
	}

	public Usuario getUsuarioById(Long id) {
		Optional<Usuario> Usuario = usuarioRepository.findById(id);
		return Usuario.orElse(null);
	}
	//Query Method
	//public List<Usuario> getPorData(String data){
		//return usuarioRepository.findByData(data);
	//}

	public Usuario salvarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public Usuario updateUsuario(Long id, Usuario updatedUsuario) {
		Optional<Usuario> existingUsuario = usuarioRepository.findById(id);
		if (existingUsuario.isPresent()) {
			updatedUsuario.setId(id);
			return usuarioRepository.save(updatedUsuario);
		}
		return null;
	}

	public boolean deleteUsuario(Long id) {
		Optional<Usuario> existingUsuario = usuarioRepository.findById(id);
		if (existingUsuario.isPresent()) {
			usuarioRepository.deleteById(id);
			return true;
		}
		return false;
	}

}




