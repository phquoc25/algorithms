/**
 *
 * Copyright (C) 2018 Deveryware S.A. All Rights Reserved.
 *
 */
package sorting;

/**
 * Created by Quoc PHAN on 22/05/2018.
 */
public class ElementarySortImpl<T extends Comparable> extends GenericSort<T> {

    public T[] sort(T[] array)
    {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (less(array[i], array[j])) {
                    swap(array, i, j);
                }
            }
        }
        return array;
    }

}
