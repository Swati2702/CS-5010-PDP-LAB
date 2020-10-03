import org.junit.Test;

import static org.junit.Assert.assertEquals;

import questions.MultipleChoice;
import questions.MultipleSelect;
import questions.Question;
import questions.TrueFalse;

/**
 * Tests for question.
 * */
public class QuestionnaireTest {

  private static Question question;

  @Test
  public void testTrueFalseText() {
    question = new TrueFalse("Apples are better than bananas", "True");
    assertEquals("Apples are better than bananas", question.getText());

  }

  @Test
  public void multipleChoiceText() {
    question = new MultipleChoice("what is your name?",
            "Swati", "A",
            "B", "Swati", "D");
    assertEquals("what is your name?", question.getText());

  }


  @Test
  public void testSorting() {

    Question question1 = new MultipleChoice("what is your name?",
            "Swati", "A",
            "B", "Swati", "D");

    Question question2 = new TrueFalse("Is it hot?", "True");

    Question question3 = new MultipleSelect("How do you do ?", "Good",
            "Best", "Better", "Best", "Good");

    Question question4 = new TrueFalse("Apples are better than bananas", "True");
    Question[] questionnaire = {question1, question2, question3, question4};
    //System.out.println(questionnaire);
    //System.out.println(questionnaire);
    assertEquals("aaa", questionnaire.toString());


  }

}

