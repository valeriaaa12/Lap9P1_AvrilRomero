/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab9p1_avrilromero;


/**
 *
 * @author rodge
 */
public class Libros {
  private String titulo;
  private String autor;
  private String genero;
  private int edad;
  
  public Libros(String tituloN,String autorN,String generoN,int edadN){
      this.titulo=tituloN;
      this.autor=autorN;
      this.genero=generoN;
      this.edad=edadN;
  }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
  
}
