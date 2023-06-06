package com.salihakbas.saytahminoyunu;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Random rand = new Random();
        int randomNumber = rand.nextInt(100);

        Scanner input = new Scanner(System.in);
        int right = 0;
        int selectedNumber;
        int[] wrong = new int[5];
        boolean isWrong = false;
        boolean isWin = false;


        while(right < 5) {
            System.out.println("=================");
            System.out.print("Lütfen tahmininizi giriniz: ");
            selectedNumber = input.nextInt();

            if(selectedNumber < 0 || selectedNumber > 99) {
                System.out.println("Lütfen 1-99 arası bir sayı giriniz.");
                if(isWrong) {
                    right++;
                    System.out.println("Çok fazla hatalı giriş yaptınız, kalan hakkınız: " + (5-right));
                }else{
                    isWrong = true;
                    System.out.println("Bir hatalı giriş daha yaptığınızda hakkınızdan düşülecektir!");
                }
                continue;
            }
            if(selectedNumber == randomNumber) {
                System.out.println("Tebrikler oyunu kazandınız, tahmin edilen sayı: " + randomNumber);
                isWin = true;
                break;
            }else{
                System.out.println("Hatalı tahmin yaptınız");
                if(selectedNumber > randomNumber) {
                    System.out.println(selectedNumber + " sayısı gizli sayıdan büyük");
                }else{
                    System.out.println(selectedNumber +" sayısı gizli sayıdan küçük");
                }
                wrong[right++] = selectedNumber;
                System.out.println("Kalan hakkınız: " + (5 - right));
            }
        }
        if(!isWin) {
            System.out.println("Kaybettiniz ! ");
            System.out.println("Rastgele üretilen sayı: " + randomNumber);
            if(!isWrong) {
                System.out.println("Tahminleriniz: " + Arrays.toString(wrong));
            }

        }
    }
}
