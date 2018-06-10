package mx.ipn.upiicsa.segsw.labicla.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.ipn.upiicsa.segsw.labicla.dao.ProductDAO;
import mx.ipn.upiicsa.segsw.labicla.dao.UserDAO;
import mx.ipn.upiicsa.segsw.labicla.util.SecurityUtility;
import mx.ipn.upiicsa.segsw.labicla.util.Utility;
import mx.ipn.upiicsa.segsw.labicla.valueobject.ErrorValueObject;
import mx.ipn.upiicsa.segsw.labicla.valueobject.ProductValueObject;
import mx.ipn.upiicsa.segsw.labicla.valueobject.UserValueObject;

/**
 * 
 * @author Guillermo E. Martinez Barriga
 *
 */
@WebServlet("/cambiar_password.controller")
public class CambiarPasswordServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CambiarPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		ErrorValueObject error = null;
		
		String password = request.getParameter("oldpassword");
		String newpassword = request.getParameter("newpassword");
		HttpSession sesionOk = request.getSession();
		UserValueObject email= (UserValueObject) sesionOk.getAttribute("user");
		UserDAO dao = null;
		UserValueObject user = null;
		

		try 
		{
			dao = new UserDAO();
			if(dao.cambiarPassword(email.getEmail(), newpassword)) {
				request.setAttribute("message", "Se cambio la contrase�a");
				RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
				rd.forward(request, response);
				return;		
			}else {
				error = new ErrorValueObject();
				
				error.setMessage("Correo no valido, no se pudo cambiar la contrase�a");
				error.setDescription("No se pudo mandar la contrase�a al correo indicado.");
					
				request.setAttribute("error", error);
					
				RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
				rd.forward(request, response);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
					
			error = new ErrorValueObject();
			
			error.setMessage("Ocurrio un error al buscar productos.");
			error.setDescription(ex.getMessage());
			error.setException(ex);
			
			request.setAttribute("error", error);
			
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
		finally
		{
			if(dao != null) dao.closeConnection();
		}
	}
}