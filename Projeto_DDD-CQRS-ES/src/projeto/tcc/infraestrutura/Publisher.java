package projeto.tcc.infraestrutura;

public interface Publisher<E> {
	
	public void subscriber(Subscriber<E> sub);
	
	public void publish(E arg);

}
