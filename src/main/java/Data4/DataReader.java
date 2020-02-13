package Data4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class DataReader {
    private static final String Data_Separator = ",";
    private static final int EXPECTED_DATA_LEN = 4;
    private static final int COUNTRY_SHORT_NAME_ELEMENT_POSITION = 0;
    private static final int NUMBER_OF_GOLDEN_MEDALS_ELEMENT_POSITION = 1;
    private static final int NUMBER_OF_SILVER_MEDALS_ELEMENT_POSITION = 2;
    private static final int NUMBER_OF_BROWN_MEDALS_ELEMENT_POSITION = 3;
    private static final int NUMBER_ELEMENT_POSITION = 4;

    public List<CountryData> readDataFromFile(final String path) {
        try {
            return Files.readAllLines(Paths.get(path)).stream()
                    .filter(line -> !line.isEmpty())
                    .map(line -> line.split(Data_Separator))
                    .map(this::toCountryData)
                    .collect(Collectors.toList());

        } catch (IOException e) {
            throw new MyException("Failed to read input file at " + path, e);
        }
    }
    // ta medtoda zamienia tablice Stringów w obiekty klasy CountryData
    private CountryData toCountryData(final String[] elements){
        if (elements.length < EXPECTED_DATA_LEN) {
            throw new MyException("Incorrect data length");
        }
        final CountryData countryData = new CountryData();
        countryData.setCountryShortName(elements[COUNTRY_SHORT_NAME_ELEMENT_POSITION]);
        countryData.setNumberOfGoldenMedals(Integer.valueOf(elements[NUMBER_OF_GOLDEN_MEDALS_ELEMENT_POSITION]));
        countryData.setNumberOfSilverMedals(Integer.valueOf(elements[NUMBER_OF_SILVER_MEDALS_ELEMENT_POSITION]));
        countryData.setNumberOfBrownMedals(Integer.valueOf(elements[NUMBER_OF_BROWN_MEDALS_ELEMENT_POSITION]));
        countryData.setNumber(Integer.valueOf(elements[NUMBER_ELEMENT_POSITION]));
        return countryData;

    }
}
