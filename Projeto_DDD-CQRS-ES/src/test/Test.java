package test;

import java.util.UUID;

import projeto.tcc.aplicacao.impl.ServicoUsuarioImpl;
import projeto.tcc.dominio.eventos.Evento;
import projeto.tcc.infraestrutura.Conexao;
import projeto.tcc.interfaceusuario.comandos.CadastrarUsuarioComando;
import projeto.tcc.interfaceusuario.dto.CriarUsuarioDTO;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//testando persistencia e recuperacao do dado
		UUID idOne = UUID.randomUUID();
		CriarUsuarioDTO criarUsuarioDTO = new CriarUsuarioDTO();
		criarUsuarioDTO.setCpf("11111111");
		criarUsuarioDTO.setLogin("aa");
		criarUsuarioDTO.setNome("josé");
		criarUsuarioDTO.setSenha("abcd");
		new ServicoUsuarioImpl().cadastrarUsuario(new CadastrarUsuarioComando(idOne,criarUsuarioDTO));
		try {
			Evento evento = new Conexao().recuperaEvento(idOne.toString());
			System.out.println(evento.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
