package test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import projeto.tcc.aplicacao.impl.ServicoUsuarioImpl;
import projeto.tcc.dominio.Usuario;
import projeto.tcc.dominio.eventos.Evento;
import projeto.tcc.dominio.eventos.usuario.UsuarioCadastradoEvento;
import projeto.tcc.dominio.eventos.usuario.UsuarioLogadoEvento;
import projeto.tcc.infraestrutura.EventStore;
import projeto.tcc.interfaceusuario.comandos.CadastrarUsuarioComando;
import projeto.tcc.interfaceusuario.dto.CriarUsuarioDTO;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//teste1();
		teste2();
	}
	
	private static void teste2(){
		UUID idOne = UUID.randomUUID();
		Evento evento = new UsuarioCadastradoEvento(idOne, "aa", "bb");
		Usuario usuario = new Usuario();
		usuario.setLogin("aa");
		usuario.setSenha("bb");
		Evento evento2 = new UsuarioLogadoEvento(idOne, usuario, new Date());
		List<Evento> aaa = new ArrayList<>();
		aaa.add(evento);
		aaa.add(evento2);
		new Usuario().constroiEntidade(aaa);
	}

	private static void teste1() {
		//testando persistencia e recuperacao do dado
		UUID idOne = UUID.randomUUID();
		CriarUsuarioDTO criarUsuarioDTO = new CriarUsuarioDTO();
		criarUsuarioDTO.setCpf("11111111");
		criarUsuarioDTO.setLogin("aa");
		criarUsuarioDTO.setNome("josé");
		criarUsuarioDTO.setSenha("abcd");
		new ServicoUsuarioImpl().cadastrarUsuario(new CadastrarUsuarioComando(idOne,criarUsuarioDTO));
		try {
			Evento evento = new EventStore().recuperaEvento(idOne.toString());
			System.out.println(evento.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
