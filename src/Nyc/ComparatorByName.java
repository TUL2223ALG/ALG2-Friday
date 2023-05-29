
package Nyc;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

/**
 *
 * @author ul
 */
public class ComparatorByName implements Comparator <Hurricane> {
    
    public static Collator col_cz = Collator.getInstance(new Locale ("cs", "CZ"));

    @Override
    public int compare(Hurricane o1, Hurricane o2) {
        return col_cz.compare(o1.getName(), o2.getName());
    }
    
}
