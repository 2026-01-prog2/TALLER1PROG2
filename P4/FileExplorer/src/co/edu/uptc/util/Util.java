package co.edu.uptc.util;

public class Util {
    public static String regex (String pattern){
        return pattern.replace(".", "\\.").replace("*", ".*").replace("?", ".");
    }
}
