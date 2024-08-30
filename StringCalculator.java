import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.regex.Pattern;
import java.util.regex.MatchResult;
import java.util.stream.Stream;

// The main method must be in a class named "Main".
class Main {
    public static int add(String numbers) throws Exception{
        int addition = 0;
        String[] negativeNumbers = getMatches("-\\d*",numbers).toArray(String[]::new);
        if(negativeNumbers.length > 0){
            throw new Exception("negative numbers not allowed "+String.join(", ",negativeNumbers));
        } else {
            return getMatches("\\d*",numbers).map(s->Integer.parseInt(s)).reduce(0, (subtotal, element) -> subtotal + element);
        }
    }

    public static Stream<String> getMatches(String pattern, String text){
        return Pattern.compile(pattern).matcher(text).results().map(MatchResult::group).filter(s -> s.length() > 0);
    }
    
    public static void main(String[] args) throws Exception {
        System.out.println("Result : "+ add("1;2\n4;9"));
    }
}
