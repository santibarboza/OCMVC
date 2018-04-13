package controller;

import view.OCView;

public interface OCController {
	public void setOCView(OCView ocView);

	public void onEventAbrirArchivo();
	public void onEventCompilar(String direccionInicio);
	public void onEventEjecutar();
	public void onEventVerMemoria();
	public void onEventSiguientePaso();
	public void onEventVerAyuda();
}
