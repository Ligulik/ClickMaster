package pl.maciek_rychlinski.records;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;


public class DataAndTime {

    public String addDate(){
        return String.valueOf(LocalDate.now());

    }

    public String addTime(){
        return String.valueOf(LocalTime.now().truncatedTo(ChronoUnit.SECONDS));
    }

}
