import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import projeto.tcc.dominio.entidades.usuario.Usuario;

public class UsuarioTest {

	Usuario usuario;

	@Test
	public void deveCriarUsuario() {
		try {
			Map<String, Object> valores = new HashMap<String, Object>();
			valores.put("login","teste");
			valores.put("senha", "teste");
			valores.put("nome", "teste");
			valores.put("cpf", "9999999999");
			valores.put("email", "teste@gmail.com");
			Calendar dtNascimento = Calendar.getInstance();
			dtNascimento.set(1980, 2, 25);
			valores.put("dtNascimento",dtNascimento.getTime().getTime());
			valores.put("cdPerfil", 1);
			
			usuario = new Usuario().criarCadastro(valores);
			assertTrue(true);
		} catch (Exception e) {
			fail("Não deveria ter passado aqui");
		}

	}
	
	
	@Test
	public void NaoDeveCriarUsuarioPorSerMenorIdade() {
		try {
			Map<String, Object> valores = new HashMap<String, Object>();
			valores.put("login","teste");
			valores.put("senha", "teste");
			valores.put("nome", "teste");
			valores.put("cpf", "9999999999");
			valores.put("email", "teste@gmail.com");
			Calendar dtNascimento = Calendar.getInstance();
			dtNascimento.set(2010, 2, 25);
			valores.put("dtNascimento",dtNascimento.getTime().getTime());
			valores.put("cdPerfil", 1);
			
			usuario = new Usuario().criarCadastro(valores);
			fail("Não deveria ter passado aqui");
		} catch (Exception e) {
			assertTrue(true);
		}

	}
	
	
	
	
//	@Test
//	public void deveFalharCriarUsuarioDuplicado() {
//		try {
//			usuario = new Usuario();
//			Map<String, Object> valores = new HashMap<String, Object>();
//			valores.put("login","teste");
//			valores.put("senha", "teste");
//			valores.put("nome", "teste");
//			valores.put("cpf", "9999999999");
//			valores.put("email", "teste@gmail.com");
//			usuario.criarCadastro(valores);
//			usuario.criarCadastro(valores);
//			fail("Não deveria ter passado aqui");
//		} catch (Exception e) {
//			if (e.getMessage().contains("Já existe um usuário com esse cpf")) {
//				assertTrue(true);
//			}else{
//				fail("Não deveria ter passado aqui");
//			}
//		}
//	}
	
	
//	@Test
//	public void deveFalharUsuarioEditadoMesmaVersao() {
//	}
}
