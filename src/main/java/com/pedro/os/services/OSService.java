package com.pedro.os.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.os.domain.Cliente;
import com.pedro.os.domain.OS;
import com.pedro.os.domain.Servicos;
import com.pedro.os.domain.Tecnico;
import com.pedro.os.domain.enums.Prioridade;
import com.pedro.os.domain.enums.Status;
import com.pedro.os.dtos.OSDTO;
import com.pedro.os.repositories.OSRepository;
import com.pedro.os.services.exceptions.ObjectNotFoundException;

@Service
public class OSService {

	@Autowired
	private OSRepository repository;
	
	@Autowired
	private TecnicoService tecnicoService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ServicosService servicosService;
	
	public OS findById(Integer id) {
		Optional<OS> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id:" + id + ", Tipo: " + OS.class.getName()));
	}
	
	public List<OS> findAll() {
		return repository.findAll();
	}

	public OS create(@Valid OSDTO obj) {
		return fromDTO(obj);
	}
	
	public OS update(@Valid OSDTO obj) {
		findById(obj.getId());
		return fromDTO(obj);
	}
	
	private OS fromDTO(OSDTO obj) {
		OS newObj = new OS();
		newObj.setId(obj.getId());
		newObj.setObservacoes(obj.getObservacoes());
		newObj.setPrioridade(Prioridade.toEnum(obj.getPrioridade().getCod()));
		newObj.setStatus(Status.toEnum(obj.getStatus().getCod()));
		
		Tecnico tec = tecnicoService.findById(obj.getTecnico());
		Cliente cli = clienteService.findById(obj.getCliente());
		Servicos ser = servicosService.findById(obj.getServicos());
		
		newObj.setTecnico(tec);
		newObj.setCliente(cli);
		newObj.setServicos(ser);
		
		if(newObj.getStatus().getCod().equals(2)) {
			newObj.setDataFechamento(LocalDateTime.now());
		}
		
		return repository.save(newObj);
	}

	
}
