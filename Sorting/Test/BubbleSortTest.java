
import org.junit.Test;
import org.junit.Assert.*;
import static  org.junit.Assert.*;

public class BubbleSortTest {

    @Test
    public  void sortSortedList(){
        assertArrayEquals(new int []{0, 1}, BubbleSort.sort( new int []{0,1}));
    }

    @Test
    public  void sortUnsortedListOfLengthTwo() throws Exception{
       checkBubbleSortedArray(new int []{0,1}, BubbleSort.sort(new int [] {1, 0}));
    }
    @Test
    public  void sortUnsortedListOfLengthThree() throws Exception{
        checkBubbleSortedArray(new int []{0,1,2}, BubbleSort.sort(new int [] {0, 2, 1}));
    }
    @Test
    public  void sortUnsortedListOfLengthThreeVol2() throws Exception{
        checkBubbleSortedArray(new int []{0,1,2}, BubbleSort.sort(new int [] {2,1,0}));
    }

    @Test
    public  void sortUnsortedListOfLengthTen() throws Exception{
        checkBubbleSortedArray(new int []{0,1,2,3,4,5,6,7,8,9}, BubbleSort.sort(new int [] {7,5,6,8,9,4,3,2,1,0}));
    }



    public void checkBubbleSortedArray(int[] expectedArray, int [] inputArray){
        assertArrayEquals(expectedArray, BubbleSort.sort(inputArray));
    }

}


