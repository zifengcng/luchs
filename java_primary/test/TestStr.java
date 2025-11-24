/**
 * @author wbc
 * @date 2025/11/3 19:35
 */
public class TestStr {

    public String reverseStr(String num) {
        if (num == null || num.isEmpty()) {
            return num;
        }
        String[] split = num.split(" ");
        StringBuilder sb = new StringBuilder();

        int len = split.length;
        for (int i = len - 1; i > 0; i--) {
            String trim = split[i].trim();
            if (!trim.isEmpty()) {
                sb.append(trim).append(" ");
            }
        }

        if (sb.length() > 0) {
            sb.delete(sb.length() - 1, sb.length());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        TestStr testStr = new TestStr();
        System.out.println(testStr.reverseStr("the sky is blue"));
        System.out.println(testStr.reverseStr(" hello world  "));
        System.out.println(testStr.reverseStr("a     good   example"));
    }

}
