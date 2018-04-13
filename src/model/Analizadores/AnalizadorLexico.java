package model.Analizadores;

import Excepciones.ErrorOCUNS;
import model.Tokens.Token;

public interface AnalizadorLexico {
	public Token getToken()throws ErrorOCUNS;
}
