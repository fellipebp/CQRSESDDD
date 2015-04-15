import projeto.tcc.dominio.Usuario;
import projeto.tcc.eventos.EventoProcessador;
import projeto.tcc.eventos.UsuarioCadastradoEvento;
import projeto.tcc.jdbc.Conexao;


public class Teste {

	
	public static void main(String args[]){
		EventoProcessador eventoProc = new EventoProcessador();
		Usuario usuario = new Usuario("Murilo","123");
		UsuarioCadastradoEvento usuarioCad = new UsuarioCadastradoEvento(2, "usuarioCriado", usuario); //evento criado
		try {
			eventoProc.processar(usuarioCad);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //evento processado
	}
	
	
}
