package model;

import model.Archivos.Archivo;
import model.Archivos.ArchivoAbstractFactory;

public interface OCModel {
	public boolean compilaElArchivo(Archivo archivo, String DireccionInicio);
	public String obtenerCodigoCompilado();
	public void setListener(OCModelListener listener);
	public void mostrarMensaje(String mensaje);
	public String pedirDialogo(String pedido);
	public ArchivoAbstractFactory getCreadorArchivo();
}
