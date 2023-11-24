package MyWallet;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MoneyControl {
	
	public static Date toDate(String value) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
		return simpleDateFormat.parse("2023-11-23");
	}
	public static void main(String[] args){
		Money today = new Money(80000, 0, 25000, 75000, new Date());
		Money yesterday = new Money(80000, 0, 25000, 75000, toDate("2023-11-23"));
		System.out.println(today.toString());
	}

}
