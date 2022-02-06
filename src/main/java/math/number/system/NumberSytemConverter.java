package math.number.system;

import org.junit.jupiter.api.Assertions;

public class NumberSytemConverter {

    public static int ToDecimal(String number,int numberSystem){
        int decimal = 0;
        int n = number.length();
        int pos = 0;
        for(int i = n - 1; i >= 0 ; i--){
            char ch = number.charAt(i);
            int multiplier = getMultiplier(ch,numberSystem);
            decimal = decimal + (int)Math.pow(numberSystem,pos) * multiplier ;
            pos++;
        }
        return decimal;
    }

    private static int getMultiplier(char ch,int numberSystem) {
        ch = Character.toUpperCase(ch);
        int multiplier = 0;
        if(numberSystem == 2){
            multiplier = Integer.parseInt(String.valueOf(ch));
        }
        if(numberSystem == 16){
            switch (ch){
                case 'A':
                    multiplier = 10;
                    break;
                case 'B':
                    multiplier = 11;
                    break;
                case 'C':
                    multiplier = 12;
                    break;
                case 'D':
                    multiplier = 13;
                    break;
                case 'E':
                    multiplier = 14;
                    break;
                case 'F':
                    multiplier = 15;
                    break;
                default:
                    multiplier = Integer.parseInt(String.valueOf(ch));

            }
        }
        return multiplier;
    }

    public static String toBinaryString(int decimal){
        StringBuilder sb = new StringBuilder();
        int temp = decimal;
        while(temp > 0){
            int reminder = temp % 2;
            sb.append(reminder);
            temp = temp / 2;
        }
        sb.reverse();
        return sb.toString();

    }

}
