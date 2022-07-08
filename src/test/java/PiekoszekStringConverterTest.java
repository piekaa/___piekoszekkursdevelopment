///hide


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(PiekoszekExtension.class)
class PiekoszekStringConverterTest {

    StringConverter stringConverter = new StringConverter();

    @Test
    void testNormalString() {
        try {
            assertThat(stringConverter.toPascalCase("aa bb cc"))
                    .withFailMessage("Chyba piekoszek coś zespuł, napisz do niego")
                    .isEqualTo("AaBbCc");
        } catch (Throwable t) {
            Assertions.fail("Nie powinno wyrzucić wyjątku dla poprawnego tekstu");
        }
    }

    @Test
    void testTwoSpaces() {
        try {
            stringConverter.toPascalCase("aa  bb");
            Assertions.fail("Powinien polecieć wyjątek dla 2 spacji obok siebie");
        } catch (IllegalArgumentException e) {
            // good
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable t) {
            Assertions.fail("Poleciał wyjątek dla 2 spacji obok siebie, ale nie IllegalArgumentException");
        }
    }

    @Test
    void testSpaceAtBeginning() {
        try {
            stringConverter.toPascalCase(" aa bb");
            Assertions.fail("Powinien polecieć wyjątek dla spacji na początku");
        } catch (IllegalArgumentException e) {
            // good
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable t) {
            Assertions.fail("Poleciał wyjątek dla spacji na początku, ale nie IllegalArgumentException");
        }
    }

    @Test
    void testSpaceAtTheEnd() {
        try {
            stringConverter.toPascalCase("aa bb ");
            Assertions.fail("Powinien polecieć wyjątek dla spacji na końcu");
        } catch (IllegalArgumentException e) {
            // good
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable t) {
            Assertions.fail("Poleciał wyjątek dla spacji na końcu, ale nie IllegalArgumentException");
        }
    }

    @Test
    void testTwoSpacesAtBeginning() {
        try {
            stringConverter.toPascalCase("  aa bb");
            Assertions.fail("Powinien polecieć wyjątek dla 2 spacji na początku");
        } catch (IllegalArgumentException e) {
            // good
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable t) {
            Assertions.fail("Poleciał wyjątek dla 2 spacji na początku, ale nie IllegalArgumentException");
        }
    }

    @Test
    void testTwoSpacesAtEnd() {
        try {
            stringConverter.toPascalCase("aa bb  ");
            Assertions.fail("Powinien polecieć wyjątek dla 2 spacji na końcu");
        } catch (IllegalArgumentException e) {
            // good
        } catch (AssertionError e) {
            throw e;
        } catch (Throwable t) {
            Assertions.fail("Poleciał wyjątek dla 2 spacji na końcu, ale nie IllegalArgumentException");
        }
    }

}