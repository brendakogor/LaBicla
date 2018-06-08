package mx.ipn.upiicsa.segsw.labicla.valueobject;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Guillermo E. Martinez Barriga
 *
 */
public class BlogEntryValueObject implements Serializable
{
	private int id;
	private String userEmail;
    private String value;
    private Date registrationDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		
		sb.append("{ id:");
		sb.append(id);
		sb.append(", user-email;");
		sb.append(userEmail);
		sb.append(", value;");
		sb.append(value);
		sb.append(", registration-date;");
		sb.append(registrationDate);
		sb.append("}");
		
		return sb.toString();
	}
	
    

}
