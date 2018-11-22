package edu.ptit.java.exception;

import java.util.*;
public class Input {
    public static int readInt(){
        Scanner in = new Scanner(System.in);
        int n=0; boolean kt=true;
        while(kt){
            try{
                String s = in.nextLine();
                char c = s.charAt(0);
                n=Integer.parseInt(s);
                if(n<=0) throw new ScoreException();
                kt=false;
            }
            catch(StringIndexOutOfBoundsException e){
                System.out.println("Ban quen chua nhap. Nhap lai");
            }
            catch(NumberFormatException e){
                System.out.println("Sai dinh dang. Nhap lai.");
            }
            catch(ScoreException e){
                System.out.println("Ban phai nhap gia tri duong. Nhap lai");
            }
        }
        return n;
    }
    
}
