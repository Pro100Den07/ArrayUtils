public class ArrayUtils {

    // Метод для сортування злиттям
    public static void mergeSort(int[] array) {
        if (array.length <= 1) {
            return;
        }
        int mid = array.length / 2;
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];
        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, array.length - mid);
        mergeSort(left);
        mergeSort(right);
        merge(array, left, right);
    }

    // Метод для злиття двох відсортованих масивів
    private static void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }
        while (i < left.length) {
            array[k++] = left[i++];
        }
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

    // Метод для бінарного пошуку
    public static int binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1; // Якщо цільове значення не знайдено
    }

    // Метод для демонстрації роботи алгоритмів
    public static void main(String[] args) {
        // Створення масиву та випадкове заповнення
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100); // Випадкові числа від 0 до 99
        }

        // Виведення початкового масиву
        System.out.println("Початковий масив: ");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Застосування сортування злиттям
        mergeSort(array);

        // Виведення відсортованого масиву
        System.out.println("Відсортований масив: ");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Бінарний пошук
        int target = 50; // Значення, яке потрібно знайти
        int index = binarySearch(array, target);
        if (index != -1) {
            System.out.println("Цільове значення " + target + " знайдено на індексі " + index);
        } else {
            System.out.println("Цільове значення " + target + " не знайдено в масиві");
        }
    }
}