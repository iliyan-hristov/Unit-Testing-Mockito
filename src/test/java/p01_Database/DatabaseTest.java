package p01_Database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    private Database database;
    private Integer[] elements;

    @BeforeEach
    void setUp() throws OperationNotSupportedException {
        elements = new Integer[] {1, 2, 3, 4, 5};
        database = new Database(elements);

    }

    @Test
    void test_Constructor_Should_Throw_When_Elements_Greater_Then_16(){

        Integer[] elements = new Integer[20];
        Assertions.assertThrows(OperationNotSupportedException.class, () -> new Database(elements));

    }

    @Test
    void test_Constructor_Should_Throw_When_Elements_Less_Then_1(){

        Integer[] elements = new Integer[0];
        Assertions.assertThrows(OperationNotSupportedException.class, () -> new Database(elements));

    }

    @Test
    void test_Constructor_Should_Create_Correct_Database() throws OperationNotSupportedException {

        Integer[] result = database.getElements();
        Assertions.assertArrayEquals(elements, result);

    }

    @Test
    void test_Add_Should_Throw_When_Elements_Null(){

        Assertions.assertThrows(OperationNotSupportedException.class, () -> database.add(null));
    }

    @Test
    void test_Add_Should_Add_To_The_Last_Position() throws OperationNotSupportedException {

        database.add(15);
        Integer[] elements = database.getElements();
        int size = elements.length;

        Integer actualElements = elements [size - 1];
        Integer expectedElements = 15;
        Assertions.assertEquals(expectedElements, actualElements);

    }

    @Test
    void test_Add_Should_Should_Add_Should_Increase_Elements_Count() throws OperationNotSupportedException {

        database.add(15);

        Integer[] elements = database.getElements();
        int actualSize = elements.length;
        int expectedSize = 6;

        Assertions.assertEquals(expectedSize, actualSize);

    }

    @Test
    void test_Remove_Should_Throw_When_EmptyDatabase() throws OperationNotSupportedException {

        database = new Database(1);
        database.remove();
        Assertions.assertThrows(OperationNotSupportedException.class, () -> database.remove());

    }

    @Test
    void test_Remove_Should_throw_When_Element_Removed_Successfully() throws OperationNotSupportedException {

        Integer[] elements = database.getElements();
        Integer actualRemovedElement = elements[elements.length - 1];
        Integer expectedRemovedElement = 5;
        database.remove();

        Assertions.assertEquals(expectedRemovedElement, actualRemovedElement);
        Assertions.assertEquals(4, database.getElements().length);
    }



}
