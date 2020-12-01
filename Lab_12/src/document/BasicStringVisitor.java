package document;

import java.util.List;

import document.element.BasicText;
import document.element.BoldText;
import document.element.Heading;
import document.element.HyperText;
import document.element.ItalicText;
import document.element.Paragraph;
import document.element.TextElementVisitor;

/**
 * Hello.
 * */
public class BasicStringVisitor implements TextElementVisitor<String> {
  @Override
  public  String visitBasicText(BasicText current) {
    return current.getText().trim() + " ";
  }

  @Override
  public String visitBoldText(BoldText current) {
    return current.getText().trim() + " ";
  }

  @Override
  public String visitHeading(Heading current) {
    return current.getText().trim() + " ";
  }

  @Override
  public String visitHyperText(HyperText current) {
    return current.getText().trim() + " ";
  }

  @Override
  public String visitItalicText(ItalicText current) {
    return current.getText().trim() + " ";
  }

  @Override
  public String visitParagraph(Paragraph current) {

    StringBuilder s = new StringBuilder();

    List<BasicText> list = current.getContent();
    for (BasicText b : list ) {
      s.append(b.accept(this));
    }
    s.append(" ");
    return s.toString();
  }
}
