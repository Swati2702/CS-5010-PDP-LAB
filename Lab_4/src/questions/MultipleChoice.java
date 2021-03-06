package questions;


/**
 * Multiple choice: offers several options, only one of which is correct. This type of
 * question can be created by passing the text of the question, the correct answer and the options.
 * */

public class MultipleChoice extends AbstractQuestion implements Comparable<Question> {

  final String correct;
  final String[] options;

  /**
   * Constructor for MultipleChoice class.
   * */
  public MultipleChoice(String question, String correct, String...options )
          throws IllegalArgumentException {
    if (options.length < 3 || options.length > 8) {
      throw new IllegalArgumentException("Number of options not correct. ");
    }

    this.question = question;
    this.correct = correct;
    this.options = options;
  }

  @Override
  public String answer(String answer) {
    if (answer.equals(correct)) {
      return CORRECT;
    }
    else {
      return INCORRECT;
    }
  }


  @Override
  public int compareTo(Question o) {
    if (o instanceof  MultipleChoice) {
      MultipleChoice that = (MultipleChoice) o;
      return this.question.compareTo(that.question);
    }
    else if (o instanceof  TrueFalse) {
      return 1;
    }

    else if (o instanceof  MultipleSelect || o instanceof Likert) {
      return -1;
    }

    return 0;

  }

}
