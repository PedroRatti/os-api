package com.pedro.os.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.os.domain.Cliente;
import com.pedro.os.domain.OS;
import com.pedro.os.domain.Servicos;
import com.pedro.os.domain.Tecnico;
import com.pedro.os.domain.enums.Prioridade;
import com.pedro.os.domain.enums.Status;
import com.pedro.os.repositories.ClienteRepository;
import com.pedro.os.repositories.OSRepository;
import com.pedro.os.repositories.ServicosRepository;
import com.pedro.os.repositories.TecnicoRepository;

@Service
public class DBService {
	
	@Autowired
	private ServicosRepository servicosRepository;
	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private OSRepository osRepository;
	
	
	public void instaciaDB() {
		
		Servicos s1 = new Servicos(null, "Nenhum", "R$0", "(88)91111-0000");
		Servicos s2 = new Servicos(null, "Eletricista", "R$110/H", "(88)91111-1111");
		Servicos s3 = new Servicos(null, "Pintor", "R$100/H", "(88)91111-2222");
		Servicos s4 = new Servicos(null, "Limpeza", "R$40/H", "(88)91111-3333");
		Servicos s5 = new Servicos(null, "Vidraceiro", "R$200/H", "(88)91111-4444");
		Servicos s6 = new Servicos(null, "Encanador", "R$100/H", "(88)91111-5555");
		Tecnico t1 = new Tecnico(null, "Pedro Ratti", "597.991.190-14", "Florianópolis", "(88)98888-8888");
		Tecnico t2 = new Tecnico(null, "Fernando Ratti", "656.067.640-40", "Florianópolis", "(88)98888-6666");
		Cliente c1 = new Cliente(null, "Diego Weiss", "835.792.540-57", "Florianópolis", "(88)98888-7777");
		Cliente c2 = new Cliente(null, "Michela Lagranha", "039.077.460-07", "Florianópolis", "(88)98888-5555");

		OS os1 = new OS(null, Prioridade.ALTA, s2 , "Teste create OS", Status.ANDAMENTO, t1, c1);

		t1.getList().add(os1);
		c1.getList().add(os1);

		servicosRepository.saveAll(Arrays.asList(s1, s2, s3, s4, s5, s6));
		tecnicoRepository.saveAll(Arrays.asList(t1, t2));
		clienteRepository.saveAll(Arrays.asList(c1, c2));
		osRepository.saveAll(Arrays.asList(os1));
	}

}
