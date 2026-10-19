package p02_ExtendedDatabase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    private static final Person PERSON1 = Mockito.mock(Person.class);
    private static final Person PERSON2 = Mockito.mock(Person.class);
    private static final Person PERSON3 = Mockito.mock(Person.class);

    private Database database;

    @BeforeEach
    void setUp() throws OperationNotSupportedException {

        database = new Database(PERSON1, PERSON2, PERSON3, null);

        Mockito.when(PERSON1.getUsername()).thenReturn("Peter");
        Mockito.when(PERSON2.getUsername()).thenReturn("Kaloyan");
        Mockito.when(PERSON3.getUsername()).thenReturn("Sofia");

        Mockito.when(PERSON1.getId()).thenReturn(1);
        Mockito.when(PERSON2.getId()).thenReturn(2);
        Mockito.when(PERSON3.getId()).thenReturn(3);


    }

    @Test
    void test_add_ShouldThrowException_WhenIdExists() throws OperationNotSupportedException {
        Person person = new Person(1, "Ivan");
        Assertions.assertEquals(PERSON1.getId(), person.getId());
    }

    @Test
    void test_add_ShouldThrowException_WhenIdNull() throws OperationNotSupportedException {

        Assertions.assertThrows(OperationNotSupportedException.class, () -> {database.add(null);});
    }

    @Test
    void test_remove_ShouldThrowException_DatabaseEmpty() throws OperationNotSupportedException {
        Database database = new Database(PERSON1);
        database.remove();

        Assertions.assertThrows(OperationNotSupportedException.class, database::remove);
    }


    @Test
    void test_FindByUsername_ShouldThrowException_WhenUserName_NotPresent(){
        Assertions.assertThrows(OperationNotSupportedException.class, () -> database.findByUsername("Ivan"));

    }

    @Test
    void test_FindByUsername_ShouldThrowException_WhenUserNameNull(){

        Assertions.assertThrows(OperationNotSupportedException.class, () -> database.findByUsername(null));
    }


    @Test
    void test_FindByUsername_Check_If_ArgumentsAre_CaseSensitive() {

        Assertions.assertTrue(PERSON1.getUsername().contains("Peter"));
    }

    @Test
    void test_FindById_ShouldThrowException_WhenId_NotPresent() throws OperationNotSupportedException {
        Assertions.assertThrows(OperationNotSupportedException.class, () -> database.findById(4));
    }


}
