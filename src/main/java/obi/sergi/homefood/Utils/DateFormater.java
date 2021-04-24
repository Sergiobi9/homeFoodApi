package obi.sergi.homefood.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormater {

    public static SimpleDateFormat timePattern = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ");

    public static Calendar getDateAsCalendar(String dateAsString) {
        Date date = null;
        try {
            date = timePattern.parse(dateAsString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return calendar;
    }

    public static String getDateWithFormat(Calendar dateCalendar) {
        int year = dateCalendar.get(Calendar.YEAR);
        int month = dateCalendar.get(Calendar.MONTH) + 1;
        int day = dateCalendar.get(Calendar.DATE);

        return (day < 10? "0" + day : day) + "/" + (month < 10? "0" + month : month) + "/" + year;
    }
}
