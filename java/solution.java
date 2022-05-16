import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {
    public static <T> List<Collection<T>> combination(Collection<T> values, int proba){
        List<Collection<T>> results = Collections.nCopies(1, Collections.emptyList());
        for (Collection<T> coll : Collections.nCopies(proba, new LinkedHashSet<>(values))){
            List<Collection<T>> temporary = new ArrayList<>();
            for (Collection<T> xv : results){
                for (T yv : coll){
                    Collection<T> z = new ArrayList<>(xv);
                    z.add(yv);
                    temporary.add(z);
                }
            }
            results = temporary;
        }
        return results;
    }
    public static List<Integer> calculation(int maxDigit) {
        int init = maxDigit == 7 ? 0 : 1;
        List numbers = new ArrayList();
        for (int i = init; i <= maxDigit; i++) numbers.add(i);
        List<Collection> comb = combination(numbers, 4);
        List<Integer> results = new ArrayList<>();
        
        for (Collection result: comb){
            int i = 0;
            for (Object p: result){
                i += Integer.parseInt(p.toString());
            }
            if (i == 21){
                String number = "";
                for (Object value : result){
                    number += value;
                }
                if (!number.equals("0777")){
                    results.add(Integer.parseInt(number));
                }
            }
        }
        if (results.isEmpty()){
            return null;
        }
        return results;
    }

}