import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Country> countries = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("countries.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");

                int id = Integer.parseInt(fields[0].trim());
                String countryCode = fields[1].replace("\"", "").trim();
                String country = fields[2].replace("\"", "").trim();
                countries.add(new Country(id, countryCode, country));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Danh sách quốc gia : ");
        System.out.println("| ID | CountryCode | country|");
        for (Country country : countries) {
            System.out.println(country);
        }
    }
}