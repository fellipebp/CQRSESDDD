package projeto.tcc.infraestrutura;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import projeto.tcc.infraestrutura.armazenamento.ArmazenadorEventos;

public class ControlerVersionValidator {
	

	//TODAS AS THREADS 
	
	
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
	
	public static Integer getProximaVersaoAgregado(String aggregateID){
		return ArmazenadorEventos.getProximaVersaoAgregado(aggregateID)+1;
	}
}
