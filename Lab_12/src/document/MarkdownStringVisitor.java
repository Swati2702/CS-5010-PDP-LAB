package document;

import document.element.BasicText;
import document.element.BoldText;
import document.element.Heading;
import document.element.HyperText;
import document.element.ItalicText;
import document.element.Paragraph;
import document.element.TextElementVisitor;

public class MarkdownStringVisitor implements TextElementVisitor<String> {
  @Override
  public  String visitBasicText(BasicText current) {
    return current.getText() + "\n";
  }

  @Override
  public String visitBoldText(BoldText current) {
    return "**" + current.getText() + "**\n";
  }

  @Override
  public String visitHeading(Heading current) {
    StringBuilder s = new StringBuilder();
    switch (current.getLevel()) {
      case 1: s.append("# ");
      break;
      case 2: s.append("## ");
      break;
      case 3: s.append("### ");
    }
    return s.append(current.getText()).append("\n").toString();
  }

  @Override
  public String visitHyperText(HyperText current) {
    return "[title](" + current.getText() + ")\n";
  }

  @Override
  public String visitItalicText(ItalicText current) {
    return "*" + current.getText() + "*\n";
  }

  @Override
  public String visitParagraph(Paragraph current) {
    return "> " + current.getText() + "\n";
  }
}
