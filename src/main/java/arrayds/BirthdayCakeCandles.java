/**
 *
 * Copyright (C) 2018 Deveryware S.A. All Rights Reserved.
 *
 */
package arrayds;

/**
 * Created by Quoc PHAN on 25/05/2018.
 * You are in-charge of the cake for your niece's birthday and have decided the cake will have one candle for each year of her total age. When she blows out the candles, she?ll only be able to blow out the tallest ones. Your task is to find out how many candles she can successfully blow out.

 For example, if your niece is turning 4 years old, and the cake will have 4 candles of height 3, 1, 2, 3, she will be able to blow out  candles successfully, since the tallest candle is of height  and there are  such candles.

 Complete the function birthdayCakeCandles that takes your niece's age and an integer array containing height of each candle as input, and return the number of candles she can successfully blow out.

 Input Format

 The first line contains a single integer, , denoting the number of candles on the cake.
 The second line contains  space-separated integers, where each integer  describes the height of candle .
 Sample Input 0

 4
 3 2 1 3

 Sample Output 0

 2

 Explanation 0

 We have one candle of height , one candle of height , and two candles of height . Your niece only blows out the tallest candles, meaning the candles where . Because there are  such candles, we print  on a new line.
 */
public class BirthdayCakeCandles {
    public int calculateNbCandlesFlewOut(int[] candles)
    {
        int totalNbCandles = candles.length;
        int max = candles[0];
        int result = 1;
        for (int i = 1; i < totalNbCandles; i++) {
            if (candles[i] > max) {
                max = candles[i];
                result = 1;
            } else if (candles[i] == max){
                result++;
            }
        }
        return result;
    }
}
