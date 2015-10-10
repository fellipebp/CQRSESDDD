package projeto.tcc.infraestrutura;

public interface IPublicador<E> {
	
	public void subscriber(IAssinante<E> sub);
	
	public void publish(E arg);

}
