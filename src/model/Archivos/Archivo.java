package model.Archivos;

public interface Archivo {
	public String readLine()throws Excepciones.ErrorOCUNS; 
	public void Close();
}
