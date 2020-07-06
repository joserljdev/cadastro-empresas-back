package br.com.joserljdev.cadastroempresaapi.repository.empresa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.joserljdev.cadastroempresaapi.domain.Empresa;
import br.com.joserljdev.cadastroempresaapi.repository.filter.EmpresaFilter;

public interface EmpresaRepositoryQuery {
	public Page<Empresa> filtrar(EmpresaFilter empresaFilter, Pageable pageable);
}
