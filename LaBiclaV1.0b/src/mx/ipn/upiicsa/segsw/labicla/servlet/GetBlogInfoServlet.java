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

import mx.ipn.upiicsa.segsw.labicla.dao.BlogEntryDAO;
import mx.ipn.upiicsa.segsw.labicla.util.Utility;
import mx.ipn.upiicsa.segsw.labicla.valueobject.ErrorValueObject;
import mx.ipn.upiicsa.segsw.labicla.valueobject.BlogEntryValueObject;

/**
 * 
 * @author Guillermo E. Martinez Barriga
 *
 */

@WebServlet("/get_blog_info.controller")

public class GetBlogInfoServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBlogInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	process(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	process(request, response);
    }


	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		ErrorValueObject error = null;
		BlogEntryDAO dao = null;
		
		List<BlogEntryValueObject> blogEntryList = null;;
		
		String criteria = request.getParameter("criteria");
		
		if(Utility.containsAnEmptyValue(criteria))
		{
			criteria = "";
		}
		
		try 
		{
			dao = new BlogEntryDAO();
			
			blogEntryList = dao.findByCriteria(criteria);
			
			request.setAttribute("blogEntryList", blogEntryList);
			
			RequestDispatcher rd = request.getRequestDispatcher("blog.jsp");
			rd.forward(request, response);
			return;

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
					
			error = new ErrorValueObject();
			
			error.setMessage("Ocurrio un error al buscar informacion del blog.");
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

