package Data4;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountryMedalDataStatisticsService {

    // państwa które zdobyły przynajmniej jeden złoty medal
    public List<String> FindCountriesWhichHasAtLeastOneGoldenMedal(final List<CountryMedalData> dataList) {
        return dataList.stream()
                .filter(countryMedalData -> countryMedalData.getNumberOfGoldenMedals() >= 1) //odfiltrowuje obiekty countryData na te które zdobyły przynajmniej jeden złoty medal
                .map(CountryMedalData::getCountryShortName) // zamienia obiekty na Stringi
                .collect(Collectors.toList()); // zbiera Stringi do listy
    }

    //  państwa które zdobyły przynajmniej jeden jakikolwiek medal
    public List<String> FindCountriesWithAnyMedal(final List<CountryMedalData> dataList) {
        return dataList.stream()
                .filter(countryMedalData -> countryMedalData.getNumberOfGoldenMedals() >= 1 ||
                        countryMedalData.getNumberOfSilverMedals() >= 1 ||
                        countryMedalData.getNumberOfBrownMedals() >= 1)
                .map(CountryMedalData::getCountryShortName)
                .collect(Collectors.toList());
    }

    // państwo które zdobyło najwięcej złotych medali
    public String FindCountryWhichWonTheBiggestNumberOfGoldenMedals(final List<CountryMedalData> dataList) {
        return dataList.stream()
                .max(Comparator.comparing(CountryMedalData::getNumberOfGoldenMedals))
                .map(countryMedalData -> countryMedalData.getCountryShortName())
                .get();
    }

    //  państwo które zdobyło najwięcej medali (w sumie)
//    public String FindCountryWhichWonTheBiggestNumberOfMedals(final List<CountryData> dataList) {
//        dataList.stream()
//                .
//
//    }

    //znajdzie państwo które było najbardziej pechowe (najwięcej 4 miejsc)
    public String FindCountryWhichHadABadLuck(List<CountryMedalData> dataList) {
        return dataList.stream()
                .max(Comparator.comparing(CountryMedalData::getNumber))
                .map(countryMedalData -> countryMedalData.getCountryShortName())
                .get();
    }
    //znajdzie te kraje które zdobyły więcej srebrnych medali od złotych
//    public List<String> FindCountriesWhichWonMoreSilverMedalsThanGoldenMedals(final List<CountryData> dataList){
//        return dataList.stream()
//                .

 //   }
//    znajdzie kraje które zdobyły więcej brązowych medali od srebrnych i więcej srebrnych od złotych
//    public List<String> FindCountriesWhichWonMoreBrownMedalsThanSilverAndMoreSilverThanGolden(final List<CountryData> dataList){
//       return dataList.stream()
//               .
  //  }
//    zwróci statystyki (tzn. Map<String, Integer>) ile państ w sumie zdobyło medali
    public Map<String, Integer> GiveStatisticsAboutMedals(final List<CountryMedalData> dataList){
        return dataList.stream()
                .collect(Collectors.groupingBy(CountryMedalData::getCountryShortName))
                .entrySet().stream()
                .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue().size()));
    }
//    znajdzie dominantę złotych medali zdobytych per państwo

//    znajdzie kraj który zdobył najwięcej punktów wg następującej punktacji: medal złoty - 3 punkty, medal srebrny - 2 punkty,
//medal brązowy - 1 punkt

//    policzy ilość medali zdobytych przez wszystkie kraje

//posortuje malejąco obiekty wg ilość zdobytych srebrnych medali

}
