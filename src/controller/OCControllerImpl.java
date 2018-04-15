package controller;

import Excepciones.ErrorOCUNS;
import view.OCView;
import model.OCModel;
import model.Archivos.Archivo;
import model.Archivos.ArchivoAbstractFactory;

public class OCControllerImpl implements OCController {

		  private OCModel ocModel;
		  private OCView ocView;
		  private Archivo archivoActual;

		  OCControllerImpl(OCModel ocModel) {
		    this.ocModel = ocModel;
		  }

		  public void onEventUpdate(String name, String lastName) {

			 /*
			ocView.updateProgress(0);

		    new Thread(new Runnable() {
		      @Override public void run() {
		        for (int i = 0; i<=100; i++) {
		          try {
		            Thread.sleep(25);
		          } catch (InterruptedException e) {
		            e.printStackTrace();
		          }
		          ocView.updateProgress(i);
		        }
		        ocModel.updateUser(name, lastName);
		      }
		    }).start();
			*/
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
				ocView.mostrarMensajeError(error.getMessage());
			}
		}

		private void updateContenidoArchivoActual(String fileName) {
			try{
				ocView.updateContenidoArchivoActual(ocModel.getCreadorArchivo().cat(fileName));
			}catch(ErrorOCUNS error){
				ocView.mostrarMensajeError(error.getMessage());
			}
		}

		@Override
		public void onEventCompilar(String direccionInicio) {
			updateArchivoActual();
			if(ocModel.compilaElArchivo(archivoActual, direccionInicio)){
				ocView.habilitarOpcionesdeEjecucion();
				ocView.updateCodigoCompilado(ocModel.obtenerCodigoCompilado());
				ocView.mostrarMensajeError("El Archivo se compilo correctamente");
			}
		}

		@Override
		public void onEventEjecutar() {
			
		}

		@Override
		public void onEventVerMemoria() {
			
		}

		@Override
		public void onEventSiguientePaso() {
			
		}

		@Override
		public void onEventVerAyuda() {
			
		}

		@Override
		public String pedirDialogo(String pedido) {
			return ocView.pedirDialogo(pedido);
		}
		
}
