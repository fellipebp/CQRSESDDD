package projeto.tcc.infraestrutura;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import projeto.tcc.dominio.eventos.Evento;
import projeto.tcc.dominio.eventos.usuario.UsuarioCadastradoEvento;

//@Singleton
public class Publicador {

	private static Queue<Evento> filaEventos;
	private Calendar dataUltimaPublicacao;
	//@Inject
	private ManipuladorEventos manipuladorEventos = new UsuarioCadastradoManipulador();

	public Publicador() {
		dataUltimaPublicacao = Calendar.getInstance();
		filaEventos = new LinkedList<>();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				if (filaEventos.size() == 5
						|| (!filaEventos.isEmpty() && tempoUltPublicaoMaiorQue30Segundos())) {
					publicar();
				}

			}
		};
		Timer timer = new Timer();
		long delay = 0;
		long intevalPeriod = 1 * 1000;
		timer.scheduleAtFixedRate(task, delay, intevalPeriod);
	}

	public boolean tempoUltPublicaoMaiorQue30Segundos() {
		return (((Calendar.getInstance().getTimeInMillis() - dataUltimaPublicacao.getTimeInMillis()) / 1000) > 30);
	}

	public void publicar() {
		dataUltimaPublicacao = Calendar.getInstance();
		for (Evento evento : filaEventos) {
			manipuladorEventos.trata(evento);
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

	public static void main(String[] args) {
		Publicador publicador = new Publicador();
		for (int i = 0; i < 5; i++) {
			publicador.adicionaEvento(new UsuarioCadastradoEvento(UUID.randomUUID(), "jajaja", "jajaja"));
		}

	}

}
