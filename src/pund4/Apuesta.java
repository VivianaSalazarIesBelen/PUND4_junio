/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pund4;

/**
 * La clase Apuesta representa una apuesta en un partido de fútbol, con información sobre los goles
 * marcados por el equipo local y visitante, así como el monto apostado y el saldo disponible.
 */
public class Apuesta {

    private int dinero_disp;
    private int goles_local;
    private int goles_visitante;
    private int apostado;

    /**
     * Obtiene la cantidad de goles previstos para el equipo local.
     *
     * @return la cantidad de goles del equipo local
     */
    public int getGoles_local() {
        return goles_local;
    }

    /**
     * Establece la cantidad de goles previstos para el equipo local.
     *
     * @param goles_local la cantidad de goles del equipo local
     */
    public void setGoles_local(int goles_local) {
        this.goles_local = goles_local;
    }

    /**
     * Obtiene la cantidad de goles previstos para el equipo visitante.
     *
     * @return la cantidad de goles del equipo visitante
     */
    public int getGoles_visitante() {
        return goles_visitante;
    }

    /**
     * Establece la cantidad de goles previstos para el equipo visitante.
     *
     * @param goles_visitante la cantidad de goles del equipo visitante
     */
    public void setGoles_visitante(int goles_visitante) {
        this.goles_visitante = goles_visitante;
    }

    /**
     * Obtiene la cantidad de dinero apostado.
     *
     * @return la cantidad de dinero apostado
     */
    public int getApostado() {
        return apostado;
    }

    /**
     * Establece la cantidad de dinero apostado.
     *
     * @param apostado la cantidad de dinero apostado
     */
    public void setApostado(int apostado) {
        this.apostado = apostado;
    }

    /*Contructor por defecto*/
    public Apuesta() {
    }

    /*Contructor con parámetros*/
    public Apuesta(int dinero_disp, int goles_local, int goles_visitante) {
        this.dinero_disp = dinero_disp;
        this.goles_local = goles_local;
        this.goles_visitante = goles_visitante;
        this.apostado = 0;
    }
    /*Método para obtener el valor del atributo dinero_disp*/

    public int getDinero_disp() {
        return dinero_disp;
    }
    /*Método para modificar el valor del atributo dinero_disp*/

    public void setDinero_disp(int dinero_disp) {
        this.dinero_disp = dinero_disp;
    }

    /*Método para apostar.
     * Permite elegir la cantidad a apostar, no pudiendo ser inferior a 1 ni superior a tu saldo disponible
     * Este método será probado con JUnit
     */
    public void apostar(int dinero) throws Exception {
        if (dinero <= 0) {
            throw new Exception("No se puede apostar menos de 1€");
        }

        if (dinero > dinero_disp) {
            throw new Exception("No se puede apostar mas de lo que tienes");
        }
        {
            dinero_disp = dinero - dinero_disp;
            setApostado(dinero);
        }
    }
    /*Método que comprueba si se ha acertado el resultado del partido
     * En caso de que lo haya acertado devuelve true. Chequea que no se metan menos de 0 goles
     * 
     */

    public boolean comprobar_resultado(int local, int visitante) throws Exception {
        boolean acertado = false;
        if ((local < 0) || (visitante) < 0) {
            throw new Exception("Un equipo no puede meter menos de 0 goles, por malo que sea");
        }

        if (getGoles_local() == local && getGoles_visitante() == visitante) {
            acertado = true;
        }
        return acertado;
    }
    /* Método para cobrar la apuesta.
     * Comprueba que se acertó el resultado y, en ese caso, añade el valor apostado multiplicado por 10
     * al saldo disponible
     * Este método se va a probar con Junit
     */

    void cobrar_apuesta(int cantidad_goles_local, int cantidad_goles_visit) throws Exception {

        if (comprobar_resultado(cantidad_goles_local, cantidad_goles_visit) == false) {
            throw new Exception("No se puede cobrar una apuesta no acertada");
        }
        dinero_disp = dinero_disp * 10;

    }
}