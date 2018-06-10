import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Friday13th {
    public static void main(String[] args) throws ParseException {
        Map<String, Integer> hMap = new HashMap<>();
        hMap.put("Sunday", 0);
        hMap.put("Monday", 0);
        hMap.put("Tuesday", 0);
        hMap.put("Wednesday", 0);
        hMap.put("Thusday", 0);
        hMap.put("Friday", 0);
        hMap.put("Saturday", 0);
        String[] strDays = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thusday",
                "Friday", "Saturday"};
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String startDateString = "13-01-1900";
        String endDateString = "13-01-2300";
        
        Date start = dateFormat.parse(startDateString);
        Date end = dateFormat.parse(endDateString);

        Calendar cStart = Calendar.getInstance();
        cStart.setTime(start);

        Calendar cEnd = Calendar.getInstance();
        cEnd.setTime(end);

        while (cStart.before(cEnd)) {
            int count = hMap.get(strDays[cStart.get(Calendar.DAY_OF_WEEK) - 1]) + 1;
            hMap.put(strDays[cStart.get(Calendar.DAY_OF_WEEK) - 1], count);
            cStart.add(Calendar.MONTH, 1);
        }

        String day = null;
        int count = Integer.MIN_VALUE;
        for (String key : hMap.keySet()) {
            //System.out.println(key + " " + hMap.get(key));
            if(hMap.get(key)>count){
                count = hMap.get(key);
                day = key;
            }
        }

        System.out.println(day + " : "+ count);
    }
}
