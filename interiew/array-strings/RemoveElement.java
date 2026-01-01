public class RemoveElement {
    public static int remove(int numbers[], int value) {

        int slow = 0, fast = 0;

        while(fast < numbers.length) {
            
            if(numbers[fast] != value) {
                numbers[slow] = numbers[fast];
                slow++;
            }

            fast++;
        } 

        return slow;
    }

    public static void main(String[] args) {
        int sorted[] = {1,2,2,2,3,4,4};

        int len = remove(sorted, 2);
        System.out.println("LEN " + len );
        
        for(int i : sorted) {
            System.out.println(i);
        }
    }
}
