import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import projeto.tcc.dominio.entidades.seguranca.Seguranca;
import projeto.tcc.dominio.eventos.perfilusuario.PerfilAdicionadoEvento;
import projeto.tcc.interfaceusuario.comandos.DeslogarComando;

public class SegurancaTest {

	Seguranca seguranca;
//
//	public void naoDeveRegistrarAuditoria() {
//		try {
//			seguranca.registraAuditoria(new PerfilAdicionadoEvento());
//			fail("Deveria ter lançado a exceção.");
//		} catch (Exception e) {
//			if (e.getMessage()
//					.contains(
//							"Ocorreu um erro no processamento da sua ação. Relogue e tente novamente.")) {
//				assertTrue(true);
//			} else {
//				fail("Nao deveria ter passado aqui.");
//			}
//
//		}

//	}
	
	
	@Test
	public void naoDeveDeslogarUsuario(){
		seguranca = new Seguranca();
		try {
			Map<String, Object> valores = new HashMap<String, Object>();
			seguranca.deslogar(valores);
			fail();
		} catch (Exception e) {
			assertTrue(true);
		}
		
	}
}
