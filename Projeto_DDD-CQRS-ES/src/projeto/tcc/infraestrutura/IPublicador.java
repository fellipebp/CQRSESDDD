package projeto.tcc.infraestrutura;

public interface IPublicador<E> {
	
	public void assina(IAssinante<E> assinante);
	
	public void publica(E arg);

}
