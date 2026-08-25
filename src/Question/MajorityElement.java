package Question;

public class MajorityElement {

    /*  Flood Fill Algorithm   */
    public int majorityElement(int[] nums) {
        int count = 0;
        int number = 0;
        for (int elem : nums) {
            if (count == 0) {
                number = elem;
                count++;
            } else if (number == elem) count++;
            else {
                count--;
            }
        }
        return number;
    }
}