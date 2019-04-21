import java.util.Date;

/**
 * Lily likes to play games with integers. She has created a new game where she determines the difference between a number and its reverse.
 * For instance, given the number 12, its reverse is 21. Their difference is 9. The number 120 reversed is 21, and their difference is 99.
 * She decides to apply her game to decision making. She will look at a numbered range of days and will only go to a movie on a beautiful day.
 * Given a range of numbered days, [i..j] and a number k, determine the number of days in the range that are beautiful.
 * Beautiful numbers are defined as numbers where |i - j| is evenly divisible by k. If a day's value is a beautiful number, it is a beautiful day. Print the number of beautiful days in the range.
 * Input Format
 * A single line of three space-separated integers describing the respective values of i, j, and k.
 * Constraints
 *
 *
 * Output Format
 * Print the number of beautiful days in the inclusive range between  and .
 * Sample Input
 * 20 23 6
 * Sample Output
 * 2
 * Explanation
 * Lily may go to the movies on days 20, 21, 22, and 23. We perform the following calculations to determine which days are beautiful:
 * Day 20 is beautiful because the following evaluates to a whole number: |20 - 2| / 6 = 18 / 6 = 3
 * Day  is not beautiful because the following doesn't evaluate to a whole number:
 * Day  is beautiful because the following evaluates to a whole number:
 * Day  is not beautiful because the following doesn't evaluate to a whole number:
 * Only two days,  and , in this interval are beautiful. Thus, we print  as our answer.
 */
public class BeautifulDay {
    private final int from;
    private final int to;
    private final int k;

    public BeautifulDay(int from, int to, int k) {
        this.from = from;
        this.to = to;
        this.k = k;
    }

    int reverse(int value) {
        char[] valueAsArr = String.valueOf(value).toCharArray();
        int result = 0;
        int length = valueAsArr.length;
        for (int i = length - 1; i >= 0; i--) {
            result = result + Integer.valueOf(String.valueOf(valueAsArr[i])) * (int) Math.pow(10d, i);
        }
        return result;
    }

    public int getNbOfBeautifulDays() {

        int reverseVal;
        int nbBeautifulDay = 0;
        for (int i = from; i <= to; i++) {
            reverseVal = reverse(i);
            if(Math.abs(i - reverseVal) % k == 0) {
                nbBeautifulDay++;
            }
        }
        return nbBeautifulDay;
    }

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(calendarWeekIso(date));
    }

    public static Long calendarWeekIso (Date inputDate) {
        Date thisThursday = new Date(inputDate.getYear(), inputDate.getMonth(), inputDate.getDate() - weekday(inputDate) + 4);
        Date firstOfJan = new Date(thisThursday.getYear(), 0, 1);
        Date firstThursdayOfYear = new Date(thisThursday.getYear(), 0, 1);
        while(weekday(firstThursdayOfYear) != 4){
            firstThursdayOfYear.setDate(firstThursdayOfYear.getDate() + 1);
        }
        Date firstMondayOfYear = new Date(firstThursdayOfYear.getYear(), 0, firstThursdayOfYear.getDate() - 3);
        Long cw = (thisThursday.getTime() - firstMondayOfYear.getTime())/1000/60/60/24/7 + 1;
        return cw;
    }

    public static Integer weekday (Date date){
        int weekday = date.getDay();
        if(weekday == 0){
            weekday = 7;
        }
        return weekday;
    }
}
