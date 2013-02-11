/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wlv.mt.features.impl.bb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

import wlv.mt.features.impl.Feature;
import wlv.mt.features.util.Sentence;
import wlv.mt.tools.Giza;
import wlv.mt.tools.Giza2;
//import wlv.mt.features.wce.Numerical;
import java.lang.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author luongngocquang
 */


public class Feature5013 extends Feature {

    //final static Float probThresh = 0.10f;

    public Feature5013() {
        setIndex(5013);
        setDescription("List of all maximum distribution of posterior probability (for each word) in the target sentence");
        //HashSet res = new HashSet<String>();
        //res.add("Giza");
        //setResources(res);
    }

    /* (non-Javadoc)
     * @see wlv.mt.features.util.Feature#run(wlv.mt.features.util.Sentence, wlv.mt.features.util.Sentence)
     */
    @Override
    public void run(Sentence source, Sentence target) {
        
        // TODO Auto-generated method stub
        String text = target.getText();
        //System.out.println("bat dau");
        //String t = "\"Peace\" is \" nice \"";
        try
        {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("config/config_en-es.properties")));
        String wpppath;
        while ((wpppath=br.readLine())!=null)
        {
            if (wpppath.startsWith("spanish.wordgraph")) break;
        }
        
        br.close();
        int index = wpppath.indexOf("=");
        wpppath= wpppath.substring(index+1).trim();
        //System.out.println(wpppath);
        Runtime r;
        r = Runtime.getRuntime();
        //System.out.println(wpppath);
                
        //Identify position
         br = new BufferedReader(new InputStreamReader(new FileInputStream("./input/spanish/target.es.tok")));
         index =0;
         String str;
         while ((str=br.readLine())!=null)
        {
            index++;
            if (str.compareToIgnoreCase(text)==0) break;
        }
        //Read the WPP file to extract data
        br = new BufferedReader(new InputStreamReader(new FileInputStream(wpppath)));
        int pos=1;
        while (pos < index)
        {
           str=br.readLine();
           while (str.length() > 0) str=br.readLine();
           pos++;  
        }
        //Read and store data
        str=br.readLine();
        if (str != null)
        {
        while (str.length() > 0)
        {
            //System.out.println(str.split("\t")[1]);
            setValue(str.split("\t")[4]);
            str=br.readLine();
            if (str == null) break;
        } 
        
        
        }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        //float i=0.07f;

        //setValue(i);
       
} 

//} 
//catch(IOException e1) {} 
//catch(InterruptedException e2) {} 

//System.out.println("Done"); 
        
        
        
        
    //}
    public static void main(String[] args)
    {
        Feature5013 f = new Feature5013();
        //System.out.println("fhajfdas");
        f.run(new Sentence("",3),new Sentence("",2) );
    }
    
}




