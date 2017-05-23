package Dominio;

import java.util.Comparator;

/*
 Orden de ordenación:
 Partidas Ganadas
 Partidas Perdidas
 */
public class OrdenarJugadoresPorRanking implements Comparator<Jugador> {

    @Override
    public int compare(Jugador j1, Jugador j2) {
        int resultado = j2.getPartidas()[0] - j1.getPartidas()[0];

        if (resultado == 0) {
            resultado = j2.getPartidas()[1] - j1.getPartidas()[1];

            //Si tienen la misma cantidad de partidas ganadas y perdidas
            //se ordena por alias ascendente;
            if (resultado == 0) {
                resultado = j1.getAlias().compareTo(j2.getAlias());
            }
        }
        return resultado;
    }
}
