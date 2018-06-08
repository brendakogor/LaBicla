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
@WebServlet("/delete_blog_entry.controller")
public class DeleteBlogEntryServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBlogEntryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String referer = request.getHeader("referer");
		
		System.out.println("{referer: " + referer  +"}");
		
		if(referer == null || referer.indexOf("http://localhost:8080/LaBicla/") == -1)
		{
			request.setAttribute("message", "Operacion invalida.");
			RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
			rd.forward(request, response);
			return;
		}

		BlogEntryDAO dao = null;
		BlogEntryValueObject blogEntryValueObject = null;
		UserValueObject user = (UserValueObject) request.getSession().getAttribute("user");
		
		if( user  == null)
		{
			request.setAttribute("message", "Debe firmarse al sistema para borrar entradas en el blog.");
			RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
			rd.forward(request, response);
			return;
		}
		
		String strId = request.getParameter("id");
		
		if(Utility.containsAnEmptyValue(strId))
		{
			request.setAttribute("message", "Falt&oacute; capturar algun campo obligatorio.");
			
			RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
			rd.forward(request, response);
			return;
		}
		
		try 
		{
			int id = Integer.parseInt(strId);
			
			dao = new BlogEntryDAO();
			
			blogEntryValueObject = dao.findById(id);
			
			if(blogEntryValueObject != null && (blogEntryValueObject.getUserEmail().equals(user.getEmail()) || user.getEmail().equals("admin@novalidserver.net")))
			{
				dao.delete(id);
			}
			else
			{
				System.out.println("[La Bicla] Se intent&oacute; borrar el registro {" + id + "} por el usuario {" + user.getEmail() + "}");
				request.setAttribute("message", "La entrada al blog no puede ser borrada: No existe el id o usted no tiene permisos.");
			}
			
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
