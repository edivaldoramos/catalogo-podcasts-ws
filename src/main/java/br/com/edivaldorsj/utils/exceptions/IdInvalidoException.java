package br.com.edivaldorsj.utils.exceptions;

public class IdInvalidoException extends Exception {

  public IdInvalidoException(String message) {
    super(message);
  }

  public IdInvalidoException(String message, Throwable cause) {
    super(message, cause);
  }

}
