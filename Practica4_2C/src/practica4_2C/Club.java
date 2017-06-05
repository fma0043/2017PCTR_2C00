package practica4_2C;

import java.util.ArrayList;

/**
 * Club.
 * 
 * @author Félix Movilla Alonso.
 */
public class Club {

	private int pelotasActuales;
	private int palosActuales;
	private boolean acceso;
	private static Club club;
	static ArrayList<Jugador> jugadores = new ArrayList<Jugador>();

	/**
	 * Constructor en el que inicializamos las variables.
	 */
	private Club(int numPelotasIniciales, int numPalosIniciales) {
		this.pelotasActuales = numPelotasIniciales;
		this.palosActuales = numPalosIniciales;
		this.acceso = false;
	}

	/**
	 * Método sincronizado reservar.
	 * 
	 * @param pelotas
	 * @param palos
	 * @throws InterruptedException
	 */

	public synchronized void reservar(int pelotas, int palos) throws InterruptedException {
		while (acceso) {
			wait();
		}
		acceso = true;
		while (pelotas > pelotasActuales || palos > palosActuales) {
			acceso = false;
			// System.err.println("no hay material para mi, esperando " +
			// pelotas+ "pelotas "+palos+" palos ");
			wait();
			acceso = true;
		}
		pelotasActuales = pelotasActuales - pelotas;
		palosActuales = palosActuales - palos;
		acceso = false;
		notifyAll();

	}

	/**
	 * Método sincronizado devolver.
	 * 
	 * @param pelotasActuales
	 * @param palosActuales
	 * @throws InterruptedException
	 */
	public synchronized void devolver(int pelotas, int palos) throws InterruptedException {
		while (acceso) {
			wait();
		}
		acceso = true;
		pelotasActuales = pelotasActuales + pelotas;
		palosActuales = palosActuales + palos;
		acceso = false;
		notifyAll();
	}


	/**
	 * Singleton Club.
	 * 
	 * @return club
	 */
	public static Club obtenerClub(int pelotas, int palos) {
		if (club == null) {
			club = new Club(pelotas, palos);
		}
		return club;
	}

	/**
	 * getJugadores.ArrayList de jugador para mostrar los jugadores.
	 * 
	 * @return jugadores
	 */
	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}

	/**
	 * setJugadores.método para añadir jugadores y diferenciarlos en expertos o
	 * novatos.
	 * 
	 * @param expertos
	 * @param novatos
	 * @param veces
	 */
	public void setJugadores(int expertos, int novatos, int veces) {
		boolean exp = false;
		for (int i = 1; i <= expertos + novatos; i++) {
			if (i <= expertos) {
				exp = true;
			} else {
				exp = false;
			}
			jugadores.add(new Jugador(i, exp, veces, club));
		}
	}

}
