package com.properties;

public class frm {
	
	private frm() {
		
		
	}
	    private static frm fr;
	    
	public static frm getIsntancefrm() {
		
		if(fr == null) {
			 fr = new frm();
			 
		}
		return fr;

	}
	
	public configreader getInstanceconfigurationreader() {
		
		configreader cf = new configreader();
		return cf;
				
		
	}
	

}
