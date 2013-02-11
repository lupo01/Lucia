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
import wlv.mt.features.wce.Numerical;



/**
 * Number of stopwords between in target sentence
 *
 * @author Luong Ngoc Quang
 *
 *
 */
public class Feature5003 extends Feature {

    //final static Float probThresh = 0.10f;

    public Feature5003() {
        setIndex(5003);
        setDescription("Number of numericals in the target sentence");
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
        Numerical numcalculator = new Numerical(text);
        int result = numcalculator.calculate();

        setValue(result);
    }
   
}


