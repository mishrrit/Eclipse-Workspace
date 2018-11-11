package TestNgSamples;

public class Support {
	
	public int Sum(int a, int b) {
		return a+b;
	}

	public int Diff(int i, int j) {
		return i-j;
	}

	public String name(String string, String string2) {
		return string + string2;
	}

	
	public boolean logic (String name1,String name2) {
		if(name1.equals(name2))
			return true;
		else
			return false;
		
	}
	

}
