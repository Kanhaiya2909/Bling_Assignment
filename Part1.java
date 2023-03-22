import java.util.Arrays;

public class Part1 {
    public static int nextServerNumber(int[] servers) {
        Arrays.sort(servers);
        int next = 1;
        for (int i = 0; i < servers.length; i++) {
            if (servers[i] == next) {
                next++;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 7, 1, 5, 9};
        int[] arr2 = {};
        int[] arr3 = {1, 2, 3};
        int[] arr4 = {2, 3, 4};

        System.out.println(nextServerNumber(arr1)); // Output: 3
        System.out.println(nextServerNumber(arr2)); // Output: 1
        System.out.println(nextServerNumber(arr3)); // Output: 4
        System.out.println(nextServerNumber(arr4)); // Output: 1

    }

}
