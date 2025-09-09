import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int ileKosci;
        String czyPowtorzyc;

        do {
            ileKosci = 0;
            while (ileKosci < 3 || ileKosci > 10) {
                System.out.println("Ile kostek chcesz rzucić?(3 - 10)");
                ileKosci = scanner.nextInt();
                scanner.nextLine();
            }
            int[] tablicaKosci = rzutKoscmi(ileKosci);
            for (int i = 0; i < tablicaKosci.length; i++){
                System.out.println("Kość " + (i+1) + ": " + tablicaKosci[i]);
            }
            int sumaPunktow = liczPunkty(tablicaKosci);
            System.out.println("Liczba uzyskanych punktów: " + sumaPunktow);

            System.out.println("Jeszcze raz? (t/n)");
            czyPowtorzyc = scanner.nextLine();
            if (czyPowtorzyc.equals("t")){}
            else break;

        }while(true);

    }
    public static int[] rzutKoscmi(int ileKosci){
        Random random = new Random();
        int[] tablicaKosci = new int[ileKosci];
        for (int i = 0; i < tablicaKosci.length; i++){
            tablicaKosci[i] = random.nextInt(6) + 1;
        }
        return tablicaKosci;
    }
    public static int liczPunkty(int[] tablicaKosci){
        int suma = 0;
        for (int i = 0; i < tablicaKosci.length; i++){
            int ileRazyWystepuje = 0;
            for(int j = 0; j < tablicaKosci.length; j++){
                if (tablicaKosci[i] == tablicaKosci[j]){
                    ileRazyWystepuje++;
                }
            }
            if (ileRazyWystepuje > 1){
                suma += tablicaKosci[i];
            }
        }
        return suma;
    }
}