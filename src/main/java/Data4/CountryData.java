package Data4;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
public class CountryData {

    private String countryShortName;
    private int numberOfGoldenMedals;
    private int numberOfSilverMedals;
    private int numberOfBrownMedals;
    private int number;


}
