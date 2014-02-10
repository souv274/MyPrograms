import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Simple application to parse a string using the java regex api. 
 * Can add a SAX parser to this in order to read the source from the file system
 *
 * @author Souvik Sarkar
 * @date 23rd Oct 2009
 *
 */

public class RegexpatternMatching {
    
    public static void match()
    {
	String record = "";
	String whiteListString = "[a-zA-Z0-9|&_\t\n=:+-\\[\\] ]";
	int allowedCount= 0;
	
	Pattern pattern = Pattern.compile(whiteListString);
	//read file from the file system
	try{
	       FileInputStream fin = new FileInputStream("/Users/Souvik/Java/Eclipse_Workspaces/MyPrograms/src/fileToParse.txt");
	       BufferedReader reader = new BufferedReader(new InputStreamReader(fin));
	       
        	while((record = reader.readLine() ) != null)
        	{
        	    System.out.println("Read Record : "+ record);
        	    Matcher matcher = pattern.matcher(record);
        	    allowedCount = 0;
        	    while(true)
        	    {
        		boolean found = matcher.find();
        		if(!found) 
        		{
        		    if (record.length() != allowedCount)
        			System.out.println("Breaking at: "+ allowedCount + " , RecordLength : " + record.length());
        			
        		    break;
        		}
        		allowedCount++;
        	    }
        	    
        	   if(record.length() != allowedCount) System.out.println("String is not valid : " + record);  
        	   else System.out.println("File is valid");
        	}
        	
        	fin.close();
	}catch(IOException e){e.printStackTrace(); System.exit(-1);}
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	RegexpatternMatching.match();

    }

}
