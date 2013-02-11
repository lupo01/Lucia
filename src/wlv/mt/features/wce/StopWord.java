/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wlv.mt.features.wce;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.io.FileWriter;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author luongngocquang
 */
public class StopWord {
    public String stopwordFile;
public String sentence;
public StopWord(String stopwordFile, String sentence)
{
this.stopwordFile= stopwordFile;
this.sentence = sentence;
}
public int calculate() {
      BufferedReader bufferedReader = null; 
      ArrayList<String> stopWordList = new ArrayList<String>();
    try
       {

        
        bufferedReader = new 
                BufferedReader(new InputStreamReader(new FileInputStream(stopwordFile)));
        String inputLine = null;
        //TreeMap<String, Integer> map = new TreeMap<String, Integer>();
        

        //try {
            while ((inputLine = bufferedReader.readLine()) != null) 
		if (inputLine.length() > 0) stopWordList.add(inputLine);
            bufferedReader.close();
                
            
		
	
        }
        catch (IOException error) {
            System.out.println("Invalid File nhe :");
            error.printStackTrace();
        }
        
	//FileWriter fw = new FileWriter(sentence);
	
        int count=0;
        int index= sentence.indexOf(" ");
        while (index >=0)
        {
           String word = sentence.substring(0,index);
           if (stopWordList.contains(word)) count++;
           sentence = sentence.substring(index+1);
	   index= sentence.indexOf(" ");		
        }
        if (stopWordList.contains(sentence.trim())) count++;  

	
     
	//fw.write(""+count);
        
            
	return count;

  
    }
    public static void main(String[] args) throws IOException
   {
   StopWord sw = new StopWord("/Users/luongngocquang/Documents/resources/englishstopwords.txt","The world is not enough");
   System.out.println(sw.calculate()+"");
      // System.out.println("OKKKK");
   }
    
    
    
}

