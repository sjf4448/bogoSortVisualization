import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class bogoSort {
    int counter = 1;
    public bogoSort(int[] list){
        while(!isSorted(list)){
            System.out.println(Arrays.toString(list) + " " + counter);
            shuffle(list);
            counter++;
        }
        System.out.println("Sorted " + Arrays.toString(list));
        System.out.println("In " + counter + " attempts");
    }
    
    boolean isSorted(int[] list){
        for (int i = 1; i < list.length; i++){
            if (!(list[i] > list[i - 1])){
                return false;
            }
        }
        return true;
    }

    static void shuffle(int[] list)
    {
        Random rand = new Random();
        for (int i = 0; i < list.length; i++) {
            int randomIndexToSwap = rand.nextInt(list.length);
            int temp = list[randomIndexToSwap];
            list[randomIndexToSwap] = list[i];
            list[i] = temp;
        }
    }

    public static void main(String[] args) {
        try{
            Integer.parseInt(args[0]);
        }
        catch (NumberFormatException | ArrayIndexOutOfBoundsException e){
            System.out.println("Usage: java bogoSort.java numElements");
            System.exit(1);
        }
        int[] list = new int[Integer.parseInt(args[0])];
        for (int i = 0; i < Integer.parseInt(args[0]); i++){
            list[i] = i;
        }
        shuffle(list);
        new bogoSort(list);
    }
}
