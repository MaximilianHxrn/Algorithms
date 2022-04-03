public class Algorithms {

    private static int counter = 0;

    public static void main(String[] args) {
        LinkedList();
    }

    private static void LinkedList() {
        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(Integer.toString(i));
        }
        System.out.println(list.toString());
        System.out.println(list.toStringBackwards());
    }

    @SuppressWarnings("unused")
    private static void BinarySearch() {
        int[] array = new int[100000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        System.out.println(find(array, 10, 0, array.length));
    }

    private static String find(int[] array, int toFind, int start, int end) {
        counter++;
        if (start > end) {
            return "Not found";
        }
        int middle = (start + end) / 2 + 1;
        if (toFind == array[middle]) {
            return "Found " + toFind + " at index " + middle + " after " + counter + " tries.";
        }
        if (toFind < array[middle]) {
            return find(array, toFind, start, middle - 1);
        } else {
            return find(array, toFind, middle, end);
        }
    }
}