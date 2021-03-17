package com.hafo;
import java.util.Date;
import java.util.Scanner;

public class MyDate {
    private int day, month, year;
    MyDate(){
        Date thisdate = new Date();
        set_Day(thisdate.getDate());
        set_Month(thisdate.getMonth() + 1);
        set_Year(1900 + thisdate.getYear());
    }

    MyDate(int day, int month, int year){
        set_Day(day);
        set_Month(month);
        set_Year(year);
    }

    MyDate(String date){
        String[] strArray = date.split(" ");
        set_Year(Integer.parseInt(strArray[2]));
        String[] day = strArray[1].split("t");
        set_Day(Integer.parseInt(day[0]));
        switch (strArray[0]){
            case "January": set_Month(1); break;
            case "February": set_Month(2); break;
            case "March": set_Month(3); break;
            case "April": set_Month(4); break;
            case "May": set_Month(5); break;
            case "June": set_Month(6); break;
            case "July": set_Month(7); break;
            case "August": set_Month(8); break;
            case "September": set_Month(9); break;
            case "October": set_Month(10); break;
            case "November": set_Month(11); break;
            case "December": set_Month(12); break;
            default: set_Month(-1);
        }
    }

    void set_Day(int day){
        if(day > 0 && day < 32){
            this.day = day;
        }
        else{
            System.out.println("Invalid Day");
            this.day = -1;
        }
    }

    void set_Month(int month){
        if(month > 0 && month < 13){
            this.month = month;
        }
        else{
            System.out.println("Invalid Month");
            this.month = -1;
        }
    }

    void set_Year(int year){
        if(year >= 0){
            this.year = year;
        }
        else{
            System.out.println("Invalid Year");
            this.year = -1;
        }
    }

    int get_Day(){
        return day;
    }

    int get_Month(){
        return month;
    }

    int get_Year(){
        return year;
    }

    MyDate accept(){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        MyDate myDate = new MyDate(str);
        return myDate;
    }

    void print(){
        boolean isvalid = true;
        if(day == -1 || month == -1 || year == -1){
            isvalid = false;
        }
        else{
            boolean isleap = true;
            if(year % 4 == 0){
                if(year % 100 == 0 && year % 400 != 0){
                    isleap = false;
                }
            }
            else isleap = false;
            if(month == 2){
                if(day >= 30) isvalid = false;
                if(!isleap && day == 29) isvalid = false;
            }
            if(month == 4 || month == 6 || month == 9 || month == 11){
                if(day == 31) isvalid = false;
            }
        }
        if(isvalid)
            System.out.println(day + "/" + month + "/" + year);
        else{
            System.out.println("Your input date is invalid");
        }
    }
}  