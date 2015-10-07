package projeto.tcc.infraestrutura;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import projeto.tcc.infraestrutura.armazenamento.ArmazenadorEventos;

public class ControlerVersionValidator {
	
	private static List<String> cacheAggreados = new ArrayList<>();

	public static boolean jaExisteIDAgregadoNaCache(String chave){
		return cacheAggreados.contains(chave);
	}
	
	public static boolean removeIDAgregadoCache(String chave){
		return cacheAggreados.remove(chave);
	}
	
	public static boolean adicionaIDAgregagadoNaCache(String chave){
		return cacheAggreados.add(chave);
	}
	
	public static Long getUltimaVersaoAgregado(String aggregateID){
		return ArmazenadorEventos.getUltimaVersaoAgregado(aggregateID);
	}
	
	public static Long getProximaVersao(){
		return new Timestamp(new Date().getTime()).getTime();
	}
}
