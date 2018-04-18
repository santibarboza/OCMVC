package presenter;

import view.OCView;

public interface OCPresenter {
	public void setOCView(OCView ocView);
	public void onEventAbrirArchivo();
	public void onEventCompilar(String direccionInicio);
	public void onEventEjecutar();
	public void onEventVerMemoria();
	public void onEventSiguientePaso();
	public void onEventVerAyuda();
	public void mostrarMensaje(String mensaje);
	public String pedirDialogo(String pedido);
}
