class RemoveDuplicatesFromSortedArray {
    
    public static int remove(int sorted[]) {

        if(sorted.length == 0) return 0;

        int slowPointer = 0; // Only helps to change the unique elements to the front
        int fastPointer = 1; // this is moving foward scanning the array


        // when you find a different elements means you have to move slow pointer
        // because there you will find the last repeated element where you have to move
        // the fastPointer
        while(fastPointer < sorted.length) {
            if(sorted[slowPointer] != sorted[fastPointer]) {
                slowPointer++;
                sorted[slowPointer] = sorted[fastPointer];
            }

            fastPointer++;
        }


        return slowPointer + 1;
    }
    
    public static void main(String[] args) {
        int sorted[] = {1,1,2,2,3,4,4};

        int len = remove(sorted);
        
        System.out.println(len);

        for(int i : sorted) {
            System.out.println(i);
        }
    }
}