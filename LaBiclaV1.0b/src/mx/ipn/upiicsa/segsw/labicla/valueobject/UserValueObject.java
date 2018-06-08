package mx.ipn.upiicsa.segsw.labicla.valueobject;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Guillermo E. Martinez Barriga
 *
 */

public class UserValueObject implements Serializable
{	
	private String email;
	private String firstname;
	private String lastname;
	private String password;
	private int daysOfPasswordValidity;
	private Date dateOfLastPasswordUpdate;
	private boolean isTemporalPassword;
	private String activationKey;
	private String status;
	
	public class STATUS
	{
		public static final String ACTIVE = "ACTIVE";
		public static final String BLOCKED = "BLOCKED";
		public static final String CANCELLED = "CANCELLED";
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getName() {
		return firstname + " "  + lastname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
	public int getDaysOfPasswordValidity() {
		return daysOfPasswordValidity;
	}
	public void setDaysOfPasswordValidity(int daysOfPasswordValidity) {
		this.daysOfPasswordValidity = daysOfPasswordValidity;
	}
	public Date getDateOfLastPasswordUpdate() {
		return dateOfLastPasswordUpdate;
	}
	public void setDateOfLastPasswordUpdate(Date dateOfLastPasswordUpdate) {
		this.dateOfLastPasswordUpdate = dateOfLastPasswordUpdate;
	}
	public boolean isTemporalPassword() {
		return isTemporalPassword;
	}
	public void setTemporalPassword(boolean isTemporalPassword) {
		this.isTemporalPassword = isTemporalPassword;
	}
	public String getActivationKey() {
		return activationKey;
	}
	public void setActivationKey(String activationKey) {
		this.activationKey = activationKey;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		
		sb.append("{ email:");
		sb.append(email);
		sb.append(", firstname;");
		sb.append(firstname);
		sb.append(", lastname;");
		sb.append(firstname);
		sb.append(", password;");
		sb.append(password);
		sb.append("}");
		
		return sb.toString();
	}
	
	

}
