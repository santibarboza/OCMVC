package presenter;

import Excepciones.ErrorEjecucion;
import Excepciones.ErrorOCUNS;
import view.OCView;
import model.OCModel;
import model.Archivos.Archivo;
import model.Archivos.ArchivoAbstractFactory;

public class OCPresenterImpl implements OCPresenter {

		private OCModel ocModel;
		private OCView ocView;
		private Archivo archivoActual;
		
		OCPresenterImpl(OCModel ocModel) {
			this.ocModel = ocModel;
		}
		public void setOCView(OCView ocView) {
			this.ocView = ocView;
		}
		@Override
		public void onEventAbrirArchivo() {
			if(ocView.pedirAbrirArchivo()){
				updateArchivoActual();
				String fileName=archivoActual.getName();
				ocView.habilitarOpcionesdeCompilacion();
				ocView.updateTextoTutorial("Archivo Cargado con Exito! Puede Compilarlo o Abrir uno nuevo");
				ocView.updateNombreArchivo(fileName);
				updateContenidoArchivoActual(fileName);
			}
		}
		private void updateArchivoActual(){
			try{
				ArchivoAbstractFactory maker= ocModel.getCreadorArchivo();
				archivoActual=maker.crearArchivo(ocView.recuperarArchivo());
			}catch(ErrorOCUNS error){
				ocView.mostrarMensaje(error.getMessage());
			}
		}
		private void updateContenidoArchivoActual(String fileName) {
			try{
				ocView.updateContenidoArchivoActual(ocModel.getCreadorArchivo().cat(fileName));
			}catch(ErrorOCUNS error){
				ocView.mostrarMensaje(error.getMessage());
			}
		}
		@Override
		public void onEventCompilar(String direccionInicio) {
			updateArchivoActual();
			if(ocModel.compilaElArchivo(archivoActual, direccionInicio)){
				ocView.habilitarOpcionesdeEjecucion();
				ocView.updateCodigoCompilado(ocModel.obtenerCodigoCompilado());
				ocView.mostrarMensaje("El Archivo se compilo correctamente");
			}
		}
		@Override
		public void onEventEjecutar(boolean esEjecucionTotal) {
			try {
				if(esEjecucionTotal)
					ocModel.ejecutarCodigoCompleto();
				else{
					ocModel.habilitarEjecucionPasoaPaso();
					ocView.habilitarOpcionesdeEjecucionPasoaPaso();
				}
			} catch (ErrorEjecucion e) {
				ocView.mostrarMensaje(e.getMessage());
			}
		}
		@Override
		public void onEventVerMemoria() {
			ocView.mostrarMemoria();
		}
		@Override
		public void onEventSiguientePaso() {
			try {
				if(ocModel.hayCodigoParaEjecutar())
					ocModel.ejecutarSiguienteIntruccion();
				else
					ocView.deshabilitarOpcionesdeEjecucionPasoaPaso();
			} catch (ErrorEjecucion e) {
				ocView.mostrarMensaje(e.getMessage());
			}
		}
		@Override
		public void onEventVerAyuda() {
			ocView.mostrarAyuda();
		}
		//Funciones Model->View
		@Override
		public void mostrarMensaje(String mensaje) {
			ocView.mostrarMensaje(mensaje);
		}
		@Override
		public String pedirDialogo(String pedido) {
			return ocView.pedirDialogo(pedido);
		}
		@Override
		public void updateRegistros(String[][] registros) {
			ocView.updateRegistros(registros);
		}
		@Override
		public void updateMemoria(String[][] memoria) {
			ocView.updateMemoria(memoria);
		}
		@Override
		public void updatePCView(String pc) {
			ocView.updatePCView(pc);
		}
		@Override
		public void updateInstrucionView(String instruccion) {
			ocView.updateInstrucionView(instruccion);			
		}
}
