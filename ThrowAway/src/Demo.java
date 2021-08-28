
public class Demo { 
	
	public static void main(String[] args) {
		String s = "A man, a plan, a canal: Panama";
	    s = s.toLowerCase();
        String reverse = "";
        boolean t = true;
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= 'a' && s.charAt(i) <='z')
                reverse += s.charAt(i);
        }
        
     
        	System.out.println(reverse);
        	System.out.println(s);
        	System.out.println(t);
        
	}
}