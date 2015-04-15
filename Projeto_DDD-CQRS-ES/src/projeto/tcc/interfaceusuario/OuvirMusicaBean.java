package projeto.tcc.interfaceusuario;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class OuvirMusicaBean implements Serializable {
	 
	
	private static final long serialVersionUID = -6673863557198240345L;

	public void nada(){
		System.out.println("nada");
	}
}
