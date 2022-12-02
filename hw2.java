
import java.util.Arrays;
import java.util.Random;

public class hw2 {

    public static void main(String[] args) {   
           
        int[] array = createArray();
        printArray("Исходный массив:", array);
        array = sortArray(array, 0, array.length - 1);
        printArray("Отсортированный массив:", array);
    }

    public static int[] createArray() {
        Random r = new Random();
        int size = r.nextInt(10);
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = r.nextInt(100);
        }
        return arr;
    }

    public static void printArray(String msg, int[] array) {
        msg += "\n[";
        for (int i = 0; i < array.length; i++) {
            msg += array[i];
            if (i < array.length - 1) {
                msg += ", ";
            }
        }
        msg += "]";
        System.out.println(msg);
    }

    public static int[] sortArray(int[] array, int first, int last) {
        if (last <= first)
            return array;
        int middle = first + (last - first) / 2;
        sortArray(array, first, middle);
        sortArray(array, middle + 1, last);

        int[] temp = Arrays.copyOf(array, array.length);

        for (int k = first; k <= last; k++)
            temp[k] = array[k];

        int i = first, j = middle + 1;
        for (int k = first; k <= last; k++) {
            if (i > middle) {
                array[k] = temp[j];
                j++;
            } else if (j > last) {
                array[k] = temp[i];
                i++;
            } else if (temp[j] < temp[i]) {
                array[k] = temp[j];
                j++;
            } else {
                array[k] = temp[i];
                i++;
            }
        }
        return array;
    }
}
