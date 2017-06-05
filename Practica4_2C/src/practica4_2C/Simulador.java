package practica4_2C;

import java.util.ArrayList;

/**
 * Simulador donde probamos el proyecto.
 * 
 * @author Félix Movilla Alonso.
 */
public class Simulador {

	private static final int NUM_EXPERTOS = 3;
	private static final int NUM_NOVATOS = 3;
	private static final int NUM_PELOTAS = 10;
	private static final int NUM_PALOS = 10;
	private static final int NUM_VUELTAS = 2;

	/**
	 * Metodo main.
	 * 
	 * @param args
	 *            args.
	 * 
	 */
	public static void main(String[] args) {

		Club club = Club.obtenerClub(NUM_PELOTAS, NUM_PALOS);

		ArrayList<Thread> hilos = new ArrayList<Thread>();

		ArrayList<Jugador> jugadores = club.getJugadores();

		for (Jugador j : jugadores) {
			hilos.add(new Thread(j));
		}

		for (Thread h : hilos) {
			h.start();
		}
	}

}
