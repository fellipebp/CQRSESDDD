package projeto.tcc.infraestrutura;

import projeto.tcc.dominio.eventos.Evento;
import projeto.tcc.dominio.eventos.usuario.CarregarUsuarioEvento;
import projeto.tcc.dominio.eventos.usuario.UsuarioCadastradoEvento;
import projeto.tcc.dominio.eventos.usuario.UsuarioLogadoEvento;


public class SincronizadorFontesDados implements Runnable {
	private Evento evento;

	public SincronizadorFontesDados(Evento evento) {
		this.evento = evento;
	}

	@Override
	public void run() {
		verificaInstancia();

	}

	private void verificaInstancia() {
		Class<?> cls;
		try {
			cls = Class.forName(evento.getClass().getName());
			if (cls.isInstance(UsuarioCadastradoEvento.class)) {
				//faz o cast e chama tratador dessa classe
			}
			if (cls.isInstance(UsuarioLogadoEvento.class)) {
				//faz o cast e chama tratador dessa classe
			}
			if (cls.isInstance(CarregarUsuarioEvento.class)) {
				//faz o cast e chama tratador dessa classe
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
