package home;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
/*import java.time.LocalDate;*/
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class time {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		String myDate = "2022/04/30";
		String myDate1 = "2022/05/01";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Date date = sdf.parse(myDate);
		long millis = date.getTime();
		Date date1 = sdf.parse(myDate1);
		long millis1 = date1.getTime();
		System.out.println(millis);
		System.out.println(millis1);
		System.out.println("-------------");
		System.out.println(millis1-millis);
		System.out.println("-------------");
		Date date2 = new Date();
		String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(date2);
		System.out.println(modifiedDate);
		
		
		SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
		String inputString1 = "23 01 1997";
		String inputString2 = "23 01 1997";

		try {
		    Date date3 = myFormat.parse(inputString1);
		    Date date4 = myFormat.parse(inputString2);
		    long diff = date4.getTime() - date3.getTime();
		    System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
		} catch (ParseException e) {
		    e.printStackTrace();
		}
	}

}
