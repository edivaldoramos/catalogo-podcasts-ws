package br.com.edivaldorsj.utils;

import br.com.edivaldorsj.utils.exceptions.ParametroInvalidoException;
import br.com.edivaldorsj.utils.exceptions.RecursoNaoEncontradoException;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

  private static String tagError  = "error";
  private static String msgPadrao = "Não foi possível efetuar a consulta. Motivo: ";

  @ExceptionHandler(ParametroInvalidoException.class)
  public ResponseEntity<Object> parametroInvalidoException(ParametroInvalidoException e, HttpServletRequest request) {
    exibirMensagemErro(e.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).header(tagError,
        msgPadrao + e.getMessage()).build();
  }

  private void exibirMensagemErro(String mensagem) {
    if (logger.isErrorEnabled()) {
      logger.error(msgPadrao + mensagem);
    }
  }

  @ExceptionHandler(RecursoNaoEncontradoException.class)
  public ResponseEntity<Object> recursoNaoEncontradoException(RecursoNaoEncontradoException e, HttpServletRequest request) {
    exibirMensagemErro(e.getMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).header(tagError, e.getMessage()).build();
  }

  @ExceptionHandler(ValidationException.class)
  public ResponseEntity<Object> trowable(Throwable e, HttpServletRequest request) {
    exibirMensagemErro(e.getMessage());
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).header(tagError,
        msgPadrao + e.getMessage()).build();
  }

}
