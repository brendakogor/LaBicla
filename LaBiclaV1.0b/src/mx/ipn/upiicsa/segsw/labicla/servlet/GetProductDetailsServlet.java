package mx.ipn.upiicsa.segsw.labicla.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.ipn.upiicsa.segsw.labicla.dao.ProductDAO;
import mx.ipn.upiicsa.segsw.labicla.util.Utility;
import mx.ipn.upiicsa.segsw.labicla.valueobject.ErrorValueObject;
import mx.ipn.upiicsa.segsw.labicla.valueobject.ProductValueObject;

/**
 * 
 * @author Guillermo E. Martinez Barriga
 *
 */
@WebServlet("/get_product_detail.controller")
public class GetProductDetailsServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetProductDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		ProductDAO dao = null;
		ErrorValueObject error = null;
		
		String id = request.getParameter("id");
		
		if(Utility.containsAnEmptyValue(id))
		{
			
			error = new ErrorValueObject();
			
			error.setMessage("Parametro faltante");
			error.setDescription("Falt&oacute; capturar algun campo obligatorio.");
			
			request.setAttribute("error", error);
			
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);

			return;
		}
		
		try {
			
			dao = new ProductDAO();
			
			ProductValueObject product = dao.findById(Integer.parseInt(id));

			request.setAttribute("product", product);
			
			RequestDispatcher rd = request.getRequestDispatcher("product_details.jsp");
			rd.forward(request, response);
			return;

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
					
			error = new ErrorValueObject();
			
			error.setMessage("Ocurrio un error buscando detalles de un producto.");
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
