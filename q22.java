public class foobar3 {
    static int maxSize = 10;

    //helper function to remove the digits and return final int
    public static int remPrint ( int[] l, int a, int b){
        String temp="";
        for (int i = l.length - 1; i >= 0; i--) {
            if (i != a && i != b) {
                temp +=  Integer.toString(l[i]);
            }
        }
        if (temp != "") {
            return Integer.valueOf(temp);
        }
        return 0;//HANDLE THE CASE WHERE NO SUCH INT

    }

    public static void sort(int[] l){
        //sort the whole arr

        int[] count = new int[maxSize];//store the count of all digits in original array
        for (int i = 0; i < l.length; i++) {
            count[l[i]]++;
        }
        //store sorted array
        int index = 0;
        for (int i = 0; i < maxSize; i++) {//store
            while (count[i] > 0) {
                l[index++] = i;
                count[i]--;
            }

        }
    }

    public static int solution(int[] l) {
        int total = 0;
        for (int i = 0; i < l.length; i++) {
            total += l[i];
        }//calculate the sum of all digits in array

        sort(l);//sort array in ascending order

        if (total % 3 == 0) { return remPrint(l,-1,-1); }//if sum of the digits already div by 3, no need for further operation
        int r = total % 3;//initialize remainder r
        //if r = 1: delete a digit of r = 1 OR 2 digits with r = 2
        //if r = 2: delete a digit of r = 2 OR 2 digits of r = 1

        if (r == 1) {
            int[] rem_2 = new int[2];
            rem_2[0] = -1;
            rem_2[1] = -1;

            // Traverse array elements
            for (int i = 0; i < l.length; i++) {
                // Store first element of r=1
                if (l[i] % 3 == 1) {
                    return remPrint(l, i, -1);
                }
                if (l[i] % 3 == 2) {
                    // If this is first occurrence
                    // of r=2
                    if (rem_2[0] == -1) {
                        rem_2[0] = i;
                    }
                    // If second occurrence
                    else if (rem_2[1] == -1) {
                        rem_2[1] = i;
                    }
                }
            }
            if (rem_2[0] != -1 &&
                    rem_2[1] != -1) {
                return remPrint(l, rem_2[0],
                        rem_2[1]);
            }
        } else if (r == 2) {
            int[] rem_1 = new int[2];
            rem_1[0] = -1;
            rem_1[1] = -1;

            // traverse array elements
            for (int i = 0; i < l.length; i++) {

                // store first element of r=2
                if (l[i] % 3 == 2) {
                    return remPrint(l, i, -1);
                }

                if (l[i] % 3 == 1) {

                    // If this is first occurrence
                    // of r=1
                    if (rem_1[0] == -1) {
                        rem_1[0] = i;
                    }

                    // If second occurrence
                    else if (rem_1[1] == -1) {
                        rem_1[1] = i;
                    }
                }
            }
            if (rem_1[0] != -1 &&
                    rem_1[1] != -1) {
                return remPrint(l, rem_1[0],
                        rem_1[1]);
            }
        }
        return remPrint(l, -1, -1);
    }
}
