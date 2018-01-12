package in.vamsoft.assign5;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

@SuppressWarnings("serial")
public class CustomTag extends TagSupport {

  private int num1;
  private int num2;
  int total;

  public int getNum1() {
    return num1;
  }

  public void setNum1(int num1) {
    this.num1 = num1;
  }

  public int getNum2() {
    return num2;
  }

  public void setNum2(int num2) {
    this.num2 = num2;
  }

  public int doStartTag() throws JspException {

      return EVAL_BODY_INCLUDE;
  }
  public int doAfterBody() {
    try {
      JspWriter out = pageContext.getOut();

      this.setNum1(num1);
      this.setNum2(num2);
      out.print(addNumber(this.getNum1(), this.getNum2()));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return 0;

  }

  public int doEndTag() throws JspException {
    return EVAL_BODY_AGAIN;
  }

  public int addNumber(int num1, int num2) {
    total = num1 + num2;
    return total;
  }

}
