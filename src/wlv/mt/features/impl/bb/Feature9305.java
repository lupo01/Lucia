/**
 * 
 */
package wlv.mt.features.impl.bb;

import java.util.HashSet;
import wlv.mt.features.impl.Feature;
import wlv.mt.features.util.Sentence;

/**
 * PCFG Parse log likelihood
 * 
 * @author Eleftherios Avramidis
 */
public class Feature9305 extends Feature {

	/* (non-Javadoc)
	 * @see wlv.mt.features.impl.Feature#run(wlv.mt.features.util.Sentence, wlv.mt.features.util.Sentence)
	 */
	
	public Feature9305(){
		setIndex(9305);
		setDescription("Target PCFG average confidence of all possible parses in n-best list");
        HashSet<String> res = new HashSet<String>();
		res.add("BParser");
		setResources(res);
	}
	
	public void run(Sentence source, Sentence target) {
		setValue(new Float((Double) target.getValue("bparser.avgConfidence")));
	}

}
