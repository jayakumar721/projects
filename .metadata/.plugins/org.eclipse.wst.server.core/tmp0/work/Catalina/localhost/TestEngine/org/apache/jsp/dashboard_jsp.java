/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.5
 * Generated at: 2017-11-28 11:36:38 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class dashboard_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/header.jsp", Long.valueOf(1511868618000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<title>dashboard</title>\n");
      out.write("<link rel=\"stylesheet\"\n");
      out.write("\thref=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n");
      out.write("\n");
      out.write("<!-- jQuery library -->\n");
      out.write("<script\n");
      out.write("\tsrc=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("<script src=\"vendor/jquery-validation/dist/jquery.validate.min.js\"></script>\n");
      out.write("\n");
      out.write("<!-- Latest compiled JavaScript -->\n");
      out.write("<script\n");
      out.write("\tsrc=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
      out.write("<style type=\"text/css\">\n");
      out.write(".navbar-inverse {\n");
      out.write("\tbackground: #00796B;\n");
      out.write("\tborder-bottom-color: #004D40;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".navbar-inverse .navbar-nav>li>a, .navbar-inverse .navbar-brand,\n");
      out.write("\t.navbar-inverse .navbar-nav>.dropdown>a .caret {\n");
      out.write("\tcolor: #fff;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".navbar-inverse .navbar-nav>.open>a, .navbar-inverse .navbar-nav>.open>a:hover,\n");
      out.write("\t.navbar-inverse .navbar-nav>.open>a:focus, .navbar-nav>li>.dropdown-menu\n");
      out.write("\t{\n");
      out.write("\tbackground: #4DB6AC;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".nav-pills\n");
      out.write(">\n");
      out.write("li\n");
      out.write(">\n");
      out.write("a\n");
      out.write(",\n");
      out.write("{\n");
      out.write("color\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write(":\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write(" \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("#303F9F\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write(";\n");
      out.write("}\n");
      out.write(".nav>li>a:hover, .nav>li>a:focus {\n");
      out.write("\tbackground-color: #EEEEEE;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".right {\n");
      out.write("\theight: 500px;\n");
      out.write("\tborder: 1px solid #EEEEEE;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<div>\n");
      out.write("\t\t");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<title>Insert title here</title>\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\"\n");
      out.write("\thref=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n");
      out.write("\n");
      out.write("<!-- jQuery library -->\n");
      out.write("<script\n");
      out.write("\tsrc=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("<script src=\"vendor/jquery-validation/dist/jquery.validate.min.js\"></script>\n");
      out.write("\n");
      out.write("<!-- Latest compiled JavaScript -->\n");
      out.write("<script\n");
      out.write("\tsrc=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
      out.write("<style type=\"text/css\">\n");
      out.write(".navbar-inverse {\n");
      out.write("\tbackground: #00796B;\n");
      out.write("\tborder-bottom-color: #004D40;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".navbar-inverse .navbar-nav>li>a, .navbar-inverse .navbar-brand,\n");
      out.write("\t.navbar-inverse .navbar-nav>.dropdown>a .caret {\n");
      out.write("\tcolor: #fff;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".navbar-inverse .navbar-nav>.open>a, .navbar-inverse .navbar-nav>.open>a:hover,\n");
      out.write("\t.navbar-inverse .navbar-nav>.open>a:focus, .navbar-nav>li>.dropdown-menu\n");
      out.write("\t{\n");
      out.write("\tbackground: #4DB6AC;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".nav-pills\n");
      out.write(">\n");
      out.write("li\n");
      out.write(">\n");
      out.write("a\n");
      out.write(",\n");
      out.write("{\n");
      out.write("color\n");
      out.write(":\n");
      out.write(" \n");
      out.write("#303F9F\n");
      out.write(";\n");
      out.write("\n");
      out.write("\n");
      out.write("}\n");
      out.write(".nav>li>a:hover, .nav>li>a:focus {\n");
      out.write("\tbackground-color: #EEEEEE;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<div id=\"top-nav\" class=\"navbar navbar-inverse navbar-static-top\">\n");
      out.write("\t\t<div class=\"container-fluid\">\n");
      out.write("\t\t\t<div class=\"navbar-header\">\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\"\n");
      out.write("\t\t\t\t\tdata-target=\".navbar-collapse\">\n");
      out.write("\t\t\t\t\t<span class=\"icon-bar\"></span> <span class=\"icon-bar\"></span> <span\n");
      out.write("\t\t\t\t\t\tclass=\"icon-bar\"></span>\n");
      out.write("\t\t\t\t</button>\n");
      out.write("\t\t\t\t<a class=\"navbar-brand\" href=\"dashboard.jsp\">CompanyName</a>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"navbar-collapse collapse\">\n");
      out.write("\t\t\t\t<ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("\t\t\t\t\t<li><i class=\"fa fa-user-circle\"></i><a>");
      out.print(session.getAttribute("name"));
      out.write("</a>\n");
      out.write("\n");
      out.write("\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t\t<li><a href=\"Login.html\"><i class=\"fa fa-sign-out\"></i>\n");
      out.write("\t\t\t\t\t\t\tLogout</a></li>\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<!-- /container -->\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
      out.write("\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"col-sm-2\"></div>\n");
      out.write("\t<div class=\"right col-sm-8\">\n");
      out.write("\t\t<div style=\"width: 100%; height: 20px; color: blue; margin-top: 10px\">\n");
      out.write("\t\t\tWelcome,\n");
      out.write("\t\t\t");
      out.print(session.getAttribute("name"));
      out.write("</div>\n");
      out.write("\t\t\t<div class=\"col-sm-2\"></div>\n");
      out.write("\t\t<div class=\"col-sm-6\" style=\"font-family:timesnewroman;font-size:20px;font-style:italic;width: 100%; height: 300px; color: red; margin-top: 50px\">\n");
      out.write("\t\t\t<ol type=\"1\">\n");
      out.write("\t\t\t\t<li>ihh</li>\n");
      out.write("\t\t\t\t<li>dsff</li>\n");
      out.write("\t\t\t\t<li>hai</li>\n");
      out.write("\t\t\t\t<li>dsff</li>\n");
      out.write("\t\t\t\t<li>hai</li>\n");
      out.write("\t\t\t\t<li>dsff</li>\n");
      out.write("\t\t\t\t<li>hai</li>\n");
      out.write("\t\t\t\t<li>dsff</li>\n");
      out.write("\t\t\t\t<li>hai</li>\n");
      out.write("\t\t\t\t<li>dsff</li>\n");
      out.write("\t\t\t</ol>\n");
      out.write("\t\t\t<div style=\"float:right;color:green;\">\n");
      out.write("\t\t\t\tAll the best,<a href=\"Questions\" id=\"taketest\">Take Test</a>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
