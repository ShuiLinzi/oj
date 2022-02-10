package programmercarl;

public class LeetCode5 {
    public String replaceSpace(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                stringBuilder.append("%20");
            } else stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

}
