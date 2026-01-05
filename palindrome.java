public class palindrome {
    public static void main(String[] args) {
        String i = "ABCDCBA";
        String output = "";
        System.out.println("input length: " + i.length());
        for (int j = i.length() - 1; j >= 0; j--) {
            output += i.charAt(j);
        }
        System.out.println(output);
    }
}
