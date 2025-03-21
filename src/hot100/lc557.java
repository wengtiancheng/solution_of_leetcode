package hot100;

import java.util.Scanner;

public class lc557 {
    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder("");
        int start = 0;
        for(int end = 0; end < s.length(); end++){
            if(s.charAt(end) == ' '){
                sb.append(new StringBuilder(s.substring(start, end)).reverse().toString() + " ");

                start = end + 1;
            }else if(end == s.length() - 1){
                sb.append(new StringBuilder(s.substring(start, end + 1)).reverse().toString());

                start = end + 1;
            }
            
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if(sc.hasNextLine()){
            String input = sc.nextLine();
            System.out.println(reverseWords(input));
        }
    }
}
