package mx.ipn.upiicsa.segsw.labicla.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.ipn.upiicsa.segsw.labicla.dao.BlogEntryDAO;
import mx.ipn.upiicsa.segsw.labicla.util.Utility;
import mx.ipn.upiicsa.segsw.labicla.valueobject.BlogEntryValueObject;
import mx.ipn.upiicsa.segsw.labicla.valueobject.UserValueObject;


/**
 * 
 * @author Guillermo E. Martinez Barriga
 *
 */
@WebServlet("/register_blog_entry.controller")

public class RegisterBlogEntryServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterBlogEntryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		BlogEntryDAO dao = null;
		BlogEntryValueObject blogEntryValueObject = null;
		UserValueObject user = (UserValueObject) request.getSession().getAttribute("user");
		
		if( user  == null)
		{
			request.setAttribute("message", "Debe firmarse al sistema para registrar entradas en el blog.");
			RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
			rd.forward(request, response);
			return;
		}
		
		String blogEntryValue = request.getParameter("blog-entry-value");
		
		if(Utility.containsAnEmptyValue(blogEntryValue))
		{
			request.setAttribute("message", "Falt&oacute; capturar algun campo obligatorio.");
			
			RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
			rd.forward(request, response);
			return;
		}
		
		try 
		{
			dao = new BlogEntryDAO();
			
			blogEntryValueObject = new BlogEntryValueObject();
			
			blogEntryValueObject.setValue(blogEntryValue);
			blogEntryValueObject.setUserEmail(user.getEmail());
			
			dao.create(blogEntryValueObject);
			
			RequestDispatcher rd = request.getRequestDispatcher("get_blog_info.controller");
			rd.forward(request, response);
			return;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return;
		}
		finally
		{
			if(dao != null) dao.closeConnection();
		}
	}
}



