package Data4;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        final String path = args[0];
        DataMedalReader dataMedalReader = new DataMedalReader();
        final List<CountryMedalData> dataList= dataMedalReader.readDataFromFile(path);
        dataList.forEach(countryMedalData -> System.out.println(countryMedalData.getCountryShortName()+" "+
                countryMedalData.getNumberOfGoldenMedals()+" "+
                countryMedalData.getNumberOfSilverMedals()+" "+
                countryMedalData.getNumberOfBrownMedals()));

    }
}
