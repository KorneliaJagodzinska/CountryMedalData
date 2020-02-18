package Data4;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CountryDataStatisticsService {

    // państwa które zdobyły przynajmniej jeden złoty medal
    public List<String> countriesWhichHasAtLeastOneGoldenMedal(final List<CountryData> dataList) {
        return dataList.stream()
                .filter(countryData -> countryData.getNumberOfGoldenMedals() >= 1) //odfiltrowuje obiekty countryData na te które zdobyły przynajmniej jeden złoty medal
                .map(CountryData::getCountryShortName) // zamienia obiekty na Stringi
                .collect(Collectors.toList()); // zbiera Stringi do listy
    }

    //  państwa które zdobyły przynajmniej jeden jakikolwiek medal
    public List<String> countriesWithAnyMedal(final List<CountryData> dataList) {
        return dataList.stream()
                .filter(countryData -> countryData.getNumberOfGoldenMedals() >= 1 ||
                        countryData.getNumberOfSilverMedals() >= 1 ||
                        countryData.getNumberOfBrownMedals() >= 1)
                .map(CountryData::getCountryShortName)
                .collect(Collectors.toList());
    }

    // państwo które zdobyło najwięcej złotych medali
    public String countryWhichWonTheBiggestNumberOfGoldenMedals(final List<CountryData> dataList) {
        return dataList.stream()
                .max(Comparator.comparing(CountryData::getNumberOfGoldenMedals))
                .map(countryData -> countryData.getCountryShortName())
                .get();
    }

    //  państwo które zdobyło najwięcej medali (w sumie)
//    public String countryWhichWonTheBiggestNumberOfMedals(final List<CountryData> dataList) {
//        dataList.stream()
//                .
//
//    }

    //znajdzie państwo które było najbardziej pechowe (najwięcej 4 miejsc)
    public String countryWhichHadABadLuck(List<CountryData> dataList) {
        return dataList.stream()
                .max(Comparator.comparing(CountryData::getNumber))
                .map(countryData -> countryData.getCountryShortName())
                .get();
    }
    //znajdzie te kraje które zdobyły więcej srebrnych medali od złotych
//    public List<String> countriesWhichWonMoreSilverMedalsThanGoldenMedals(final List<CountryData> dataList){
//
//    }

}
