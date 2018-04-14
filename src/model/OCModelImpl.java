package model;

import model.Analizadores.AnalizadorLexico;
import model.Analizadores.AnalizadorSintacticoySemantico;

public class OCModelImpl implements OCModel {
	private OCModelListener listener;
	private AnalizadorLexico analizadorLexico;
	private AnalizadorSintacticoySemantico analizadorSintactico;
		
	  public OCModelImpl(AnalizadorLexico analizadorLexico,AnalizadorSintacticoySemantico analizadorSintactico) {
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
		return false;
	}
}
