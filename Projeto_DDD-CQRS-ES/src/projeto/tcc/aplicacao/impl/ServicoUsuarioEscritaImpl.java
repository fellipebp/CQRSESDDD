package projeto.tcc.aplicacao.impl;

import java.io.Serializable;
import java.util.Set;

import projeto.tcc.aplicacao.ServicoUsuarioEscrita;
import projeto.tcc.aplicacao.comandos.ProcessadorCadastrarUsuarioComando;
import projeto.tcc.dominio.entidades.musica.Musica;
import projeto.tcc.dominio.entidades.usuario.Usuario;
import projeto.tcc.interfaceusuario.comandos.AdicionarMusicaComando;
import projeto.tcc.interfaceusuario.comandos.CadastrarUsuarioComando;
import projeto.tcc.interfaceusuario.comandos.DeslogarComando;
import projeto.tcc.interfaceusuario.comandos.EditarUsuarioComando;
import projeto.tcc.interfaceusuario.comandos.FazerLoginComando;
import projeto.tcc.interfaceusuario.comandos.TocarMusicaComando;

public class ServicoUsuarioEscritaImpl implements ServicoUsuarioEscrita, Serializable{
	
	private static final long serialVersionUID = -7673302045438349809L;
	private Usuario usuario;

//	@Override
//	public String logarUsuario(FazerLoginComando fazerLoginComando) throws Exception{
//		usuario = new Usuario();
//		try {
//			return usuario.logar(fazerLoginComando);
//		} catch (Exception e) {
//			throw new RuntimeException(e.getMessage());
//		}
//	}
	
//	@Override
//	public boolean deslogarUsuario(DeslogarComando deslogarComando) {
//		usuario = new Usuario();
//		try {
//			return usuario.deslogar(deslogarComando);
//		} catch (Exception e) {
//			throw new RuntimeException(e.getMessage());
//		}
//	}
//

	//outros métodos omitidos
	
	@Override
	public void cadastrarUsuario(CadastrarUsuarioComando cadastrarUsuarioComando) {
		try {
			new ProcessadorCadastrarUsuarioComando().execute(cadastrarUsuarioComando);
			//CRIAR METODO EXECUT
			//ESTE PROCESSADOR FICA RESPONSAVEL POR PROCESSAR APENAS O METODO DO DOMINIO criarCadastro
			//CRIAR DTO COMO PARAMETRO DO METODO DO NEGOCIO
			//GERAR EVENTO DENTRO DO PROCESSADOR DE COMANDOS
			//CARREGAR OBJETO (COPIA) DO DOMINIO (CHAMAR REPOSITORIO) DENTRO DO PROCESSADOR
			
			
			//usuario.criarCadastro(cadastrarUsuarioComando.getNome(), get, get get);
	
		
			//CRIAR CLASSE (POS PROCESSADOR DE COMANDOS) e que tenha um método SINCRONYZED
			// ESTE MÉTODO VAI BUSCAR NO REPOSITORIO A VERSAO ASSOCIADA E VERIFICAR SE O COMANDO X que chegou TEM A MESMA VERSAO DO CARREGADO DO REPOSITORIO (SÓ CARREGA VERSAO)
			//SE SIM, RETORNA TRUE, ENTAO O PROCESSADOR DE COMANDOS INVOCA O PROCESSADOR DE EVENTOS PASSANDO O EVENTO
			//SE NAO, RETORNA FALSE, E LANÇA EXCEÇÃO DE CONCORRENCIA
		
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void editarInformacoesUsuario(EditarUsuarioComando editarUsuarioComando) {
		usuario = new Usuario();
		try {
			usuario.editarInformacoes(editarUsuarioComando);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
