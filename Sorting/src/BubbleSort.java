public class BubbleSort {
        public static int[] sort(int[] array) {
            boolean swaped = false;
            while (!swaped) {
                swaped = true;
                for (int i = 1; i < array.length; i++) {
                    if (array[i - 1] > array[i]) {
                        int temp = array[i - 1];
                        array[i - 1] = array[i];
                        array[i] = temp;
                        swaped = false;
                    }

                }
            }
            return array;
        }
}

