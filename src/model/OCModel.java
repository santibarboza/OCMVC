package model;

public interface OCModel {
	public void setListener(OCModelListener listener);
	public boolean compilaElArchivo(String DireccionInicio);
	public void mostrarMensaje(String mensaje);
	public String pedirDialogo(String pedido);
}
