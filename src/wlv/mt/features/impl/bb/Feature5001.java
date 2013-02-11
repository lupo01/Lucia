/**
 *
 */
package wlv.mt.features.impl.bb;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

import wlv.mt.features.impl.Feature;
import wlv.mt.features.util.Sentence;
import wlv.mt.tools.Giza;
import wlv.mt.tools.Giza2;
import wlv.mt.features.wce.StopWord;



/**
 * Number of stopwords between in target sentence
 *
 * @author Luong Ngoc Quang
 *
 *
 */
public class Feature5001 extends Feature {

    //final static Float probThresh = 0.10f;

    public Feature5001() {
        setIndex(5001);
        setDescription("Number of stopwords in the source sentence");
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
        String text = source.getText();
        String stopwordPath="";
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
        stopwordPath= path.substring(index+1).trim();
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
        
        System.out.println(stopwordPath);
        
        ///Users/luongngocquang/Documents/resources/spanishstopwords.txt
        StopWord swcalculator = new StopWord(stopwordPath,text);
        int result = swcalculator.calculate();

        setValue(result);
    }
}

