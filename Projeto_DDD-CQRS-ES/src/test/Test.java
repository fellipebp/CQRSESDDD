package test;

import projeto.tcc.dominio.Usuario;
import projeto.tcc.eventos.EventoProcessador;
import projeto.tcc.eventos.usuario.UsuarioCadastradoEvento;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Usuario usuario = new Usuario(1, "Murilo", "123");
		UsuarioCadastradoEvento usuarioEvento = new UsuarioCadastradoEvento("teste", usuario);
		EventoProcessador ep = new EventoProcessador();
		try {
			ep.processar(usuarioEvento);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
