package questions;

/**
 *Each question, irrespective of type, has the following common aspects:
 * It has the text of the question itself.
 * It allows a way to enter an answer as a String and get the evaluation result of the answer.
 * The string it returns is either "Correct" or "Incorrect".
 * */
public interface Question extends Comparable<Question> {


  String CORRECT = "Correct";
  String INCORRECT = "Incorrect";
  /**
   * Returns question.
   * */
  String getText();

  /**
   * Returns answer is correct or not.
   * */

  String answer(String answer);
}
