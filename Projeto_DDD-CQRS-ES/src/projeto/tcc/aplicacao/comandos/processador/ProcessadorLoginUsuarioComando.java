package projeto.tcc.aplicacao.comandos.processador;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import projeto.tcc.aplicacao.comandos.PosProcessadorComandos;
import projeto.tcc.aplicacao.comandos.ProcessadorComandos;
import projeto.tcc.dominio.entidades.usuario.Usuario;
import projeto.tcc.dominio.eventos.EventoProcessador;
import projeto.tcc.dominio.eventos.usuario.UsuarioCadastradoEvento;
import projeto.tcc.dominio.eventos.usuario.UsuarioLogadoEvento;
import projeto.tcc.infraestrutura.ControladorVersao;
import projeto.tcc.infraestrutura.armazenamento.repositorio.impl.RepositorioUsuarioImpl;
import projeto.tcc.interfaceusuario.comandos.Comando;
import projeto.tcc.interfaceusuario.comandos.FazerLoginComando;

public class ProcessadorLoginUsuarioComando implements ProcessadorComandos {

	@Override
	public void execute(Comando comando) throws Exception {
		FazerLoginComando fazerLoginComando = (FazerLoginComando) comando;
		
		RepositorioUsuarioImpl repositorioUsuarioImpl = new RepositorioUsuarioImpl();
		Usuario usuarioBase = repositorioUsuarioImpl.getUsuarioPorAggregateID(fazerLoginComando.getAggregateID().toString());
		
		
		Map<String, Object> valores = new HashMap<String, Object>();
		valores.put("aggregateID", fazerLoginComando.getAggregateID());
		valores.put("senha", fazerLoginComando.getSenha());
		
		
		//CAREGAR USUARIO
		usuarioBase.logar(valores);
		
		//SEMPRE QUE ALTERAR UMA INFORMACAO DE UM COMANDO, AO INVEZ DE ALTERAR O COMANDO EXISTENTE, CRIAR UMA NOVA CLASSE PARA O COMNDO (COMANDO_VERSAO2), CRIAR NOVO EVENTO, 
		//CRIAR NOVO TRATADOR PARA O EVENTO//NOVO SUBSCRIBER//EVITANDO ASSIM "ESTRAGAR" COMANDOS/EVENTOS JA EXISTENTES
		
		//CRIAR UMA COLUNA DO TIPO TIMESTAMP QUE PODERÁ SUBSTITUIR A COLUNA INTEIRO DE VERSAO, POIS, CASO EU QUEIRA RECONSTITUIR UMA VIEW ATÉ UMA DATA ESPECIFICA EU TERIA AS DATAS NOS EVENTOS
		//VERIFICAR
		
		//CRIAR COLUNA DATA ULTIMA LOGIN NA ENTIDADE USUARIO e sempre alterar quando gerar o evento de login. Problema resolvido

		//Ainda nao sei como validar eventos que nao alteram o objeto, pois eu consulto na tabela de agregados a ultima versao do agregado
		//entretanto, este tipo de evento nao atualiza aquela coluna, só fica na tabela de eventos mesmo
		PosProcessadorComandos.validaVersaoComando(comando);
		
		Long version = ControladorVersao.getProximaVersao();
		//COMENTEI, pois no metodo que salva o evento, ele atualiza a coluna version da tabela de agregados,
		//entretanto este tipo de evento nao deveria mexer naquela coluna pois nao realiza nenhuma modificação
		new EventoProcessador().processarEvento(new UsuarioLogadoEvento(UUID.fromString(usuarioBase.getAggregateID()), usuarioBase.getLogin(), usuarioBase.getSenha(),new Date(), version, version));
	}

}
