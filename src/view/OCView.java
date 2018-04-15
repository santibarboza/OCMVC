package view;

import java.io.File;

public interface OCView {
	public void updateTextoTutorial(String texto);
	public void updateNombreArchivo(String fileName);
	public void updateContenidoArchivoActual(String contenido);
	public void updateCodigoCompilado(String codigo);
	public void habilitarOpcionesdeEjecucion();
	public void habilitarOpcionesdeCompilacion();
	public void mostrarMensajeError(String mensaje);
	public String pedirDialogo(String pedido);
	public boolean pedirAbrirArchivo();
	public File recuperarArchivo();
}
