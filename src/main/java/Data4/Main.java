package Data4;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        final String path = args[0];
        DataReader dataReader= new DataReader();
        final List<CountryData> dataList= dataReader.readDataFromFile(path);
        dataList.forEach(countryData -> System.out.println(countryData.getCountryShortName()+" "+
                countryData.getNumberOfGoldenMedals()+" "+
                countryData.getNumberOfSilverMedals()+" "+
                countryData.getNumberOfBrownMedals()));

    }
}
