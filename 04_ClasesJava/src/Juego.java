import java.util.Scanner;

public class Juego {
	// Declaración de atributos de la clase
	public String nombreJugador1, nombreJugador2;
	public boolean juegoFinalizado;
	public int numeroDeTurnos;
	public boolean esTurnoJugador1;
	public char[] tablero; 
	public final static int JUEGO_PAREJA = 1;
	public final static int JUEGO_MAQUINA = 2;
	public Scanner sc = new Scanner(System.in);
	
	// 1 > jugar contra otro jugador, 2 > jugar contra la máquina
	public int tipoJuego;
	// | 0 | 1  | 2 | 3 | 4  | 5 | 6 | 7 | 8
	// | X | O  |   | X | O  | X |   |   | 
	
	// Definición de constructores
	public Juego() {
		nombreJugador1 = "";
		nombreJugador2 = "";
		juegoFinalizado = false;
		numeroDeTurnos = 0;
		esTurnoJugador1 = true;
		tablero = new char[9];
		tipoJuego = 1;
		sc.useDelimiter("[:\\s]");
	}
	
	// En este constructor se utilizan 2 parámetros
	// para definir los nombres de los 2 jugadores
	public Juego(String nombreJugador1, String nombreJugador2) {
		this.nombreJugador1 = nombreJugador1;
		this.nombreJugador2 = nombreJugador2;
		juegoFinalizado = false;
		numeroDeTurnos = 0;
		esTurnoJugador1 = true;
		tablero = new char[9];
		tipoJuego = 1;
		sc.useDelimiter("[:\\s]");
		
		System.out.println("Se inicia partida "+nombreJugador1+" VS "+nombreJugador2);
		
	}
	
	// Este constructor se utiliza cuando sólo va a jugar un
	// jugador, ya que se recibe por parámetro un único nombre
	public Juego(String nombreJugador1) {
		this.nombreJugador1 = nombreJugador1;
		this.nombreJugador2 = "";
		juegoFinalizado = false;
		numeroDeTurnos = 0;
		esTurnoJugador1 = true;
		tablero = new char[9];
		tipoJuego = 2;
		sc.useDelimiter("[:\\s]");
		
		System.out.println("Se inicia partida "+nombreJugador1+" VS "+"la MÁQUINA");
	}
	
	// Declaración e implementación de los métodos de la clase
	
	// Función para establecer el turno del jugador siguiente
	public void cambiarTurnoJugador(int casillaJugada) {
		
		if(esTurnoJugador1) {
			tablero[casillaJugada] = 'X';
			esTurnoJugador1 = false;
		} else {
			tablero[casillaJugada] = 'O';
			esTurnoJugador1 = true;
		}
		
		contadorTurnos();
		mostrarTablero();
		siguienteTurno();
	}
	
	private void mostrarTablero() {
		System.out.println("*** 3 en LÍNEA ***");
		
		for(int i=0; i<tablero.length; i++) {
			int numeroCasilla = i+1;
			if(tablero[i]=='X'){
				System.out.print(" X ");
			} else if(tablero[i]=='O') {
				System.out.print(" O ");
			} else {
				System.out.print(" _ ");
			}
			
			System.out.print("("+numeroCasilla+")");
			
			if((i+1)%3==0) {
				System.out.println("");
			}
		}
		
		System.out.println("******************");
		
	}

	// Función para contabilizar el número de turnos de una jugada
	public void contadorTurnos() {
		numeroDeTurnos++;
	}
	
	// Función que determina si en la jugada actual existe una solución
	// de 3 en Línea
	// Devuelve true en caso de que exista y false en casa de que no.
	public boolean existeSolucion() {
		boolean enc = false;
		
		// Búsqueda de posible solución.
		
		return enc;
	}
	
	public void siguienteTurno() {
		if(tipoJuego==JUEGO_MAQUINA) {
			if(esTurnoJugador1) {
				System.out.println("Es el turno de "+nombreJugador1);
			} else {
				System.out.println("Es el turno de la Máquina");
			}
		} else if(tipoJuego==JUEGO_PAREJA) {
			if(esTurnoJugador1) {
				System.out.println("Es el turno de "+nombreJugador1);
			} else {
				System.out.println("Es el turno de "+nombreJugador2);
			}
			
			mostrarTablero();
			
			boolean jugadaCorrecta = false;
			while(!jugadaCorrecta) {
				System.out.print("Indica del 1 al 9 qué casilla deseas ocupar: ");
				int casilla = Integer.parseInt(sc.next());
	
				if(esCasillaLibre(casilla-1)) {
					jugadaCorrecta = true;			
					cambiarTurnoJugador(casilla-1);
				} else {
					System.out.print("ATENCIÓN! La casilla seleccionada está ocupada");
				}
			}
		}
		
		
	}
	
	public boolean esCasillaLibre(int casillaSeleccionada) {
		boolean casillaLibre = false;
		
		/*for(int i=0; i<tablero.length; i++) {
			if(tablero[i]!='X' && tablero[i]!='O') {
				
			}
		}*/
		
		if(tablero[casillaSeleccionada]!='X' && tablero[casillaSeleccionada]!='O') {
			casillaLibre = true;
		}
		
		return casillaLibre;
	}
	
	
}
