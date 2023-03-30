package IntroSort.Sort;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class WorksWithFiles {
    public static void main(String[] args) throws IOException {
        for(int i = 0 ; i < 70; i++){
            File file = new File("C:\\Users\\pc\\OneDrive\\Рабочий стол\\Random numbers\\test"+ i +".txt");
            file.createNewFile();

            PrintWriter pw  = new PrintWriter(file);

            Scanner input = new Scanner(System.in);
            int a  = rnd(100,1000);
            pw.print(randomizer(a));
            pw.close();
            
        }
       
    }
    public static String randomizer(int a){
        Scanner input = new Scanner(System.in);

        int min = 100;
        int max = 10000;

        int[] arrays = new int[a];
        for(int i  = 0 ; i <arrays.length; i++){
            arrays[i] = (int)(Math.random()*1000);
        }
        return Arrays.toString(arrays) ;
    }

    // Метод для полчения числа в диапозоне 
    public static int rnd(int min, int max){
	max -= min;
	return (int) (Math.random() * ++max) + min;

    }
}    
