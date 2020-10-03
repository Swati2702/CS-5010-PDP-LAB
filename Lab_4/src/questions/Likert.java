package questions;

/**
 * Likert: can be answered on a fixed, 5-point Likert scale
 * (Strongly Agree, Agree, Neither Agree nor Disagree, Disagree, Strongly Disagree).
 * */
public class Likert extends AbstractQuestion implements  Comparable<Question> {

  final String question;

  /**
   * Constructor for likert class.
   * */
  public Likert(String question) {
    this.question = question;
  }

  @Override
  public String answer(String answer) {
    if (answer.equals("1") || answer.equals("2")
            || answer.equals("3") || answer.equals("4") || answer.equals("5")) {
      return CORRECT;
    }
    else {
      return INCORRECT;
    }

  }

  @Override
  public int compareTo(Question o) {
    if (o instanceof  Likert) {
      Likert that = (Likert) o;
      return this.question.compareTo(that.question);
    }
    else if (o instanceof  TrueFalse || o instanceof MultipleSelect
            || o instanceof  MultipleChoice) {
      return 1;
    }

    return 0;

  }
}
