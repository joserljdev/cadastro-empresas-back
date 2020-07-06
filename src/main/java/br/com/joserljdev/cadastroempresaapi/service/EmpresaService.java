package br.com.joserljdev.cadastroempresaapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.joserljdev.cadastroempresaapi.domain.Empresa;
import br.com.joserljdev.cadastroempresaapi.domain.Tipo;
import br.com.joserljdev.cadastroempresaapi.repository.EmpresaRepository;
import br.com.joserljdev.cadastroempresaapi.service.exceptions.EmpresaNaoEncontradaException;
import br.com.joserljdev.cadastroempresaapi.service.exceptions.RemoverEmpresaException;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;

	public Empresa buscar(Long id) {
		return empresaRepository.findById(id)
				.orElseThrow(() -> new EmpresaNaoEncontradaException("A empresa não pôde ser encontrada!"));
	}

	private void verificarExistencia(Empresa empresa) {
		buscar(empresa.getId());
	}

	public Empresa salvar(Empresa empresa) {
		return empresaRepository.save(empresa);
	}

	public void alterar(Empresa empresa) {
		verificarExistencia(empresa);
		empresaRepository.save(empresa);
	}

	public void deletar(Long id) {
		Optional<Empresa> empresa = empresaRepository.findById(id);

		empresa.map(e -> new Empresa())
				.orElseThrow(() -> new EmpresaNaoEncontradaException("A empresa não pôde ser encontrada!"));

		empresa.filter(e -> e.getTipo() != Tipo.MATRIZ)
				.orElseThrow(() -> new RemoverEmpresaException("Empresa Matriz não pode ser removida!"));

		empresaRepository.delete(empresa.get());
	}
}