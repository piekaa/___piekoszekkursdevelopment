///hide

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(PiekoszekExtension.class)
class PiekoszekCsvServiceTest {

    @TempDir
    private Path tempPath;

    private CsvService csvService = new CsvService();

    @Test
    void testNoSpaces() throws IOException {
        var path = tempPath.resolve("employees.csv");

        csvService.export(path, List.of(
                new Employee("LajtIsLajt", "Naanananana", 600000),
                new Employee("sdfsadfas", "434fsa", 10000)));

        var csv = Files.readString(path);

        assertThat(csv)
                .withFailMessage("Plik zawiera spacje, a niepowinien")
                .doesNotContain(" ");

    }

    @Test
    void testWorksFine() throws IOException {
        var path = tempPath.resolve("employees.csv");

        csvService.export(path, List.of(
                new Employee("aaa", "bbb", 123),
                new Employee("www", "xxx", 321)));

        var csv = Files.readString(path).trim();

        assertThat(csv)
                .withFailMessage("Coś jest nie tak")
                .isEqualTo("aaa,bbb,123\nwww,xxx,321");
    }

}
