/**
 *
 */
package wlv.mt.features.impl.bb;

import java.util.ArrayList;
import java.util.HashSet;

import wlv.mt.features.impl.Feature;
import wlv.mt.features.util.Sentence;
import wlv.mt.tools.LanguageModel;

/**
 *
 * percentage of distinct unigrams seen in the corpus (in all quartiles)
 *
 * @author Catalina Hallett
 *
 */
public class Feature1058 extends Feature {

    private int size = 1;

    public Feature1058() {
        setIndex(1058);
        setDescription("percentage of distinct unigrams seen in the corpus (in all quartiles)");
        HashSet res = new HashSet<String>();
        res.add("ngramcount");

        setResources(res);
    }
    /* (non-Javadoc)
     * @see wlv.mt.features.impl.Feature#run(wlv.mt.features.util.Sentence, wlv.mt.features.util.Sentence)
     */

    @Override
    public void run(Sentence source, Sentence target) {
        // TODO Auto-generated method stub
        ArrayList<String> ngrams = source.getNGrams(size);
        HashSet<String> unique = new HashSet<String>(ngrams);
        int count = 0;
        for (String ngram : unique) {
            if (LanguageModel.getFreq(ngram, size) > 0) {
                count++;
            }
        }

        setValue(count / (float) unique.size());
    }
}
