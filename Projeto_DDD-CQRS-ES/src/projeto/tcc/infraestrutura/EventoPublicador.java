package projeto.tcc.infraestrutura;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import projeto.tcc.dominio.eventos.Evento;

@ApplicationScoped
public class EventoPublicador implements IPublicador<Evento> {

	private static Queue<Evento> filaEventos = new LinkedList<>();
	private final ExecutorService pool = Executors.newFixedThreadPool(10);
	private Calendar dataUltimaPublicacao;
	private List<IAssinante<Evento>> assinantes;
	
	public EventoPublicador() {
		assinantes = new ArrayList<>();
	}
	
	@PostConstruct
	public void init(){
	
		teste(); // esta em faze de testes usando essa tecnologia FUTURE
	
	}
	

	public boolean tempoUltPublicaoMaiorQue30Segundos() {
		return (((Calendar.getInstance().getTimeInMillis() - dataUltimaPublicacao.getTimeInMillis()) / 1000) > 30);
	}
	
	public Future<String> teste(){
		
		 return pool.submit(new Callable<String>() {
		        @Override
		        public String call() throws Exception {
		                publicar2(filaEventos);
						return "Processado";
		        }
		    });
		
	}
	
	public void publicar2(Queue<Evento> filaEventos){
		
		for (Evento evento : filaEventos) {
		//	manipuladorEventos.trata(evento);
			publish(evento);
		}
		filaEventos.clear();

	}

	public void publicar() {
		dataUltimaPublicacao = Calendar.getInstance();
		for (Evento evento : filaEventos) {
			publish(evento);
			//manipuladorEventos.trata(evento);
		}
		filaEventos.clear();

	}

	public static void adicionaEventos(List<Evento> eventos) {
		for (Evento evento : eventos) {
			filaEventos.add(evento);
		}
	}

	public static void adicionaEvento(Evento evento) {
		filaEventos.add(evento);
	}

	@Override
	public void subscriber(IAssinante<Evento> sub) {
			assinantes.add(sub);
		
	}

	@Override
	public void publish(Evento arg) {
		for (IAssinante<Evento> subscriber : assinantes) {
			subscriber.getPublicacao(arg);
		}
	}

	public void publicaEvento(Evento evento) {
		adicionaEvento(evento);
		init();
	}
	
	public void publicaEventos(List<Evento> eventos) {
		adicionaEventos(eventos);
		init();
	}

}
