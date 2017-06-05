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


	public void reservar(int pelotas, int palos) {
		// TODO Auto-generated method stub
		
	}

	public void devolver(int pelotasActuales, int palosActuales) {
		// TODO Auto-generated method stub
		
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


	public ArrayList<Jugador> getJugadores() {
		// TODO Auto-generated method stub
		return null;
	}



}
