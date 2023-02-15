package madLibs;

public class MadLib {

	
	String[] str;
	int arrayCounter;
	public MadLib(String mL) {
		for(int i = 0; i< mL.length(); i++) {
			
			if(mL.charAt(i) == ' ') {
				arrayCounter++;
			}
			else {
				str[arrayCounter] += mL.charAt(i);
			}
		}
		
		
		
		
	}



	public String[] getArray() {
		return str;
	}
	
}
