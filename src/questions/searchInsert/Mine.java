package questions.searchInsert;

public class Mine {

    public static int search(int[] nums, int target, int start, int end){
        if (target > nums[nums.length-1])
            return nums.length;
        if (start == end)
            return start;

        int middle = (start + end)/2;
        if (nums[middle] == target)
            return middle;
        else if (nums[middle] > target)
            return search(nums, target, start, middle);
        else
            return search(nums, target, middle+1, end);
    }

    public static int searchInsert(int[] nums, int target) {
        return search(nums, target, 0, nums.length-1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 8};
        System.out.println(searchInsert(nums, 9));
    }
}
