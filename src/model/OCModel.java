package model;

import presenter.OCPresenter;
import model.Archivos.Archivo;
import model.Archivos.ArchivoAbstractFactory;

public interface OCModel {
	public ArchivoAbstractFactory getCreadorArchivo();
	public boolean compilaElArchivo(Archivo archivo, String DireccionInicio);
	public String obtenerCodigoCompilado();
	public void setOCPresenter(OCPresenter ocPresenter) ;
	public void mostrarMensaje(String mensaje);
	public String pedirDialogo(String pedido);
}
