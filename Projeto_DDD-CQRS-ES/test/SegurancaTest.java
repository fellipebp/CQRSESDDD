import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import projeto.tcc.dominio.entidades.seguranca.Seguranca;
import projeto.tcc.dominio.eventos.perfilusuario.PerfilAdicionadoEvento;
import projeto.tcc.interfaceusuario.comandos.DeslogarComando;

public class SegurancaTest {

	Seguranca seguranca;
//
//	public void naoDeveRegistrarAuditoria() {
//		try {
//			seguranca.registraAuditoria(new PerfilAdicionadoEvento());
//			fail("Deveria ter lan�ado a exce��o.");
//		} catch (Exception e) {
//			if (e.getMessage()
//					.contains(
//							"Ocorreu um erro no processamento da sua a��o. Relogue e tente novamente.")) {
//				assertTrue(true);
//			} else {
//				fail("Nao deveria ter passado aqui.");
//			}
//
//		}

//	}

	public void naoDeveDeslogarUsuario(){
		boolean deslogar;
		try {
			deslogar = seguranca.deslogar(new DeslogarComando(""));
			assertEquals(false, deslogar);
		} catch (Exception e) {
			fail();
		}
		
	}
}
