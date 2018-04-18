package view;

import java.io.File;

public interface OCView {
	public void updateTextoTutorial(String texto);
	public void updateNombreArchivo(String fileName);
	public void updateContenidoArchivoActual(String contenido);
	public void updateCodigoCompilado(String codigo);
	public void updateRegistros(String[][] registros);
	public void updateMemoria(String[][] memoria);
	public void updatePCView(String pc);
	public void updateInstrucionView(String instruccion);
	public void habilitarOpcionesdeEjecucion();
	public void habilitarOpcionesdeEjecucionPasoaPaso();
	public void deshabilitarOpcionesdeEjecucionPasoaPaso();
	public void habilitarOpcionesdeCompilacion();
	public void mostrarMensaje(String mensaje);
	public String pedirDialogo(String pedido);
	public boolean pedirAbrirArchivo();
	public File recuperarArchivo();
}
