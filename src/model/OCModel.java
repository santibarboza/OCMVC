package model;

import Excepciones.ErrorEjecucion;
import presenter.OCPresenter;
import model.Archivos.Archivo;
import model.Archivos.ArchivoAbstractFactory;

public interface OCModel {
	public ArchivoAbstractFactory getCreadorArchivo();
	public boolean compilaElArchivo(Archivo archivo, String DireccionInicio);
	public void ejecutarCodigoCompleto() throws ErrorEjecucion;
	public boolean habilitarEjecucionPasoaPaso() throws ErrorEjecucion;
	public boolean ejecutarSiguienteIntruccion() throws ErrorEjecucion;
	public String obtenerCodigoCompilado();
	public void setOCPresenter(OCPresenter ocPresenter) ;
	public void mostrarMensaje(String mensaje);
	public String pedirDialogo(String pedido);
}
