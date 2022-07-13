///hide
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(PiekoszekExtension.class)
class PiekoszekFileSpaceCounterTest {

    @TempDir
    private File tempDir;

    private FileSpaceCounter fileSpaceCounter = new FileSpaceCounter();

    @Test
    void shouldCountSpaces() throws IOException {
        var file = new File(tempDir, "sample.txt");
        Files.writeString(file.toPath(), "dej mnie nogie, ja bez nogi zyc nie mogie");

        assertThat(fileSpaceCounter.countSpaces(file.getAbsolutePath()))
                .withFailMessage("Coś nie tak te spacje liczy")
                .isEqualTo(8);
    }

    @Test
    void shouldReturnMinusOneForNotExistingFile() {
        int result = 0;
        try {
            result = fileSpaceCounter.countSpaces("fiaosjghs87934hfiuhewa78r3");
        } catch (Throwable t) {
            fail("Poleciał wyjątek, a nie powinien");
        }

        assertThat(result)
                .withFailMessage("Powinno być -1 dla nieistniejącego pliku")
                .isEqualTo(-1);
    }

}