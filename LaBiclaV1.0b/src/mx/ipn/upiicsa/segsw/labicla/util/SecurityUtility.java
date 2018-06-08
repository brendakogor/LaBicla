package mx.ipn.upiicsa.segsw.labicla.util;

/**
 * 
 * @author Guillermo E. Martinez Barriga
 *
 */

public class SecurityUtility {
	
	private static final String PASSWORD_RULES = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{8,}";
	
	public static boolean isPasswordStrong(String password)
	{
		return password.matches(PASSWORD_RULES);
	}
	
	public static void main(String[] args)
	{
		System.out.println(isPasswordStrong("Ab1234567_"));
	}

}
