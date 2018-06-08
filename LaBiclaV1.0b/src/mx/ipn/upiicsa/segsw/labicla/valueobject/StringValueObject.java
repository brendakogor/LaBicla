package mx.ipn.upiicsa.segsw.labicla.valueobject;

import java.util.ArrayList;
import java.util.List;


public class StringValueObject{
	private String palabraValidar;
	private List<Character> blackList = new ArrayList<Character>();
	private boolean status;
	
	
	public StringValueObject(String s) {
		this.palabraValidar = s;
		blackList.add('\'');
		blackList.add('-');
		blackList.add('\"');
		this.status = true;
		setStatus();
		
	}
	
	public void setStatus(){
		for(int i=0;i<blackList.size();i++) {
			if(palabraValidar.contains(Character.toString(blackList.get(i)))) {
				System.out.println("La palabra " + this.palabraValidar + "Contiene el caracter " + blackList.get(i));
				this.status = false;
			}
		}
		
	}
	public void setPalabraValidar(String s) {
		this.palabraValidar = s;		
	}
	public String getPalabraValidar() {
		return this.palabraValidar;
	}
	public boolean getStatus(){
		return this.status;
	}
}