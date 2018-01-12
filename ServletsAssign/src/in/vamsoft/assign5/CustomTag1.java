package in.vamsoft.assign5;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

@SuppressWarnings("serial")
public class CustomTag1 extends TagSupport {

  private int num1;
  private int num2;
  int total;

  public int getNum1() {
    return num1;
  }

  public void setNum1(int num1) {
    this.num1 = num1;
  }

  
  public int doStartTag() throws JspException {

      return EVAL_BODY_INCLUDE;
  }
  public int doAfterBody() {
    try {
      JspWriter out = pageContext.getOut();
      this.setNum1(num1);
      out.print(cubeNumber(this.getNum1()));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return 0;

  }

  public int doEndTag() throws JspException {
    return EVAL_BODY_AGAIN;
  }

  public int cubeNumber(int num1) {
    total = num1 *num1*num1;
    return total;
  }

}
