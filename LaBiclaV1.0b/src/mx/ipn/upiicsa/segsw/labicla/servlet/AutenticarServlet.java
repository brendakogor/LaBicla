package mx.ipn.upiicsa.segsw.labicla.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.ipn.upiicsa.segsw.labicla.dao.UserDAO;
import mx.ipn.upiicsa.segsw.labicla.util.Utility;
import mx.ipn.upiicsa.segsw.labicla.valueobject.ErrorValueObject;
import mx.ipn.upiicsa.segsw.labicla.valueobject.StringValueObject;
import mx.ipn.upiicsa.segsw.labicla.valueobject.UserValueObject;

/**
 * 
 * @author Guillermo E. Martinez Barriga
 *
 */
@WebServlet("/autenticar.controller")
public class AutenticarServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutenticarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("AutenticarServlet.doGet()");
		
		ErrorValueObject error = null;
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if(Utility.containsAnEmptyValue(email, password))
		{
			
			error = new ErrorValueObject();
			
			error.setMessage("Parametro faltante");
			error.setDescription("Falt&oacute; capturar algun campo obligatorio.");
			
			request.setAttribute("error", error);
			
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);

			return;
		}
		
		StringValueObject validateTheEmail = new StringValueObject(email);
		StringValueObject validateThePassword = new StringValueObject(password);
		if(validateTheEmail.getStatus() && validateThePassword.getStatus()) {
		
		
		UserDAO dao = null;
		UserValueObject user = null;
		
		try 
		{
			dao = new UserDAO();
			user = dao.authenticate(email, password);
			
			if(user != null) // Credenciales validas
			{
				Date currentDate = new Date();
				
				long passwordAgeInMilis =  currentDate.getTime() - user.getDateOfLastPasswordUpdate().getTime();  // In Miliseconds
				
				int remainingDaysOfPasswordValidity = (int) (user.getDaysOfPasswordValidity() -  passwordAgeInMilis/1000/60/60/24);
				
//				System.out.println("{ currentDate: " + (currentDate) + "}");
//				System.out.println("{ currentDate (milis): " + (currentDate.getTime()) + "}");
//				System.out.println("{ dateOfLastPasswordUpdate: " + (user.getDateOfLastPasswordUpdate()) + "}");
//				System.out.println("{ dateOfLastPasswordUpdate (milis): " + (user.getDateOfLastPasswordUpdate().getTime()) + "}");
//				
//				System.out.println("{ currentDate: " + (currentDate) + "}");
//				System.out.println("{ passwordAge (milis): " + (passwordAgeInMilis) + "}");
//				System.out.println("{ passwordAge (milis): " + (passwordAgeInMilis) + "}");
//				System.out.println("{ passwordAge (days): " + (float) (passwordAgeInMilis/1000.0/60.0/60.0/24.0) + "}");
//				System.out.println("{ DaysOfPasswordValidity (days): " + (user.getDaysOfPasswordValidity()) + "}");
				
				System.out.println("{ dias restantes: " + (user.getDaysOfPasswordValidity() - passwordAgeInMilis/1000/60/60/24) + "}");
				
				if(user.getStatus().equals(UserValueObject.STATUS.ACTIVE))
				{
					if( remainingDaysOfPasswordValidity < 0 )
					{
						request.setAttribute("message", "Su contraseña ha caducado.");
					}
					else 
					{

						if( remainingDaysOfPasswordValidity  < 7  )
						{
							request.setAttribute("message", "Su contraseña caducar&aacute; en " + remainingDaysOfPasswordValidity + " d&iacute;a(s).");
						}
						
						request.getSession().setAttribute("user", user);
					}
				}
				else if(user.getStatus().equals(UserValueObject.STATUS.BLOCKED))
				{	
					request.setAttribute("message", "El usuario est&aacute; bloqueado.");
				}

				
				RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
				rd.forward(request, response);
				return;				
			}
			else // Las credenciales NO son validas
			{
				error = new ErrorValueObject();
				
				error.setMessage("Credenciales no validas");
				error.setDescription("Las credenciales proporcionadas no son correctas.");
				
				request.setAttribute("error", error);
				
				RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
				rd.forward(request, response);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
					
			error = new ErrorValueObject();
			
			error.setMessage("Ocurrio un error al validar credenciales");
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
		}//llave del if que agrege
		
	}

}
