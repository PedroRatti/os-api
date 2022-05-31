package com.pedro.os.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pedro.os.domain.Servicos;
import com.pedro.os.dtos.ServicosDTO;
import com.pedro.os.services.ServicosService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/servicos")
public class ServicosResource {

	@Autowired
	private ServicosService service;
	
	/*
	 * Busca pelo ID
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<ServicosDTO> findById(@PathVariable Integer id) {
		ServicosDTO objDTO = new ServicosDTO(service.findById(id));
		return ResponseEntity.ok().body(objDTO);
	}
	
	/*
	 * Lista todos os objetos do tipo Servicos na base
	 */
	@GetMapping
	public ResponseEntity<List<ServicosDTO>> findAll() {
		List<ServicosDTO> listDTO = service.findAll().stream().map(obj -> new ServicosDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDTO);
	}
	
	/*
	 * Cria um novo Servicos
	 */
	@PostMapping
	public ResponseEntity<ServicosDTO> create(@Valid @RequestBody ServicosDTO objDTO) {
		Servicos newObj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	/*
	 *  Atualiza um Servicos
	 */
	@PutMapping(value = "/{id}")
	public ResponseEntity<ServicosDTO> update(@PathVariable Integer id, @Valid @RequestBody ServicosDTO objDTO) {
		ServicosDTO newObj = new ServicosDTO(service.update(id, objDTO));
		return ResponseEntity.ok().body(newObj);
	}
	
	/*
	 * Delete Servicos
	 */
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}
}