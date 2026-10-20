package p04_BubbleSortTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BubbleTest {


    @Test
    void test_Sort_ShouldSort_In_AscendingOrder() {

        int [] expected = {-1, 0, 1, 2, 3, 4};
        int [] actual = {4, -1, 3, 0, 2, 1};

        Bubble.sort(actual);

        Assertions.assertArrayEquals(expected, actual);


    }



}
