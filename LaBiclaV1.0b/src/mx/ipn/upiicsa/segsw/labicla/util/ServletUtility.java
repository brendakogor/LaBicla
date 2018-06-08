package mx.ipn.upiicsa.segsw.labicla.util;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author Guillermo E. Martinez Barriga
 *
 */

public class ServletUtility {
	
	public static void showRequestData(HttpServletRequest request)
	{
		System.out.println(" === REQUEST: URI : " + request.getRequestURI());
		System.out.println(" === REQUEST: URL : " + request.getRequestURL().toString());
		System.out.println(" === REQUEST: referer : " + request.getHeader("referer"));
		
		Enumeration<String> dataNames = request.getHeaderNames();
		String name = null; 

		System.out.println(" === REQUEST: Headers");
		
		while(dataNames.hasMoreElements()) 
		{
			name = dataNames.nextElement();
			System.out.println(" === REQUEST: Header {" + name + ", " + request.getHeader(name) + "}");
		}
		
		dataNames = request.getParameterNames();


		System.out.println(" === REQUEST: Parameters");
		
		while(dataNames.hasMoreElements()) 
		{
			name = dataNames.nextElement();
			System.out.println(" === REQUEST: Parameter {" + name + ", " + request.getHeader(name) + "}");
		}
	}
}
