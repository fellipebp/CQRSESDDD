package projeto.tcc.infraestrutura;

import projeto.tcc.dominio.eventos.Evento;
import projeto.tcc.dominio.eventos.usuario.UsuarioCadastradoEvento;

public class UsuarioCadastradoManipulador implements ManipuladorEventos{

	@Override
	public void trata(Evento evento) {
		UsuarioCadastradoEvento usuarioCadastradoEvento = (UsuarioCadastradoEvento) evento;
		usuarioCadastradoEvento.getLogin();
		usuarioCadastradoEvento.getSenha();
		usuarioCadastradoEvento.getAggregateId();

		//INSERT INTO VIEW X
	}

}
