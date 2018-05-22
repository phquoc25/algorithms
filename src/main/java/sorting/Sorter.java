/**
 *
 * Copyright (C) 2018 Deveryware S.A. All Rights Reserved.
 *
 */
package sorting;

/**
 * Created by Quoc PHAN on 22/05/2018.
 */
public interface Sorter<T extends Comparable> {
    T[] sort(T[] array);
}
