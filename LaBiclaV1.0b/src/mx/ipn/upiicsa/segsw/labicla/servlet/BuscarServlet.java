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
import mx.ipn.upiicsa.segsw.labicla.util.ServletUtility;
import mx.ipn.upiicsa.segsw.labicla.util.Utility;
import mx.ipn.upiicsa.segsw.labicla.valueobject.ErrorValueObject;
import mx.ipn.upiicsa.segsw.labicla.valueobject.ProductValueObject;

/**
 * 
 * @author Guillermo E. Martinez Barriga
 *
 */
@WebServlet("/buscar.controller")
public class BuscarServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ServletUtility.showRequestData(request);
		
		ErrorValueObject error = null;
		ProductDAO dao = null;
		
		List<ProductValueObject> productList = null;;
		
		String criteria = request.getParameter("criteria");
		
		if(Utility.containsAnEmptyValue(criteria))
		{
			criteria = "";
		}
		
		try 
		{
			dao = new ProductDAO();
			
			productList = dao.findByCriteria(criteria);
			
			request.setAttribute("productList", productList);
			
			RequestDispatcher rd = request.getRequestDispatcher("products.jsp");
			rd.forward(request, response);
			return;

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
