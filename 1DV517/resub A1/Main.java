import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author ht222fd
 * 
 * Exercise 5 Assignment 1 Language and Logic VT2018
 * html scrapping
 * Extract html links using a regex 
 * */

public class Main {
	

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader("src/TEST.html"));
        String line;
        

        //String stringToSearch = getHtml();
        // the pattern we want to search for
        Pattern regexLink = Pattern.compile("<\\s*a\\s+.*?href\\s*=\\s*\"(\\S*?)\".*?>");
        Pattern regexTag = Pattern.compile("(\\S*?)#(\\S*?)");
        Pattern regexHTTPS = Pattern.compile("(\\S*?)https(\\S*?)",Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Pattern regexScript = Pattern.compile("(\\S*?)script(\\S*?)",Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Pattern regexMailto = Pattern.compile("(\\S*?)mailto(\\S*?)",Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        
        
        while ((line = bufferedReader.readLine()) != null) {
        	Matcher matchLink = regexLink.matcher(line);
        	Matcher matchTag = regexTag.matcher(line);
    		Matcher matchHTTPS = regexHTTPS.matcher(line);
    		Matcher matchJS = regexScript.matcher(line);
    		Matcher matchMailto = regexMailto.matcher(line);
    		
        	if(matchLink.find()) 
        	{
        		
        		
        		if(matchTag.find()) {
        			System.out.println("Tag found: " + line);
        		}
        		else if (matchHTTPS.find()) {
        			System.out.println("Protocol found: " + line);
        		}
        		else if (matchJS.find()) {
        			System.out.println("Script found: " + line); 
        		}
        		else if (matchMailto.find()) {
        			System.out.println("Mailto found: " + line);
        		}
        		else {
        			System.out.println("This link does not follow any protocol: " + line);
        		}
        	}
        	
        }
        
        bufferedReader.close();
    }
	


}
