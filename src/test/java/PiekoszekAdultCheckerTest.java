///hide


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(PiekoszekExtension.class)
class PiekoszekAdultCheckerTest {

    AdultChecker adultChecker = new AdultChecker();

    @Test
    void checkAdult() {
        checkAllowed(-13472);
        assertThat(adultChecker.check(-13472)).withFailMessage("Ktoś, kto się jeszcze nie urodził, nie jest dorosły")
                .isEqualTo("not adult");

        checkAllowed(0);
        assertThat(adultChecker.check(0)).withFailMessage("0 lat to nie dorosły")
                .isEqualTo("not adult");

        checkAllowed(1);
        assertThat(adultChecker.check(0)).withFailMessage("1 rok to jeszcze nie dorosły")
                .isEqualTo("not adult");

        for (int i = 2; i <= 4; i++) {
            checkAllowed(i);
            assertThat(adultChecker.check(0)).withFailMessage(i + " lata to jeszcze nie dorosły")
                    .isEqualTo("not adult");
        }

        for (int i = 5; i <= 17; i++) {
            checkAllowed(i);
            assertThat(adultChecker.check(0)).withFailMessage(i + " lat to jeszcze nie dorosły")
                    .isEqualTo("adult");
        }

        for(var age : List.of(18, 19, 36, 69, 88)) {
            checkAllowed(age);
            assertThat(adultChecker.check(age)).withFailMessage(age + " lat to już dorosły")
                    .isEqualTo("adult");
        }

        checkAllowed(9357);
        assertThat(adultChecker.check(9357)).withFailMessage("Ktoś, kto ma 9357 lat może i już nie żyje, ale dorosły jest")
                .isEqualTo("adult");


    }

    private void checkAllowed(int age) {
        var result = adultChecker.check(age);
        assertThat(result.equals("adult") || result.equals("not adult"))
                .withFailMessage("""
                ma być "adult" albo "not adult", a nie "%s" """.formatted(result))
                .isTrue();
    }

}
