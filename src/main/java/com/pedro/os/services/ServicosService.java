package com.pedro.os.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.os.domain.Servicos;
import com.pedro.os.dtos.ServicosDTO;
import com.pedro.os.repositories.ServicosRepository;
import com.pedro.os.services.exceptions.DataIntegratyViolationException;
import com.pedro.os.services.exceptions.ObjectNotFoundException;

@Service
public class ServicosService {

	@Autowired
	private ServicosRepository servicosRepository;

	/*
	 * Busca Servicos pelo ID
	 */
	public Servicos findById(Integer id) {
		Optional<Servicos> obj = servicosRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + ", Tipo: " + Servicos.class.getName()));
	}

	public List<Servicos> findAll() {
		return servicosRepository.findAll();
	}

	public Servicos create(ServicosDTO objDTO) {
		return servicosRepository.save(new Servicos(null, objDTO.getNome(), objDTO.getCusto(), objDTO.getTelefone()));
	}

	/*
	 * Atualiza um Servicos
	 */
	public Servicos update(Integer id, @Valid ServicosDTO objDTO) {
		Servicos oldObj = findById(id);

		oldObj.setNome(objDTO.getNome());
		oldObj.setCusto(objDTO.getCusto());
		oldObj.setTelefone(objDTO.getTelefone());
		return servicosRepository.save(oldObj);
	}

	/*
	 * Deleta um Servicos pelo ID
	 */
	public void delete(Integer id) {
		Servicos obj = findById(id);

//		if (obj.getList().size() > 0) {
//			throw new DataIntegratyViolationException("Serviço possui Ordens de Serviço, não pode ser deletado!");
//		}

		servicosRepository.deleteById(id);

	}

}