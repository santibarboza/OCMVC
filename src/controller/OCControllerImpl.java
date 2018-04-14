package controller;

import view.OCView;
import model.OCModel;

public class OCControllerImpl implements OCController {

		  private OCModel ocModel;
		  private OCView ocView;

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
			
		}

		@Override
		public void onEventCompilar(String direccionInicio) {
			if(ocModel.compilaElArchivo(direccionInicio))
				ocView.habilitarOpcionesdeEjecucion();
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
