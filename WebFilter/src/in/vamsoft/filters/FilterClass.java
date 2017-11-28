package in.vamsoft.filters;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class FilterClass
 */
@WebFilter(dispatcherTypes = { DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE }, urlPatterns = {
    "/FilterClass", "/Servlet1" }, servletNames = { "Servlet1" })
public class FilterClass implements Filter {

  /**
   * Default constructor.
   */
  public FilterClass() {
    // TODO Auto-generated constructor stub
  }

  /**
   * @see Filter#destroy()
   */
  public void destroy() {
    // TODO Auto-generated method stub
  }

  /**
   * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
   */
  HttpSession session;

  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    session = ((HttpServletRequest) request).getSession();
    Object name = session.getAttribute("name");
    if (name != null) {
      System.out.println("FilterClass.doFilter()");
      chain.doFilter(request, response);
    } else {
      RequestDispatcher dispatcher = request.getRequestDispatcher("Login.html");
      dispatcher.forward(request, response);

    }
    session.invalidate();
  }

  /**
   * @see Filter#init(FilterConfig)
   */
  public void init(FilterConfig fConfig) throws ServletException {
    // TODO Auto-generated method stub
  }

}
