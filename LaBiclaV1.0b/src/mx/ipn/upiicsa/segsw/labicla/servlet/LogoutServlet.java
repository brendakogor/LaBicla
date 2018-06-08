package mx.ipn.upiicsa.segsw.labicla.servlet;

import java.io.IOException;

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
@WebServlet("/logout.controller")
public class LogoutServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.getSession().removeAttribute("user");
		
		RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
		rd.forward(request, response);
		return;	
	}

}
