package questions;


/**
 * Abstract Question class.
 * */
public abstract class AbstractQuestion implements Question {


  String question;

  @Override
  public String getText() {
    return question;
  }






}
