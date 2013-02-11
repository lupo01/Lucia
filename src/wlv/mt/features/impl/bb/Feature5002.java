/**
 *
 */
package wlv.mt.features.impl.bb;

import java.util.HashSet;
import java.util.StringTokenizer;

import wlv.mt.features.impl.Feature;
import wlv.mt.features.util.Sentence;
import wlv.mt.tools.Giza;
import wlv.mt.tools.Giza2;
import wlv.mt.features.wce.StopWord;
import java.io.*;



/**
 * Number of stopwords between in target sentence
 *
 * @author Luong Ngoc Quang
 *
 *
 */
public class Feature5002 extends Feature {

    //final static Float probThresh = 0.10f;

    public Feature5002() {
        setIndex(5002);
        setDescription("Ratio of number of stopwords in target and source sentence");
        HashSet res = new HashSet<String>();
        res.add("Giza");
        setResources(res);
    }

    /* (non-Javadoc)
     * @see wlv.mt.features.util.Feature#run(wlv.mt.features.util.Sentence, wlv.mt.features.util.Sentence)
     */
    @Override
    public void run(Sentence source, Sentence target) {
        // TODO Auto-generated method stub
        //Calculate number of stopwords in source sentence
        String text1 = source.getText();
        String stopwordPath1="";
        //Get the path of stopword list for Spanish
        try
        {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("config/config_en-es.properties")));
        String path;
        while ((path=br.readLine())!=null)
        {
            if (path.startsWith("english.stopwordlist")) break;
        }
        br.close();
        int index = path.indexOf("=");
        stopwordPath1= path.substring(index+1).trim();
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
        
        //System.out.println(stopwordPath1);
        
        ///Users/luongngocquang/Documents/resources/spanishstopwords.txt
        StopWord swcalculator = new StopWord(stopwordPath1,text1);
        int result1 = swcalculator.calculate();
        
        String text2 = target.getText();
        String stopwordPath2="";
        //Get the path of stopword list for Spanish
        try
        {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("config/config_en-es.properties")));
        String path;
        while ((path=br.readLine())!=null)
        {
            if (path.startsWith("spanish.stopwordlist")) break;
        }
        br.close();
        int index = path.indexOf("=");
        stopwordPath2= path.substring(index+1).trim();
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
        
        //System.out.println(stopwordPath1);
        
        ///Users/luongngocquang/Documents/resources/spanishstopwords.txt
        StopWord swcalculator2 = new StopWord(stopwordPath2,text2);
        int result2 = swcalculator2.calculate();
        
        
        
        float ratio ;
        if (result1==0) ratio = -1.00f;
        else
        ratio = (float) result2/result1;
        setValue(ratio);
    }
}
