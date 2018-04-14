package model.Ejecucion;

import model.OCModel;
import Excepciones.ErrorEjecucion;

public interface Ejecucion {
	public void Ejecutar() throws ErrorEjecucion;
	public boolean ejecutarPaP() throws ErrorEjecucion;
	public boolean pasoAdelante() throws ErrorEjecucion;
	public void setModel(OCModel ocModel);
}
