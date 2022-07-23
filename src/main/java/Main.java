import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        new CsvService()
                .export(Path.of("jest.csv"), List.of(
                        new Employee("Marian", "Paździoch", 600000),
                        new Employee("Mariola", "Kiepska", 10000),
                        new Employee("Ferdynand", "Kiepski", 4000)
                ));
    }
}
