package programmercarl;

public class LeetCode1407 {
    public String removeDuplicates(String s) {
        StringBuffer sb = new StringBuffer();
        int flag = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (flag >= 0 && sb.charAt(flag) == c) {
                sb.deleteCharAt(flag);
                flag--;
            } else {
                sb.append(c);
                flag++;
            }
        }
        return sb.toString();
    }
}
