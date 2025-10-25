package Soal1;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList<Dice> diceList = new LinkedList<>();

        int numDice = input.nextInt();

        for (int i = 0; i < numDice; i++) {
            diceList.add(new Dice());
        }

        int totalValue = 0;
        for (int i = 0; i < diceList.size(); i++) {
            int value = diceList.get(i).getValue();
            System.out.println("Dadu ke-" + (i + 1) + " bernilai " + value);
            totalValue += value;
        }

        System.out.println("Total nilai dadu keseluruhan " + totalValue);

        input.close();
    }
}