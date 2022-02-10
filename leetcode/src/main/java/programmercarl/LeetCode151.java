package programmercarl;

public class LeetCode151 {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        StringBuilder stringBuilder = new StringBuilder();
        while (chars[left] == ' ') left++;
        while (chars[right] == ' ') right--;
        while (left <= right) {
            int index = right;
            while (chars[index] != ' ' && index >= left) index--;
            for (int i = index+1; i <= right; i++) {
                stringBuilder.append(chars[i]);
            }
            if (index > left) stringBuilder.append(' ');
            while (index >= left && chars[index] == ' ') index--;
            right = index;
        }
        return stringBuilder.toString();
    }


}
