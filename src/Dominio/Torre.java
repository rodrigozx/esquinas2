/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**
 *
 * @author rblanco
 */
public class Torre {
    
    private char color;
    private int cantidad;

    /* CONSTRUCTOR POR DEFECTO *************************************/
    public Torre() {
        this.cantidad = 0;
        this.color = ' ';
    }
    
    /* CONSTRUCTOR POR PARAMETROS *************************************/
    public Torre(int laCantidad, char elColor) {
        this.cantidad = 0;
        this.color = ' ';
    }

    /* GETS Y SETS *************************************/
    public char getColor() {
        return color;
    }

    public void setColor(char color) {
        this.color = color;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}
