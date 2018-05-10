import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by Yang.jing on 18/5/7.
 */
public class ListUtils {
    public static <T> List<T> removeAll(List<T> source, List<T> destination) {
        List<T> result = new LinkedList<T>();
        Set<T> destinationSet = new HashSet<T>(destination);
        for(T t : source) {
            if (!destinationSet.contains(t)) {
                result.add(t);
            }
        }
        return result;
    }
}
