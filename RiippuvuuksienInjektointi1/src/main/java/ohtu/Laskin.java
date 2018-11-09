package ohtu;

import java.util.Scanner;

public class Laskin {

    private Scanner lukija;

    public Laskin() {
        lukija = new Scanner(System.in);
    }

    public void suorita(){
        int endLoop = -9999;
        while( true ) {
            System.out.println("luku 1: ");
            int luku1 = lukija.nextInt();
            if ( luku1==endLoop  ) return;

            System.out.println("luku 2: ");
            int luku2 = lukija.nextInt();
            if ( luku2==endLoop  ) return;

            int vastaus = laskeSumma(luku1, luku2);
            System.out.println("summa: "+ vastaus);
        }
    }

    private int laskeSumma(int luku1, int luku2) {
        return luku1+luku2;
    }

}
