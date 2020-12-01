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
public class HtmlStringVisitor implements TextElementVisitor<String> {

  @Override
  public  String visitBasicText(BasicText current) {
    return  current.getText().trim() + "\n";
  }

  @Override
  public String visitBoldText(BoldText current) {
    return "<b>" +  current.getText().trim() + "</b>\n";
  }

  @Override
  public String visitHeading(Heading current) {
    int level = current.getLevel();
    return "<h" + level + ">" + current.getText().trim() + "</h" + level + ">\n";
  }

  @Override
  public String visitHyperText(HyperText current) {
    return "<a href=\"" + current.getUrl().trim() + "\">" + current.getText().trim() + "</a>\n";
  }

  @Override
  public String visitItalicText(ItalicText current) {
    return "<i>" + current.getText().trim() + "</i>\n";
  }

  @Override
  public String visitParagraph(Paragraph current) {
    StringBuilder s = new StringBuilder();
    s.append("<p>");
    List<BasicText> list = current.getContent();
    for (BasicText b : list ) {
      s.append(b.accept(this));
    }
    s.append("</p>\n");
    return s.toString();
  }
}
