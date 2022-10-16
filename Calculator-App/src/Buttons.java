import javax.swing.*;
import java.util.ArrayList;

public class Buttons extends JButton {

    public Buttons(String a){
        char[] arr = a.toCharArray();
        ArrayList<Integer> pos = new ArrayList<>();
        //pos.add(0);
        char j = '+';
        int counter = 0;
        ArrayList<String> arr2 = new ArrayList<>();

        for (int x = 0;x < arr.length; x++){
            if (arr[x] != '1'&&arr[x] != '0'&&arr[x] != '2'&&arr[x] != '3'&&arr[x] != '4'&&arr[x] != '5'&&arr[x] != '6'&&arr[x] != '7'&&arr[x] != '8'&&arr[x] != '9'){
                pos.add(x);
                counter++;
            }
        }
        pos.add(a.length());
        String[] i = new String[counter+1];
        arr2.add(a.substring(0,pos.get(0)));
        arr2.add(a.substring(pos.get(0)+1,pos.get(1)));
        for (int y = 1; y < pos.size() - 1;y++) {
            arr2.add(a.substring(pos.get(y)+1,pos.get(y+1)));
        }
        //arr2.remove(arr2.size()-1);

        int f = arr[0];
        int[] prime = new int[arr2.size()];
        for (int x = 0; x < arr2.size(); x++){
            prime[x] = Integer.parseInt(arr2.get(x));
            //System.out.println(arr2.get(x));
        }


        int count = 0;
            //System.out.println(arr[pos.get(x)]);

        if (arr[pos.get(0)] == ('×')) {
            //System.out.println("Yes");
            count = prime[0]*prime[1];
            //System.out.print(count);
        }
        if (arr[pos.get(0)] == ('÷')) {
            count = prime[0]/prime[1];
            //System.out.print(count);
        }
        if (arr[pos.get(0)] == ('+')) {
            count = prime[0]+prime[1];
            //System.out.println(count);
        }

        if (arr[pos.get(0)] == ('-')) {
            count = prime[0]-prime[1];
        }

        for (int g = 1; g < prime.length-1; g++){
            //for (int x = 0; x < pos.size()-1;x++){
                //System.out.print(g + " ");
                //System.out.print(g);
                //System.out.println(primg[g] + " " +prime[g+1]);
                if (arr[pos.get(g)] == ('×')) {
                    //System.out.println("Yes");
                    count = count*prime[g+1];
                    //System.out.print(count);
                }
                if (arr[pos.get(g)] == ('÷')) {
                    count = count/prime[g+1];
                    //System.out.print(count);
                }
                if (arr[pos.get(g)] == ('+')) {
                    count = count+prime[g+1];
                    //System.out.println(count);
                }

                if (arr[pos.get(g)] == ('-')) {
                    count = count-prime[g+1];
                }
            }
        System.out.println(count);
        //a.setText(count);
    }
}
