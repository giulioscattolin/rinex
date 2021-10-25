package com.github.giulioscattolin.rinex;

@Deprecated
interface SvEpochSvClkReader {
    char getSatelliteSystem(String line);

    int getSatelliteNumberOrNegative(String line);

    int getTocYearOrNegative(String line);

    int getTocMonthOrNegative(String line);

    int getTocDayOrNegative(String line);

    int getTocHourOrNegative(String line);

    int getTocMinuteOrNegative(String line);

    int getTocSecondOrNegative(String line);

    double getFirstTimeParameterOrNaN(String line);

    double getSecondTimeParameterOrNaN(String line);

    double getThirdTimeParameterOrNaN(String line);
}
