/**
 *
 * Copyright (C) 2018 Deveryware S.A. All Rights Reserved.
 *
 */
package sorting;

/**
 * Created by Quoc PHAN on 22/05/2018.
 */
public class SelectionSortImpl<T extends Comparable> extends GenericSort<T> {
    public T[] sort(T[] array)
    {
        int arrSize = array.length;
        if (arrSize < 2) {
            return array;
        }
        int i = 0;
        while (i < arrSize) {
            int minValIndex = getMinValIndex(array, i);
            if (minValIndex != i) {
                swap(array, minValIndex, i);
            }

            i++;
        }
        return array;
    }

    private int getMinValIndex(T[] array, int fromIndex)
    {
        int arrSize = array.length;
        int minValIndex = fromIndex;
        for (int j = fromIndex + 1; j < arrSize; j++) {
            if (less(array[j], array[minValIndex])) {
                minValIndex = j;
            }
        }
        return minValIndex;
    }
}
