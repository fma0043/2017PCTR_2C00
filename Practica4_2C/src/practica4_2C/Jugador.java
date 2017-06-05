package practica4_2C;

import java.lang.Runnable;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Clase Hilo, que implementa la interfaz Runnable.
 * 
 * @author Félix Movilla Alonso.
 * 
 */
public class Jugador implements Runnable {

	private int vueltas, pelotasActuales, palosActuales;
	String ident;
	private Club club;
	private boolean experto;

	/**
	 * Constructor de la clase.
	 * 
	 * @param int
	 *            id.
	 * @param boolean
	 *            experto.
	 * @param int
	 *            numVueltas.
	 * @param Club
	 *            elClub.
	 */
	public Jugador(int id, boolean experto, int numVueltas, Club elClub) {
		ident = "";
		ident += id;
		this.vueltas = numVueltas;
		this.club = elClub;
		this.palosActuales = 0;
		this.pelotasActuales = 0;
		this.experto = experto;
		if (experto) {
			ident += "+";
		} else {
			ident += "-";
		}
	}
	
	/**
	 * Metodo run para los hilos de entrada.
	 */
	@Override
	public void run() {
		int pelotas, palos, i, tiempo;
		if (experto) {
			pelotas = 1;
			palos = ThreadLocalRandom.current().nextInt(2, 6);
		} else {
			pelotas = ThreadLocalRandom.current().nextInt(2, 6);
			palos = 2;
		}
		for (i = 0; i < vueltas; i++) {
			System.out.println(this.ident + "[" + pelotas + "," + palos + "] reserva y tengo " + pelotasActuales + " y "
					+ palosActuales);
			//club.reservar(pelotas, palos);
			pelotasActuales += pelotas;
			palosActuales += palos;

			System.out.println(this.ident + "[" + pelotasActuales + "," + palosActuales + "] juega y tengo "
					+ pelotasActuales + " y " + palosActuales);
			tiempo = ThreadLocalRandom.current().nextInt(1, 1000);
			try {
				Thread.sleep(tiempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println(this.ident + "[" + pelotasActuales + "," + palosActuales + "] devuelve y tengo "
					+ pelotasActuales + " y " + palosActuales);
			//club.devolver(pelotasActuales, palosActuales);
			pelotasActuales -= pelotasActuales;
			palosActuales -= palosActuales;

			System.out.println(this.ident + "[" + pelotas + "," + palos + "] descansa y tengo " + pelotasActuales
					+ " y " + palosActuales);
			tiempo = ThreadLocalRandom.current().nextInt(1, 1000);
			try {
				Thread.sleep(tiempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
