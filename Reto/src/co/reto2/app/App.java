package co.reto2.app;

import co.reto2.dominio.Juego;

import javax.swing.*;
import java.util.Arrays;

public class App {
    private static final ImageIcon icono = new ImageIcon("C:\\POO\\POO-reto2.png");
    private static final int OPC_JUGAR = 0;
    private static final int OPC_PUNTAJE = 1;
    private static final int OPC_INSTRUCCIONES = 2;
    private static final int OPC_CAMBIAR_NOMBRE = 3;
    public static void main(String[] args) {
        Juego juego = new Juego("PIEDRA, PAPEL O TIJERA");

        while(true){
            int opcion = JOptionPane.showOptionDialog(null, "PIEDRA, PAPEL O TIJERA", "Juego ", 0, 0, icono,
                    Arrays.asList("Jugar", "Puntaje", "Instrucciones", "Cambiar Nombre").toArray(), null);
            switch (opcion) {

                case OPC_JUGAR:
                    if(juego.getNombreJugador() == null){
                        juego.setNombreJugador(ingresarNombre());
                    }
                    JOptionPane.showMessageDialog(null,"Bienvenido "+juego.getNombreJugador());
                    int JugadaPC = juego.JugadaPC();
                    int jugadaElegidaJugador = JOptionPane.showOptionDialog(null,"Seleccione: ","Juego",0,JOptionPane.QUESTION_MESSAGE,icono,Arrays.asList("PIEDRA","PAPEL","TIJERA").toArray(),null);
                    JOptionPane.showMessageDialog(null,juego.getNombreJugador()+"Seleccionó: \n"+jugada(jugadaElegidaJugador)+"\n"+"PC seleccionó: \n"+jugada(JugadaPC));
                    String mostrarResultado = juego.Jugar(jugadaElegidaJugador,JugadaPC);
                    JOptionPane.showMessageDialog(null,mostrarResultado);
                    break;

                case OPC_PUNTAJE:
                    if(juego.getNombreJugador() == null){
                        juego.setNombreJugador(ingresarNombre());
                    }
                    JOptionPane.showMessageDialog(null,"¡PUNTAJES! \n "+juego.getNombreJugador()+": "+juego.getGanadasJugador()+"\n PC: "+juego.getGanadasPC()+"\n Empates: "+juego.getEmpate() );
                    break;

                case OPC_INSTRUCCIONES:
                    JOptionPane.showMessageDialog(null,"INSTRUCCIONES\n\n Las reglas del piedra, papel o tijera son muy sencillas \n en este juego solo hay que tener 3 cosas muy claras:\n " +
                            " 1-)La PIEDRA que vence a la tijera rompiéndola \n 2-)La TIJERA que vence al papel cortándolo\n 3-)El PAPEL que vence a la piedra envolviéndola \n  " +
                            "Tambien debes Recordar que si tu jugada es la misma que la de tu oponente, quedarán en EMPATE, en tal caso deveras volver a jugar hasta que se decida un ganador...\n\n ¡BUENA SUERTE!");
                    break;
                case OPC_CAMBIAR_NOMBRE:
                    juego.setNombreJugador(ingresarNombre());
                    juego.setGanadasJugador(0);
                    juego.setGanadasPC(0);
                    juego.setEmpate(0);
                    break;
                case JOptionPane.CLOSED_OPTION:
                    return;
            }
        }
    }

    public static String ingresarNombre(){
        String nombreJugador;

        do {
            nombreJugador = JOptionPane.showInputDialog(null,"Ingrese el nombre: ");
        }while (nombreJugador == null || nombreJugador.trim().isEmpty());

        return nombreJugador;
    }

    public static String jugada(int jugada){
        if(jugada == 0){
            return "PIEDRA";
        }else if(jugada == 1){
            return "PAPEL";
        }else{
            return "TIJERA";
        }
    }
}
