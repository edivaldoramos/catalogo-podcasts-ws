package br.com.edivaldorsj.utils;

import br.com.edivaldorsj.utils.exceptions.IdInvalidoException;
import br.com.edivaldorsj.utils.exceptions.RecursoNaoEncontradoException;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class RestExceptionHandler extends ResponseEntityExceptionHandler {

  private static String tagError = "error";

  @ExceptionHandler(IdInvalidoException.class)
  public ResponseEntity<Object> idInvalidoException(IdInvalidoException e, HttpServletRequest request){
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).header(tagError, e.getMessage()).build();
  }

  @ExceptionHandler(RecursoNaoEncontradoException.class)
  public ResponseEntity<Object> recursoNaoEncontradoException(RecursoNaoEncontradoException e, HttpServletRequest request){
    return ResponseEntity.status(HttpStatus.NOT_FOUND).header(tagError, e.getMessage()).build();
  }

  @ExceptionHandler(ValidationException.class)
  public ResponseEntity<Object> trowable(Throwable e, HttpServletRequest request) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).header(tagError, e.getMessage()).build();
  }

}
