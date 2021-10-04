package co.reto2.dominio;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class Juego {
    private String nombreJugador;
    private int ganadasJugador;
    private int ganadasPC;
    private int empate;
    private String Njuego;
   /* public String jugadorPC;
    public String jugador;*/

    public static final int PIEDRA = 0;
    public static final int PAPEL = 1;
    public static final int TIJERA = 2;
    public static final List<Integer> OPCION = Arrays.asList(PIEDRA,PAPEL,TIJERA);

    public Juego(String Njuego) {
        this.Njuego =Njuego;
    }

    public int JugadaPC() {
        int respPC = (int) (Math.random() * 2 + 1);
        return respPC;
    }

    public String Jugar(int jugadaJugador, int JugadaPC) {
        if (jugadaJugador == PIEDRA && JugadaPC == TIJERA) {
            ganadasJugador++;
            return "Ganaste "+getNombreJugador();
        } else if (jugadaJugador == PAPEL && JugadaPC == PIEDRA) {
            ganadasJugador++;
            return "Ganaste "+getNombreJugador();
        } else if (jugadaJugador == TIJERA && JugadaPC == PAPEL) {
            ganadasJugador++;
            return "Ganaste "+getNombreJugador();
        } else if(jugadaJugador == JugadaPC){
            empate++;
            return "EMPATE!";
        }else {
            ganadasPC++;
            return "GANA PC";
        }
    }

    //getter´s a setter´s --> Reiniciar puntajes de los jugadores

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public int getGanadasJugador() {
        return ganadasJugador;
    }

    public void setGanadasJugador(int ganadasJugador) {
        this.ganadasJugador = ganadasJugador;
    }

    public int getGanadasPC() {
        return ganadasPC;
    }

    public void setGanadasPC(int ganadasPC) {
        this.ganadasPC = ganadasPC;
    }

    public int getEmpate() {
        return empate;
    }

    public void setEmpate(int empate) {
        this.empate = empate;
    }
}

