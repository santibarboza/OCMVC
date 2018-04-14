package model.RepresentacionMemoria;

import Excepciones.ErrorEjecucion;

public class MemoriaImpl implements Memoria{
	protected int memoria[];
	protected int registro[];
	protected int direccionInicio;
	protected int direccionActual;

	public MemoriaImpl(int direccionInicio){
		iniciar(direccionInicio);
	}
	@Override
	public void iniciar(int direccionInicio) {
		this.direccionInicio=direccionInicio;
		this.direccionActual=direccionInicio;
		memoria= new int[256];
		registro= new int[16];
		resetearRegistros();
	}
	@Override
	public void escribirSiguienteByte(int valor) throws ErrorEjecucion {
		if(direccionActual>255)
			throw new ErrorEjecucion("Codigo alocado fuera de la memoria");
		direccionActual=direccionActual & 255;
		memoria[direccionActual]=valor;
		direccionActual++;
	}
	@Override
	public int leerMemoria(int direccion) {
		return memoria[direccion];
	}
	@Override
	public void escribirMemoria(int direccion, int valor) {
		memoria[direccion]=valor;
	}
	@Override
	public int leerRegistro(int numero) {
		return registro[numero];
	}
	@Override
	public void escribirRegistro(int numero, int valor) {
		registro[numero]=valor;
	}
	@Override
	public void resetearRegistros() {
		registro= new int[16];
		for(int i=0;i<16;i++)
			registro[i]=0;
	}
	@Override
	public void resetearDireccionActual() {
		direccionActual=direccionInicio;		
	}
	@Override
	public int getDireccionInicio() {
		return direccionInicio;
	}
	@Override
	public int getDireccionActual() {
		return direccionActual;
	}
}
