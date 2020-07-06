package br.com.joserljdev.cadastroempresaapi.controller;

import java.net.URI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.joserljdev.cadastroempresaapi.domain.Empresa;
import br.com.joserljdev.cadastroempresaapi.domain.Endereco;
import br.com.joserljdev.cadastroempresaapi.domain.Tipo;
import br.com.joserljdev.cadastroempresaapi.repository.EmpresaRepository;
import br.com.joserljdev.cadastroempresaapi.repository.filter.EmpresaFilter;
import br.com.joserljdev.cadastroempresaapi.service.EmpresaService;

@CrossOrigin("*")
@RestController
@RequestMapping("/empresas")
public class EmpresaController {

	@Autowired
	private EmpresaService empresaService;

	@Autowired
	private EmpresaRepository empresaRepository;

	@GetMapping
	public Page<Empresa> buscar(EmpresaFilter empresaFilter, Pageable pageable) {
		return empresaRepository.filtrar(empresaFilter, pageable);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Empresa> buscarPeloCodigo(@PathVariable Long codigo) {
		Empresa empresa = empresaService.buscar(codigo);
		return ResponseEntity.ok(empresa);
	}

	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody @Valid Empresa empresa) {
		try {
			empresa = empresaService.salvar(empresa);

			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(empresa.getId())
					.toUri();

			return ResponseEntity.created(uri).build();

		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Void> alterar(@PathVariable("codigo") Long codigo, @RequestBody Empresa empresa) {
		empresa.setId(codigo);
		empresaService.alterar(empresa);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{codigo}")
	public ResponseEntity<Void> deletar(@PathVariable("codigo") Long codigo) {
		empresaService.deletar(codigo);
		return ResponseEntity.noContent().build();
	}

	@GetMapping(value = "/endereco/{cep}")
	public ResponseEntity<Endereco> buscarEnderecoPeloCep(@PathVariable(name = "cep") String cep) {
		RestTemplate restTemplate = new RestTemplate();

		String uri = "http://viacep.com.br/ws/{cep}/json/";

		Map<String, String> params = new HashMap<String, String>();
		params.put("cep", cep);

		Endereco endereco = restTemplate.getForObject(uri, Endereco.class, params);

		return new ResponseEntity<Endereco>(endereco, HttpStatus.OK);
	}

	@GetMapping("/tipos")
	public List<Tipo> listarTipos() {
		return Arrays.asList(Tipo.values());
	}
}