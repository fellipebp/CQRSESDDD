import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import projeto.tcc.infraestrutura.Conexao;

import junit.framework.TestCase;

@RunWith(Suite.class)
@SuiteClasses({ MusicaTest.class, 
				UsuarioTest.class, 
				PerfilUsuarioTest.class,
				SegurancaTest.class })
public class ApplicatioTestCase extends TestCase {

	@Override
	protected void setUp() throws Exception {
		Conexao.setConnectionEventSourceConfig("jdbc:mysql://localhost:3306/eventsource_test");
		Conexao.setConnectionReaderConfig("jdbc:mysql://localhost:3306/baseleitura_test");
	}

}
