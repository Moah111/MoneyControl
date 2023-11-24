package MyWallet;

import java.util.Date;

public class MoneyControl {
	public static void main(String[] args){
		Money today = new Money(80000, 0, 25000, 75000, new Date());
		
		System.out.println(today.toString());
	}

}
