package presenter;

import view.OCView;

public interface OCPresenter {
	public void setOCView(OCView ocView);
	public void onEventAbrirArchivo();
	public void onEventCompilar(String contenido,String direccionInicio);
	public void onEventEjecutar(boolean esEjecucionTotal);
	public void onEventVerMemoria();
	public void onEventSiguientePaso();
	public void onEventVerAyuda();
//	public void onEventCargarDesdePanel(String text,String direccionInicio);
	public void mostrarMensaje(String mensaje);
	public String pedirDialogo(String pedido);
	public void updateRegistros(String[][] registros);
	public void updateMemoria(String[][] memoria);
	public void updatePCView(String pc);
	public void updateInstrucionView(String instruccion);
}
