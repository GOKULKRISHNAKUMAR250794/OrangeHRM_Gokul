package generic_utility;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

public class JavaUtility {
public int generateRandomNumber() {
	Random ran=new Random();
	int num=ran.nextInt(1000);
	return num;
}
public String getLocalDate() {
	String date=LocalDate.now().toString().replace("-", "");
	return date;
}
public String getLocalDateTime() {
	String dateTime=LocalDateTime.now().toString().replace("-", "").replace(":", "").replace(".", "");
	return dateTime;
}
}
