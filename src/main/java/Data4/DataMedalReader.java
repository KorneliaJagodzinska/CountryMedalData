package Data4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class DataMedalReader {
    private static final String Data_Separator = ",";
    private static final int EXPECTED_DATA_LEN = 4;
    private static final int COUNTRY_SHORT_NAME_ELEMENT_POSITION = 0;
    private static final int NUMBER_OF_GOLDEN_MEDALS_ELEMENT_POSITION = 1;
    private static final int NUMBER_OF_SILVER_MEDALS_ELEMENT_POSITION = 2;
    private static final int NUMBER_OF_BROWN_MEDALS_ELEMENT_POSITION = 3;
    private static final int NUMBER_ELEMENT_POSITION = 4;

    public List<CountryMedalData> readDataFromFile(final String path) {
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
    private CountryMedalData toCountryData(final String[] elements){
        if (elements.length < EXPECTED_DATA_LEN) {
            throw new MyException("Incorrect data length");
        }
        final CountryMedalData countryMedalData = new CountryMedalData();
        countryMedalData.setCountryShortName(elements[COUNTRY_SHORT_NAME_ELEMENT_POSITION]);
        countryMedalData.setNumberOfGoldenMedals(Integer.valueOf(elements[NUMBER_OF_GOLDEN_MEDALS_ELEMENT_POSITION]));
        countryMedalData.setNumberOfSilverMedals(Integer.valueOf(elements[NUMBER_OF_SILVER_MEDALS_ELEMENT_POSITION]));
        countryMedalData.setNumberOfBrownMedals(Integer.valueOf(elements[NUMBER_OF_BROWN_MEDALS_ELEMENT_POSITION]));
        countryMedalData.setNumber(Integer.valueOf(elements[NUMBER_ELEMENT_POSITION]));
        return countryMedalData;

    }
}
