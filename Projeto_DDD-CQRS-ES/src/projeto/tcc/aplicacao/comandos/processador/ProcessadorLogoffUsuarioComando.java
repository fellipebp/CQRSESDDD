package projeto.tcc.aplicacao.comandos.processador;
//package projeto.tcc.aplicacao.comandos;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import projeto.tcc.dominio.entidades.seguranca.Seguranca;
//import projeto.tcc.interfaceusuario.comandos.Comando;
//import projeto.tcc.interfaceusuario.comandos.DeslogarComando;
//
//public class ProcessadorLogoffUsuarioComando implements ProcessadorComandos {
//
//	@Override
//	public void execute(Comando comando) throws Exception {
//		DeslogarComando deslogarComando = (DeslogarComando) comando;
//		
//		deslogarComando.getAggregateID();
//		deslogarComando.getVersion();
//		
//		Map<String, Object> valores = new HashMap<String, Object>();
//		valores.put("aggregateID", deslogarComando.getAggregateID());
//		
//		new Usu.deslogar(valores);
//		
//		//Ainda nao sei como validar eventos que nao alteram o objeto, pois eu consulto na tabela de agregados a ultima versao do agregado
//		//entretanto, este tipo de evento nao atualiza aquela coluna, só fica na tabela de eventos mesmo
////		PosProcessadorComandos.validaVersaoComando(comando);
//		
//		//COMENTEI, pois no metodo que salva o evento, ele atualiza a coluna version da tabela de agregados,
//		//entretanto este tipo de evento nao deveria mexer naquela coluna pois nao realiza nenhuma modificação
//	//	new EventoProcessador().processarEvento( new UsuarioDeslogadoEvento(deslogarComando.aggregateId(), new Date()));
//
//	}
//
//}
