
package mx.ipn.upiicsa.segsw.labicla.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author Guillermo E. Martinez Barriga
 *
 */
@WebServlet("/log_request_info.controller")
public class LogRequestInfoServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogRequestInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		showRequestData(request);
	}
	
	private static void showRequestData(HttpServletRequest request)
	{
		System.out.println(" === REQUEST: URI : " + request.getRequestURI());
		System.out.println(" === REQUEST: URL : " + request.getRequestURL().toString());
		System.out.println(" === REQUEST: referer : " + request.getHeader("referer"));
		
		Enumeration<String> headerNames = request.getHeaderNames();
		String name = null; 
		
		
		System.out.println(" === REQUEST: Headers");
		
		while(headerNames.hasMoreElements()) 
		{
			name = headerNames.nextElement();
			System.out.println(" === REQUEST: Header : {" + name + ", " + request.getHeader(name) + "}");
		}
	}
}



