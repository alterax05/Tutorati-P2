package es1;

import es1.flatland.*;

public class MainEs1 {

    public static void main (String[] args) {
        // Che tipo di polimorfismo stiamo usando qua?
        Lander[] abitanti = {
                new Linelander(),
                new Linelander(Linelander.Genere.RETTA),
                new Flatlander(Flatlander.Genere.POLIGONO, 4),
                new Flatlander(Flatlander.Genere.SEGMENTO,1000),
                new Flatlander(Flatlander.Genere.POLIGONO,5)
        };

        System.out.println("--------------reameDimensionale--------------");
        for(Lander lander: abitanti){
            lander.reameDimensionale();
        }

        System.out.println("--------------comapre--------------");
        System.out.println(abitanti[2].compare(abitanti[0]));
        System.out.println(abitanti[2].compare(abitanti[3]));

        System.out.println("--------------isGenitore--------------");

        // Il for ha un errore di, come lo potrete correggere?
		/*for(Lander lander: abitanti){
			System.out.println((abitanti[4]).isGenitore(lander));
		}*/
    }
}