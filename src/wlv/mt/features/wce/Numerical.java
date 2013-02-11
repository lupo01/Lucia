/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wlv.mt.features.wce;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author luongngocquang
 */
public class Numerical {
    public String sentence;
    public Numerical(String sentence)
    {
        this.sentence= sentence;
    }
    public int calculate()
    {
        String word;
        String expression = "[-+]?[0-9]*[\\.\\,]?[0-9]+$";
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher;
        int count=0;
        int index= sentence.indexOf(" ");
        while (index >=0)
        {
           word = sentence.substring(0,index);
           matcher = pattern.matcher(word.trim());

           if(matcher.matches()) 
                    count++;
           sentence = sentence.substring(index+1);
	   index= sentence.indexOf(" ");		
        }
        matcher = pattern.matcher(sentence.trim());
        if(matcher.matches()) 
                    count++;
        return count;
        
    }
    public static void main(String[] args)
    {
        System.out.println(new Numerical("Point 5.6 and -56.87654 : The interest rate of 3 months is 7.45 for all 100 banks").calculate());
    }
    
    
}
