package p03_IteratorTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.naming.OperationNotSupportedException;

public class ListIteratorTest {

    private ListIterator iterator;

    @BeforeEach
    public void setUp() throws OperationNotSupportedException {
        iterator = new ListIterator("Paul", "Marian", "Todor");

    }

    @Test
    void test_ListIterator_ThrowException_IfElementsAreNull(){
        Assertions.assertThrows(OperationNotSupportedException.class, () -> new ListIterator(null));

    }

    @Test
    void test_move_ReturnsTrue_IfNextElementExists(){
        Assertions.assertTrue(iterator.move());
    }

    @Test
    void test_move_ReturnFalse_IfNextElementDoesExist(){
        iterator.move();
        iterator.move();
        iterator.move();
        Assertions.assertFalse(iterator.move());
    }

    @Test
    void test_hasNext_ReturnsTrue_When_NextElementExists(){
        Assertions.assertTrue(iterator.hasNext());
    }

    @Test
    void test_haxNext_ReturnsFalse_When_NextElementDoesExist(){
        iterator.move();
        iterator.move();

        Assertions.assertFalse(iterator.hasNext());
    }

    @Test
    void test_print_CurrentElement(){
        Assertions.assertEquals("Paul", iterator.print());

    }

    @Test
    void test_print_NextElement(){
        iterator.move();
        Assertions.assertEquals("Marian", iterator.print());

    }


    @Test
    void test_print_ThrowException_WhenListEmpty() throws OperationNotSupportedException {
        ListIterator emptyIterator = new ListIterator();

        Assertions.assertThrows(IllegalStateException.class, emptyIterator::print);

    }


}
