package sendrovitz.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailMatching {
	private static final Pattern EMAIL_PATTERN = Pattern.compile("\\S+?@(\\p{Alnum})+?-*\\.(\\p{Alpha}){2,}");
	public static void main(String args[]){
	//\\. - need to escape the dot character and then escape the escape
	
	String text = "email: sendy613@gmail.com";
	Matcher l = EMAIL_PATTERN.matcher(text);
	boolean b = l.matches();
	System.out.println(b);
	
	while(l.find()){
		String email = text.substring(l.start(), l.end());
		System.out.println(email);
	}
}
}
