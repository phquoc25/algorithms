package dictionariesnhashmap.counttriplets;

import java.util.List;

public class CountTripletsSolution {
    static long countTriplets(List<Long> arr, long r) {
        return arr.stream().map(aLong -> {
            long minorVal = aLong / r;
            long majorVal = aLong * r;
            long[] counter = new long[2];
            arr.forEach(aLong1 -> {
                if (aLong1 == minorVal) {
                    counter[0] = counter[0] + 1;
                }

                if (aLong1 == majorVal) {
                    counter[1] = counter[1] + 1;
                }
            });
            return counter[0] * counter[1];
        }).reduce(0L, (aLong, aLong2) -> aLong + aLong2);
    }
}
