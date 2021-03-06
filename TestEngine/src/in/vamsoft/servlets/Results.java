package in.vamsoft.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.vamsoft.dao.QuestionsDAOImpl;
import in.vamsoft.model.Question;

/**
 * Servlet implementation class Results
 */
@WebServlet("/Results")
public class Results extends HttpServlet {
  private static final long serialVersionUID = 1L;
  HttpSession session;
  QuestionsDAOImpl dao = new QuestionsDAOImpl();

  @SuppressWarnings({ "unused", "unchecked" })
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    session = request.getSession();
    List<Question> questionList = (List<Question>) session.getAttribute("Questions");
    int marks = 0;
    boolean result;
    if (questionList.size() > 0) {
      for (Question question : questionList) {
        String ans = request.getParameter(String.valueOf(question.getqNo()));
        String ques = question.getQuestion();
        if (ans != null) {
          result = dao.getAnswers(ques, ans);
          if (result) {
            marks++;
          }
        }
      }
      session.setAttribute("marks", marks);
      RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
      dispatcher.forward(request, response);
    }
  }
}
