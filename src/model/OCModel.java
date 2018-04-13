package model;

public interface OCModel {
	public void setListener(OCModelListener listener);
	public boolean compilaElArchivo(String DireccionInicio);
}
