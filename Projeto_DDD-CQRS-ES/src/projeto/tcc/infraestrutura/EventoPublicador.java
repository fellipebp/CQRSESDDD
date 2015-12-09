package projeto.tcc.infraestrutura;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.enterprise.context.ApplicationScoped;

import projeto.tcc.dominio.eventos.Evento;

@ApplicationScoped
public class EventoPublicador implements IPublicador<Evento> {

	private static Queue<Evento> filaEventos = new LinkedList<>();
	private final ExecutorService pool = Executors.newFixedThreadPool(10);
	private List<IAssinante<Evento>> assinantes;
	
	public EventoPublicador() {
		assinantes = new ArrayList<>();
	}
	
		
	public Future<String> inicializaPublicacao(){
		
		 return pool.submit(new Callable<String>() {
		        @Override
		        public String call() throws Exception {
		                publicar(filaEventos);
						return "Processado";
		        }
		    });
		
	}
	
	public void publicar(Queue<Evento> filaEventos){
		
		for (Evento evento : filaEventos) {
			publica(evento);
		}
		filaEventos.clear();

	}

	public void adicionaEventos(List<Evento> eventos) {
		for (Evento evento : eventos) {
			filaEventos.add(evento);
		}
	}

	@Override
	public void assina(IAssinante<Evento> sub) {
			assinantes.add(sub);
		
	}

	@Override
	public void publica(Evento arg) {
		for (IAssinante<Evento> assinante : assinantes) {
			assinante.getPublicacao(arg);
		}
	}

	public void publicaEventos(List<Evento> eventos) {
		adicionaEventos(eventos);
		inicializaPublicacao();
	}

}
