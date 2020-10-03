package questions;

/**
 * True/False: can be answered in one of two ways: true or false.
 * This type of question can be created by passing the text of the question and the correct answer.
 * */
public class TrueFalse extends  AbstractQuestion implements Comparable<Question> {

  final String correct;

  /**
   * Constructor for TrueFalse class.
   * */
  public TrueFalse(String question, String correct)
          throws IllegalArgumentException {
    this.question = question;
    this.correct = correct;

  }

  @Override
  public String answer(String answer) {
    //    if (!(answer.equals("True") || answer.equals("False"))) {
    //      throw new IllegalArgumentException("Invalid answer.");
    //    }
    if (answer.equals(correct)) {
      return CORRECT;
    }
    else {
      return INCORRECT;
    }
  }

  @Override
  public int compareTo(Question o) {
    if (o instanceof  TrueFalse) {
      TrueFalse that = (TrueFalse) o;
      return this.question.compareTo(that.question);
    }
    else {
      return -1;
    }
  }
}
