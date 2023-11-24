package com.study.wallet;

import com.study.wallet.model.Money;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileIO {

    private static final String FILE_PATH = "data.txt";
    private static final SimpleDateFormat SPF = new SimpleDateFormat("yyyy-MM-dd");

    public static void push(List<Money> list) {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) {
                file.createNewFile();
            }
            PrintWriter printWriter = new PrintWriter(new FileOutputStream(file));
            printWriter.write(toFileFormat(list));
            printWriter.flush();
        } catch (Exception ex) {
            System.out.println("Something went wrong when store file " + ex);
        }
    }

    public static String toFileFormat(List<Money> list) {
        StringBuilder strBuilder = new StringBuilder();
        for (Money money: list) {
            strBuilder.append(withComma(String.valueOf(money.getPetroCost())));
            strBuilder.append(withComma(String.valueOf(money.getItemsCost())));
            strBuilder.append(withComma(String.valueOf(money.getIncurredCost())));
            strBuilder.append(withComma(String.valueOf(money.getBonusMoney())));
            strBuilder.append(SPF.format(money.getDate()));
            strBuilder.append("\n");
        }
        return strBuilder.toString();
    }

    public static List<Money> read() {
        List<Money> result = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new FileInputStream(FILE_PATH));
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                result.add(convertToMoney(line));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    private static Money convertToMoney(String line) {
        try {
            String[] moneyAttr = line.split(",");
            Money money = new Money();
            for (int i = 0; i < moneyAttr.length; i++) {
                money.setPetroCost(Float.parseFloat(moneyAttr[0]));
                money.setItemsCost(Float.parseFloat(moneyAttr[1]));
                money.setIncurredCost(Float.parseFloat(moneyAttr[2]));
                money.setBonusMoney(Float.parseFloat(moneyAttr[3]));
                money.setDate(SPF.parse(moneyAttr[4]));
            }
            return money;
        } catch (Exception ex) {
            System.out.println("Something went wrong when convert string to money object");
        }
        return null;
    }

    private static String withComma(String value) {
        return value + ", ";
    }

}
