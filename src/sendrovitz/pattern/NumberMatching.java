package sendrovitz.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberMatching {
	public static void main(String args[]){
	Pattern p = Pattern.compile("a*b");
	Matcher m = p.matcher("aaab");
	boolean b = m.matches();
	
	//matches one digit ([0-9] or \d - but need double \
	//\D- any non-digit
	Pattern s = Pattern.compile("\\d");
	//\\d{10} - gives you specifically that amount
	//* - gives you 0+
	//+ - 1+
	//? - 1 or not at all
	
	//matches if have dashes or not
	//(1-)? - ? is on whatever is in ()
	Pattern z = Pattern.compile("(1-\\s*)?(\\d{3}-?\\s*){2}\\d{4}");
	String text = "This is my number 1-526-524  5248. call me";
	Matcher t = z.matcher(text);
			b = t.matches();
	System.out.println(b);
	
	
	//is want to find a phone number in bet text, use a matcher class
	//m.find= like iterator. returns true when finds a piece that matches your pattern.
	//returns the string and the start and end of it
	while(t.find()){
		String number = text.substring(t.start(), t.end());
		 String newNum  = number.replaceAll("(\\s){1,}", "-");
		System.out.println(newNum);
	}
			
			
	//\s -space
	

	
	
	
	
}
}
