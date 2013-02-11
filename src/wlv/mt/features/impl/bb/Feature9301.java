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
public class Feature9301 extends Feature {

	/* (non-Javadoc)
	 * @see wlv.mt.features.impl.Feature#run(wlv.mt.features.util.Sentence, wlv.mt.features.util.Sentence)
	 */
	
	public Feature9301(){
		setIndex(9301);
		setDescription("Source PCFG average confidence of all possible parses in n-best list");
        HashSet<String> res = new HashSet<String>();
		res.add("BParser");
		setResources(res);
	}
	
	public void run(Sentence source, Sentence target) {
		setValue(new Float((Double) source.getValue("bparser.avgConfidence")));
	}

}
