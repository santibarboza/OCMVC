package model;

import model.Analizadores.AnalizadorLexico;
import model.Analizadores.AnalizadorSintactico;

public class OCModelImpl implements OCModel {
	private OCModelListener listener;
	private AnalizadorLexico analizadorLexico;
	private AnalizadorSintactico analizadorSintactico;
		
	  public OCModelImpl(AnalizadorLexico analizadorLexico,AnalizadorSintactico analizadorSintactico) {
		  this.analizadorLexico=analizadorLexico;
		  this.analizadorSintactico= analizadorSintactico;
	  }
	
	  public void setListener(OCModelListener listener) {
	    this.listener = listener;
	  }
	
	 private void notifyListener() {
	    if (listener != null) {
	      listener.didUpdateModel();
	    }
	}

	@Override
	public boolean compilaElArchivo(String DireccionInicio) {
		// TODO Auto-generated method stub
		return false;
	}
}
