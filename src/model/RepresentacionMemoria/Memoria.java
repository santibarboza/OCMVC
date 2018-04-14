package model.RepresentacionMemoria;

import Excepciones.ErrorEjecucion;

public interface Memoria {
	public void escribirSiguienteByte(int valor) throws ErrorEjecucion;
	public int leerMemoria(int direccion);
	public void escribirMemoria(int direccion, int valor);
	public int leerRegistro(int numero);
	public void escribirRegistro(int numero, int valor);
	public void resetearRegistros();
	public void resetearDireccionActual();
	public int getDireccionInicio();
	public int getDireccionActual();
	public void iniciar(int direccionInicio);
}
