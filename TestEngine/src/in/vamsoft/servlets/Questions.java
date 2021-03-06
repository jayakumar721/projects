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

import in.vamsoft.dao.QuestionsDAO;
import in.vamsoft.dao.QuestionsDAOImpl;
import in.vamsoft.model.Question;
/**
 * Servlet implementation class Questions
 */
@WebServlet("/Questions")
public class Questions extends HttpServlet {
	private static final long serialVersionUID = 1L;
	QuestionsDAO dao=new QuestionsDAOImpl();
	HttpSession session;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
	  List<Question> questions = dao.getQuestions();
	  session = request.getSession();
	  session.setAttribute("Questions", questions);
	  RequestDispatcher dispatcher = request.getRequestDispatcher("taketest.jsp");
	  dispatcher.forward(request, response);
	  
	}

}
