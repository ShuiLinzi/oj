//package programmercarl;
//
//import java.util.Scanner;
//
//public class byteDance {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String next = in.next();
//        int length = next.length();
//        int[] nums = new int[length + 1];
//        for (int i = 0; i < length; i++) {
//            nums[i] = next.charAt(i);
//        }
//        int n = in.nextInt();
//        boolean aTrue = isTrue(nums, n);
//        System.out.println(aTrue);
//    }
//
//    private static boolean isTrue(int[] nums, int n) {
//        int m = 0;
//        int left = 0;
//        int right = nums.length;
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i - 1] > nums[i]) {
//                m = i;
//            }
//        }
//
//        int copyM = m;
//        while (left < copyM) {
//            int mid1 = left + (copyM - left) / 2;
//            if (nums[mid1] == n) {
//                return true;
//            }
//            if (nums[mid1] > n) {
//                copyM = mid1;
//            }
//            if (nums[mid1] < n) {
//                left = mid1;
//            }
//        }
//        int copyM2 = m;
//        while (right > copyM2) {
//            int mid2 = copyM2 + (right - copyM2) / 2;
//            if (nums[mid2] == n) {
//                return true;
//            }
//            if (nums[mid2] > n) {
//                right = mid2;
//            }
//            if (nums[mid2] < n) {
//                copyM2 = mid2;
//            }
//        }
//        return false;
//    }
//
//
//}
