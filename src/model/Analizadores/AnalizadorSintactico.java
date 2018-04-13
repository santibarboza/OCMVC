package model.Analizadores;

import model.RepresentacionMemoria.Memoria;
import model.RepresentacionMemoria.TabladeEtiquetas;
import Excepciones.ErrorOCUNS;

public interface AnalizadorSintactico {
	public void inicial()throws ErrorOCUNS;
	public Memoria getMemoria();
	public TabladeEtiquetas getTablaEtiqueta();
}
