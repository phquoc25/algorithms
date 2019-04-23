package dictionariesnhashmap.counttriplets;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CountTripletsSolution {
    static long countTriplets(List<Long> arr, long r) {
        Map<Long, Long> numberDictionary = new HashMap<>();
        arr.forEach(element -> {
            Long currentVal = numberDictionary.get(element);
            if (Optional.ofNullable(currentVal).isPresent()) {
                numberDictionary.put(element, currentVal + 1);
            } else {
                numberDictionary.put(element, 1L);
            }
        });
        // loop through the list second time to find the number of triplets of each element then sum them to have the result
        return arr.stream().map(element -> {
            long minorVal = element / r;
            long majorVal = element * r;

            Long nbMinorVal = Optional.ofNullable(numberDictionary.get(minorVal)).orElse(0L);
            Long nbMajorVal = Optional.ofNullable(numberDictionary.get(majorVal)).orElse(0L);

            long nbOfTriplets = nbMinorVal * nbMajorVal;
            return nbOfTriplets;
        }).reduce(0L, (val1, val2) -> val1 + val2);
    }
}
