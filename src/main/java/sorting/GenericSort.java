/**
 *
 * Copyright (C) 2018 Deveryware S.A. All Rights Reserved.
 *
 */
package sorting;

/**
 * Created by Quoc PHAN on 22/05/2018.
 */
public abstract class GenericSort<T extends Comparable> implements Sorter<T> {
    protected void swap(T[] array, int i, int j)
    {
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    protected boolean less(T u, T v) {
        return u.compareTo(v) < 0;
    }
}
