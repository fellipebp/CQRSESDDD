import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.junit.Test;

import projeto.tcc.dominio.entidades.usuario.Usuario;
import projeto.tcc.interfaceusuario.comandos.CadastrarUsuarioComando;
import projeto.tcc.interfaceusuario.dto.CriarUsuarioDTO;
import static org.junit.Assert.*;

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
			
			usuario = new Usuario().criarCadastro(valores);
			assertTrue(true);
		} catch (Exception e) {
			fail("Não deveria ter passado aqui");
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
