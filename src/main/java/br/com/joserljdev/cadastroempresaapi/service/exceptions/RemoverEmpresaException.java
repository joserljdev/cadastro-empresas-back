package br.com.joserljdev.cadastroempresaapi.service.exceptions;

public class RemoverEmpresaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RemoverEmpresaException(String mensagem) {
		super(mensagem);
	}
}