package document;

import document.element.BasicText;
import document.element.BoldText;
import document.element.Heading;
import document.element.HyperText;
import document.element.ItalicText;
import document.element.Paragraph;
import document.element.TextElementVisitor;

public class HtmlStringVisitor implements TextElementVisitor<String> {

  @Override
  public  String visitBasicText(BasicText current) {
    return  current.getText();
  }

  @Override
  public String visitBoldText(BoldText current) {
    return "<b>" +  current.getText() + "</b>\n";
  }

  @Override
  public String visitHeading(Heading current) {
    int level = current.getLevel();
    return String.format("<h%d>", level) + current.getText() + String.format("</h%d>", level)
            + "\n";
  }

  @Override
  public String visitHyperText(HyperText current) {
    return "<a href=\"" + current.getUrl() + "\">" + current.getText() + "</a>\n";
  }

  @Override
  public String visitItalicText(ItalicText current) {
    return "<i>" + current.getText() + "</i>\n";
  }

  @Override
  public String visitParagraph(Paragraph current) {
    return "<p>" +  current.getText() + "</p>\n";
  }
}
