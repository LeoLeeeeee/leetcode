package questions.numTrees;

public class Mine {

    public static int numTrees(int n) {
        int[] arr = new int[n+1];
        arr[0] = 1;
        for (int i = 1; i < n+1; i++){
            arr[i] = 0;
            for (int j = 1; j < i+1; j++){
                arr[i] += arr[j-1]*arr[i-j];
            }
        }
        return arr[n];
    }

    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }
}
