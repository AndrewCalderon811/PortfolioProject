package madLibs;

public class MadLib {

	
	private String[] str = new String[100];
	private int arrayCounter;
	public MadLib(String mL) {
		
		for(int i = 0; i< mL.length(); i++) {
			
			if(mL.charAt(i) == ' ') {
				arrayCounter++;
			}
			else {
				if(str[arrayCounter] == null) {
					str[arrayCounter] = String.valueOf(mL.charAt(i));
				}
				else {
				str[arrayCounter] += String.valueOf(mL.charAt(i));
				}
			}
		}
	}
	


	public String toString() {
		String ret = "";
		int counter = 0;
		while (str[counter] != null) {
			ret += str[counter] + " ";
			counter++;
		}
		return ret;
	}

	public String[] getArray() {
		return str;
	}
	
	public void userInput(int index, String word) {
		str[index] = word;
	}
	
}
