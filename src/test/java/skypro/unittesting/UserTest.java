package skypro.unittesting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    // объявляем константы:
    public static final String LOGIN = "login";
    public static final String EMAIL = "email@email.ru";
    public static final String WRONG_EMAIL = "emailemailru";
    public static final String WRONG_LOGIN = "emailemailru";

    private static User user;
    // Чтобы протестировать работу тестируемого класса нужно создать экземпляр этого класса
    // создается объект тестируемого класса
    @BeforeEach
    void init() {
        user = new User(LOGIN, EMAIL);
    }

    @Test
   void checkWhetherDataIsCorrectlyWhenCreatingAnObject() {
       assertEquals(LOGIN, user.getLogin());
       assertEquals(EMAIL, user.getEmail());
   }

    @Test
   void checkObjectFieldsForInequality() {
       assertNotEquals(LOGIN, EMAIL);
     }

     @Test
    void compareLoginAndEmailIsNotEquals(){
        assertThrows(IllegalArgumentException.class, () -> {new User(WRONG_LOGIN, WRONG_EMAIL);});
    }

     @Test
     void checkIfTheCorrectEmailIsInstalled(){
         assertThrows(IllegalArgumentException.class, () -> {new User(LOGIN, WRONG_EMAIL);});
     }

    @Test
    void checkEmptyParametersInObjectFields(){
        User user = new User();
        assertNull(user.getLogin());
        assertNull(user.getEmail());
    }
}
