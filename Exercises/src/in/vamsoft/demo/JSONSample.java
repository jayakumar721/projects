package in.vamsoft.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Servlet implementation class JSONSample
 */
@WebServlet("/JSONSample")
public class JSONSample extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  System.out.println("in servlet");
	  JSONObject jobj=null ;
	   try {
	      jobj = new JSONObject();
	      jobj.put("id", 1);
	      jobj.put("name", "jk");
	      System.out.println(jobj);
	     
	    } catch (JSONException e) {
	      e.printStackTrace();
	    }
	   response.getWriter().write(jobj.toString());
	}

}
