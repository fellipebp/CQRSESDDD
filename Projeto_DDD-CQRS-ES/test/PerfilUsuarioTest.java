import projeto.tcc.dominio.enums.PerfilEnums;
import static org.junit.Assert.*;

public class PerfilUsuarioTest {

	public void deveExistirTresPerfisRegistrados() {
		try {
			assertEquals(3, PerfilEnums.values().length);
		} catch (Exception e) {
			fail();
		}
	}

}
