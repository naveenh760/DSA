package utilities;

import java.util.Arrays;

public class StringUtils {

    public String sortString(String str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
