package br.com.edivaldoramos.utils;

import br.com.edivaldoramos.utils.exceptions.ParametroInvalidoException;
import br.com.edivaldoramos.utils.exceptions.RecursoNaoEncontradoException;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(ParametroInvalidoException.class)
  public ResponseEntity<Object> parametroInvalidoException(ParametroInvalidoException e, HttpServletRequest request) {
    return construirResponseEntity(HttpStatus.BAD_REQUEST, e.getMessage());
  }

  private ResponseEntity<Object> construirResponseEntity(HttpStatus httpStatus, String msgErro) {
    String tagError = "error";
    String msgPadrao = "Não foi possível efetuar a consulta. Motivo: ";

    if (logger.isErrorEnabled()) {
      logger.error(msgPadrao + msgErro);
    }
    return ResponseEntity.status(httpStatus).header(tagError, msgPadrao + msgErro).build();
  }

  @ExceptionHandler(RecursoNaoEncontradoException.class)
  public ResponseEntity<Object> recursoNaoEncontradoException(RecursoNaoEncontradoException e, HttpServletRequest request) {
    return construirResponseEntity(HttpStatus.NOT_FOUND, e.getMessage());
  }

  @ExceptionHandler(ValidationException.class)
  public ResponseEntity<Object> validationException(Throwable e, HttpServletRequest request) {
    return construirResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
  }

}
