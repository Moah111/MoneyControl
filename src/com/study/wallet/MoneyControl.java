package com.study.wallet;

import com.study.wallet.model.Money;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MoneyControl {
	
	//method de convert 1 gia tri tu kieu String sang kieu date
	public static Date toDate(String value) throws ParseException { 
		SimpleDateFormat spf = new SimpleDateFormat("dd-MM-yyyy");
		return spf.parse(value);
	}
	public static void main(String[] args) throws ParseException {
		List<Money> list = FileIO.read();

		for (Money money: list) {
			System.out.println(money);
		}

		System.out.println(tienXang(list));
		System.out.println(tongTien(list));

		FileIO.push(list);
	}
	public static float tienXang(List<Money> ds){
	
		float result = 0;
		for (int i = 0; i < ds.size(); i++) {
			result = result + ds.get(i).getPetroCost();
		}
		return result;
	}
	public static float tongTien(List<Money> total){
		
		float tongTien = 0;
		for (int i = 0; i < total.size(); i++) {
			//gan gia tri total.get(i) thanh 1 bien(current)
			Money current=total.get(i);
			tongTien = tongTien + current.getPetroCost()+ current.getIncurredCost()+current.getItemsCost();
		}
		return tongTien;
		
	}

}
