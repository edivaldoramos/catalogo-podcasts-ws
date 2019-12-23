package br.com.edivaldorsj.utils.exceptions;

public class ParametroInvalidoException extends Exception {

  public ParametroInvalidoException(String message) {
    super(message);
  }

  public ParametroInvalidoException(String message, Throwable cause) {
    super(message, cause);
  }

}
