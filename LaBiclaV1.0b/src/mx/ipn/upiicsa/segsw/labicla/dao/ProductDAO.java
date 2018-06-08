package mx.ipn.upiicsa.segsw.labicla.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mx.ipn.upiicsa.segsw.labicla.exception.DAOInitializationException;
import mx.ipn.upiicsa.segsw.labicla.valueobject.ProductValueObject;
import mx.ipn.upiicsa.segsw.labicla.valueobject.UserValueObject;

/**
 * 
 * @author Guillermo E. Martinez Barriga
 *
 */

public class ProductDAO  extends DataAccessObject
{

	public ProductDAO() throws ClassNotFoundException, SQLException 
	{
		super();
	}
	
	public ProductValueObject findById(Integer id) throws SQLException, DAOInitializationException
	{
		ResultSet rs = null;
		PreparedStatement stmt = null;
		
		ProductValueObject product = null;
		
		String sql = "SELECT * FROM products WHERE id = ?";
		
		System.out.println("ProductDAO.findByCriteria() - SQL - " + sql);

		try
		{
			stmt = prepareStatement(sql);

			stmt.setInt(1, id);
			
			rs = stmt.executeQuery();
			
			if(rs.next())
			{
				product = new ProductValueObject();
				
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setBrand(rs.getString("brand"));
				product.setPrice(rs.getFloat("price"));
				product.setQuantity(rs.getInt("quantity"));
				product.setImage(rs.getString("image"));
			}
			
			return product;
		}
		finally
		{
			closeResultSet(rs);
			closeStatement(stmt);
		}
		
	}
	
	public List<ProductValueObject> findByCriteria(String criteria) throws SQLException, DAOInitializationException
	{
		ResultSet rs = null;
		PreparedStatement stmt = null;
		
		ProductValueObject product = null;
		
		List<ProductValueObject> productList = new ArrayList<ProductValueObject>();
		
		String sql = "SELECT * FROM products WHERE name LIKE ?";
		
		System.out.println("ProductDAO.findByCriteria() - SQL - " + sql);

		try
		{
			stmt = prepareStatement(sql);

			stmt.setString(1, "%" + criteria + "%");
			
			rs = stmt.executeQuery();
			
			while(rs.next())
			{
				product = new ProductValueObject();
				
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setBrand(rs.getString("brand"));
				product.setPrice(rs.getFloat("price"));
				product.setQuantity(rs.getInt("quantity"));
				product.setImage(rs.getString("image"));
				
				productList.add(product);
			}
			
			return productList;
		}
		finally
		{
			closeResultSet(rs);
			closeStatement(stmt);
		}
	}

}
