package practica4_2C;


import java.lang.Runnable;

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

	@Override
	public void run() {
		
		
	}
}
