import java.util.ArrayList;
import java.util.Arrays;

public class EqualsButton {
    public static float calculateValue(String input){
        char[] arr = input.toCharArray();
        ArrayList<Integer> OperatorPos = new ArrayList<>();
        ArrayList<String> values = new ArrayList<>();

        for (int x = 0; x < arr.length; x++){
            if (arr[x] == '×' ||arr[x] == '÷' ||arr[x] == '+' ||arr[x] == '-' ){
                OperatorPos.add(x);
            }
        }
        OperatorPos.add(input.length());
        values.add(input.substring(0,OperatorPos.get(0)));
        values.add(input.substring(OperatorPos.get(0)+1,OperatorPos.get(1)));
        for (int y = 1; y < OperatorPos.size() - 1; y++) {
            values.add(input.substring(OperatorPos.get(y)+1,OperatorPos.get(y+1)));
        }

        Float[] prime = new Float[values.size()];
        for (int x = 0; x < values.size(); x++){
            prime[x] = Float.parseFloat(values.get(x));
        }

        System.out.println(Arrays.toString(prime));
        System.out.println(OperatorPos);

        //if the next element and the previous element both do not equal a symbol then it's fine. Else, math error
        //Division by 0
        //Binary Tree for calculation?
        //negative numbers --> Create new data type that holds a negative sign, but is separate from -
        // Breadth-first search
        float count = 0f;

        if (arr[OperatorPos.get(0)] == ('×')) {
            count = prime[0]*prime[1];
        }
        if (arr[OperatorPos.get(0)] == ('÷')) {
            count = prime[0]/prime[1];
        }
        if (arr[OperatorPos.get(0)] == ('+')) {
            count = prime[0]+prime[1];
        }

        if (arr[OperatorPos.get(0)] == ('-')) {
            count = prime[0]-prime[1];
        }

        for (int g = 1; g < prime.length-1; g++){
            if (arr[OperatorPos.get(g)] == ('×')) {
                count = count*prime[g+1];
            }
            if (arr[OperatorPos.get(g)] == ('÷')) {
                count = count/prime[g+1];
            }
            if (arr[OperatorPos.get(g)] == ('+')) {
                count = count+prime[g+1];
            }

            if (arr[OperatorPos.get(g)] == ('-')) {
                count = count-prime[g+1];
            }
        }

        return count;
    }
}

/*
public static float calculateValue(String input){
        char[] arr = input.toCharArray();
        ArrayList<Integer> OperatorPos = new ArrayList<>();
        int counter = 0;
        ArrayList<String> values = new ArrayList<>();

        for (int x = 0;x < arr.length; x++){
            if (arr[x] == '×' ||arr[x] == '÷' ||arr[x] == '+' ||arr[x] == '-' ){
                OperatorPos.add(x);
                counter++;
            }
        }
        OperatorPos.add(input.length());
        String[] i = new String[counter+1];
        values.add(input.substring(0,OperatorPos.get(0)));
        values.add(input.substring(OperatorPos.get(0)+1,OperatorPos.get(1)));
        for (int y = 1; y < OperatorPos.size() - 1;y++) {
            values.add(input.substring(OperatorPos.get(y)+1,OperatorPos.get(y+1)));
        }

        int f = arr[0];
        Float[] prime = new Float[values.size()];
        for (int x = 0; x < values.size(); x++){
            prime[x] = Float.parseFloat(values.get(x));
        }

        System.out.println(Arrays.toString(prime));
        System.out.println(OperatorPos);

        //if the next element and the previous element both do not equal a symbol then it's fine. Else, math error
        //Division by 0
        //Binary Tree for calculation?
        //negative numbers --> Create new data type that holds a negative sign, but is separate from -
        // Breadth-first search
        float count = 0f;

        if (arr[OperatorPos.get(0)] == ('×')) {
            count = prime[0]*prime[1];
        }
        if (arr[OperatorPos.get(0)] == ('÷')) {
            count = prime[0]/prime[1];
        }
        if (arr[OperatorPos.get(0)] == ('+')) {
            count = prime[0]+prime[1];
        }

        if (arr[OperatorPos.get(0)] == ('-')) {
            count = prime[0]-prime[1];
        }

        for (int g = 1; g < prime.length-1; g++){
            if (arr[OperatorPos.get(g)] == ('×')) {
                count = count*prime[g+1];
            }
            if (arr[OperatorPos.get(g)] == ('÷')) {
                count = count/prime[g+1];
            }
            if (arr[OperatorPos.get(g)] == ('+')) {
                count = count+prime[g+1];
            }

            if (arr[OperatorPos.get(g)] == ('-')) {
                count = count-prime[g+1];
            }
        }

        return count;
    }
 */
