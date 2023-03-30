
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class IntroSort {
    public static int count;

    public static void main(String[] args) throws FileNotFoundException {

        for (int i = 0; i < 8; i++) {

            File file = new File("C:\\Users\\pc\\OneDrive\\Рабочий стол\\Random numbers\\test" + i + ".txt");
            Scanner scanner = new Scanner(file);

            String line = scanner.nextLine();
            String line1 = line.replace("[", "");
            String line2 = line1.replace("]", "");
            String line3 = line2.replace(" ", "");
            String[] stringNumbers = line3.split(",");

            int[] numbers = new int[stringNumbers.length];

            int count1 = 0;

            for (String num : stringNumbers) {
                numbers[count1++] = Integer.parseInt(num);
            }
            scanner.close();

            long start = System.nanoTime();

            introsort(numbers);
            long finish = System.nanoTime();
            long elapsed = finish - start;
            System.out.println("Количество элементов " + numbers.length);
            System.out.println(Arrays.toString(numbers));
            System.out.println("----------------------------------------------------------");

            System.out.println(elapsed);

            System.out.println("----------------------------------------------------------");

            System.out.println("Количество итераций " +count);

            System.out.println("----------------------------------------------------------");
        }

    }

    public static void introsort(int[] arr) {
        int maxdepth = (int) Math.floor(Math.log(arr.length) * 2);
        introsortHelper(arr, 0, arr.length - 1, maxdepth);
    }

    private static void introsortHelper(int[] array, int lo, int hi, int maxdepth) {
        int size = hi - lo + 1;

        // Если массив маленький, то использовать сортировку вставками

        if (size < 16) {
            insertionSort(array, lo, hi);
            return;

        }

        // Если это уже глубокая рекурсия, то использовать сортировку кучей
        if (maxdepth == 0) {
            heapsort(array, lo, hi);
            return;

        } else {
            quickSort(array, 0, array.length - 1 ,maxdepth);

        }

    }

    // Блок быстрой сортировки <<QuickSort>>
    public static void quickSort(int[] array, int low, int high , int maxdepth) {

        if (array.length == 0)
            return;// завершить выполнение, если длина массива равна 0

        if (low >= high)
            return;// завершить выполнение если уже нечего делить

        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        int opora = array[middle];

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            count++;
            while (array[i] < opora) {
                i++;
                count++;
            }

            while (array[j] > opora) {
                j--;
                count++;
            }

            if (i <= j) {// меняем местами
                swap(i, j, array);
                i++;
                j--;
            }
            count++;

        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j) {
            quickSort(array, low, j , maxdepth);

        }
        if (high > i) {
            quickSort(array, i, high , maxdepth);
        }
        
        
        // при каждом вызове быстрой сортировке уменьшаем :
        maxdepth--;

      

    }

    public static void swap(int k, int m, int arr[]) {
        int temp = arr[k];
        arr[k] = arr[m];
        arr[m] = temp;

    }

    // Блок сортировка кучей
    private static void heapsort(int[] array, int lo, int hi) {

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = lo; i <= hi; i++) {
            heap.offer(array[i]);
            count++;
        }
        for (int i = lo; i <= hi; i++) {
            array[i] = heap.poll();
            count++;
        }

    }

    // Блок сортировки всавками <<InsertSort>>
    private static void insertionSort(int[] array, int lo, int hi) {

        for (int i = lo + 1; i <= hi; i++) {
            int current = array[i];
            int j = i - 1;
            count++;
            while (j >= lo && array[j] > current) {
                array[j + 1] = array[j];
                j--;
                count++;
            }
            array[j + 1] = current;
        }

    }
}
