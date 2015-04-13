import projeto.tcc.dominio.Usuario;
import projeto.tcc.eventos.EventoProcessador;
import projeto.tcc.eventos.UsuarioCadastrado;


public class Teste {

	
	public static void main(String args[]){
		EventoProcessador eventoProc = new EventoProcessador();
		Usuario usuario = new Usuario("Murilo","123");
		UsuarioCadastrado usuarioCad = new UsuarioCadastrado(1, "testando", usuario); //evento criado
		eventoProc.processar(usuarioCad); //evento processado
	}
	
	
}
