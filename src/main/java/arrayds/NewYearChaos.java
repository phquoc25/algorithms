package arrayds;

/**
 * It's New Year's Day and everyone's in line for the Wonderland rollercoaster ride! There are a number of people queued up, and each person wears a sticker indicating their initial position in the queue.
 * Initial positions increment by 1 from 1 at the front of the line to n at the back.
 * Any person in the queue can bribe the person directly in front of them to swap positions. If two people swap positions, they still wear the same sticker denoting their original places in line.
 * One person can bribe at most two others. For example, if n = 8 and Person 4 bribes Person 5, the queue will look like this: 1,2,3,5,4,6,7,8.
 * Fascinated by this chaotic queue, you decide you must know the minimum number of bribes that took place to get the queue into its current state!
 * Function Description
 * Complete the function minimumBribes in the editor below. It must print an integer representing the minimum number of bribes necessary, or Too chaotic if the line configuration is not possible.
 * minimumBribes has the following parameter(s):
 * q: an array of integers
 * Input Format
 * The first line contains an integer , the number of test cases.
 * Each of the next  pairs of lines are as follows:
 * - The first line contains an integer , the number of people in the queue
 * - The second line has  space-separated integers describing the final state of the queue.
 * Constraints
 *
 *
 * Subtasks
 * For  score
 * For  score
 * Output Format
 * Print an integer denoting the minimum number of bribes needed to get the queue into its final state. Print Too chaotic if the state is invalid, i.e. it requires a person to have bribed more than  people.
 * Sample Input
 * 2
 * 5
 * 2 1 5 3 4
 * 5
 * 2 5 1 3 4
 * Sample Output
 * 3
 * Too chaotic
 * Explanation
 * Test Case 1
 * The initial state:
 * pic1(1).png
 * After person  moves one position ahead by bribing person :
 * pic2.png
 * Now person  moves another position ahead by bribing person :
 * pic3.png
 * And person  moves one position ahead by bribing person :
 * pic5.png
 * So the final state is  after three bribing operations.
 * Test Case 2
 * No person can bribe more than two people, so its not possible to achieve the input state.
 */
public class NewYearChaos {
    private final int[] qItems;

    public NewYearChaos(int[] qItems) {
        this.qItems = qItems;
    }

    public int minimumBribes() {
        // One person can bribe at most two others
        for (int i = qItems.length - 1; i >= 0; i--) {
            if (qItems[i] - 1 - i > 2) {
                return -1;
            }
        }

        int nbBribes = 0;
        boolean swapped = false;
        // for the normal case, use bubble sort to count the minimum swap
        for (int i = 0; i < qItems.length - 1; i++) {
            for (int j = 0; j < qItems.length - 1; j++) {
                if (qItems[j] > qItems[j + 1]) {
                    ArraysUtils.swap(qItems, j, j + 1);
                    nbBribes++;
                    swapped = true;
                }
            }
            // these lines is to minimize the loop. If there is no swap, the items is sorted.
            if (swapped) {
                swapped = false;
            } else {
                break;
            }
        }
        return nbBribes;
    }
}
