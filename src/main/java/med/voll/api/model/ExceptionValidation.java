package med.voll.api.model;

public class ExceptionValidation extends RuntimeException{

  public ExceptionValidation(String mensagem){
    super(mensagem);
  }
}
