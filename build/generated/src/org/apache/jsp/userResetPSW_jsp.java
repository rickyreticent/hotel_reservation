package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class userResetPSW_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Change Password</title>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"Styles/main.css\" type=\"text/css\"/>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"Styles/nav.css\" type=\"text/css\"/>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"Styles/loginForm.css\" type=\"text/css\"/>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body style=\"background-image: url(images/natural_paper.png); \">\r\n");
      out.write("        <div id=\"header\">\r\n");
      out.write("            <h1>Change Password</h1>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div id=\"frmGroup\">\r\n");
      out.write("\r\n");
      out.write("            <form action=\"ResetPSW\" method=\"post\">\r\n");
      out.write("                ");

                    String user_name = "";

                    if (session.getAttribute("cID") != null) {
                        Integer cID = (Integer) session.getAttribute("cID");
                        user_name = cID.toString();
                    }
                
      out.write("\r\n");
      out.write("                <div class=\"txt\">\r\n");
      out.write("                    <label>User ID:</label>\r\n");
      out.write("                    <label>");
      out.print(user_name);
      out.write("</label>\r\n");
      out.write("                </div>\r\n");
      out.write("                \r\n");
      out.write("                <div class=\"txt\">\r\n");
      out.write("                    <label> New Password:</label>\r\n");
      out.write("                    <input class=\"txtGroup\" type=\"password\" name=\"password1\">\r\n");
      out.write("                </div>\r\n");
      out.write("                \r\n");
      out.write("                <div class=\"txt\">\r\n");
      out.write("                    <label>Retype New Password: </label>\r\n");
      out.write("                    <input class=\"txtGroup\" type=\"password\" name=\"password2\">\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <input class=\"btn\" type=\"submit\" name=\"submit\" value=\"reset\">\r\n");
      out.write("                <div id=\"message\">\r\n");
      out.write("                    ");
 if (request.getAttribute("error") != null) {
                            out.print(request.getAttribute("error"));
                        }
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("            </form>\r\n");
      out.write("        </div>  \r\n");
      out.write("        <!--Footer-->\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "_footer.jsp", out, false);
      out.write("  \r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}