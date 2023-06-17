/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab9p1_avrilromero;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author rodge
 */
public class Lab9P1_AvrilRomero {

    /**
     * @param args the command line arguments
     */
    static Scanner leer = new Scanner(System.in);
    static Scanner sc = new Scanner(System.in);
    static int cont1 = 0;//validar si entro en ingresar libros

    public static void main(String[] args) {
        ArrayList<Libros> libros = new ArrayList<>();
        boolean seguir = true;
        while (seguir) {
            System.out.println("1.Libros y mas Libros REMASTERED");
            System.out.println("2.Salir");
            System.out.println("Ingrese una opcion: ");
            int op = leer.nextInt();
            switch (op) {
                case 1: {
                    boolean seguir2 = true;
                    while (seguir2) {//menu 1
                        System.out.println("Elija una opcion: ");
                        System.out.println(" 1.Agregar Libros");
                        System.out.println(" 2.Lista de Libros");
                        System.out.println(" 3.Modificar Libro");
                        System.out.println(" 4.Eliminar Libro");
                        System.out.println(" 5.Buscar Libro por titulo");
                        System.out.println(" 6.Buscar Libros segun autor");
                        System.out.println(" 7.Busqueda con filtro de genero");
                        System.out.println(" 8.Salir");
                        System.out.println("Opcion ingresada: ");
                        int op1 = leer.nextInt();
                        switch (op1) {//menu 2
                            case 1: {
                                AgregarLibro(libros);//metodo para agregar libros
                                cont1++;
                                break;
                            }
                            case 2: {
                                if (cont1 >= 1) {//valida si entro al case 1
                                    if (libros.size() == 0) {
                                        System.out.println("No hay libros disponibles");
                                    } else {
                                        System.out.println("Libros Disponibles: ");
                                        ImprimirLibros(libros);//metodo para imprimir los libros
                                    }
                                } else {
                                    System.out.println("Debe ingresar libros al librero primero");
                                }
                            }
                            break;
                            case 3: {
                                if (cont1 >= 1) {
                                    System.out.println("Ha ingresado la opcion de modificar libros,elija el libro que modificara: ");
                                    ImprimirLibros(libros);//imprime el librero
                                    System.out.println("Libro seleccionado ");
                                    int numlibro = leer.nextInt();
                                    libros = ModificarLibros(libros, numlibro);//metodo para modificar los libros
                                } else {
                                    System.out.println("Debe ingresar libros al librero primero");
                                }
                            }
                            break;
                            case 4: {
                                if (cont1 >= 1) {
                                    System.out.println("Ha ingresado la opcion de eliminar libros,elija el libro que eliminara: ");
                                    ImprimirLibros(libros);
                                    System.out.println("Libro seleccionado ");
                                    int numlibro = leer.nextInt();
                                    libros = EliminarLibros(libros, numlibro);//metodo para eliminar los libros
                                } else {
                                    System.out.println("Debe ingresar libros al librero primero");
                                }

                            }
                            break;
                            case 5: {
                                if (cont1 >= 1) {
                                    System.out.println("Ingrese el titulo del libro a buscar: ");
                                    String titulo = sc.nextLine();
                                    libros = BuscarTitulo(libros, titulo);//metodo para buscar el titulo
                                } else {
                                    System.out.println("Debe ingresar libros al librero primero");
                                }
                            }
                            break;
                            case 6: {
                                if (cont1 >= 1) {
                                    System.out.println("Ingrese el autor del libro a buscar: ");
                                    String autor = sc.nextLine();
                                    libros = BuscarAutor(libros, autor);
                                } else {
                                    System.out.println("Debe ingresar libros al librero primero");
                                }
                            }
                            break;
                            case 7: {
                                if (cont1 >= 1) {
                                    System.out.println("Ingrese el genero del libro a buscar: ");
                                    String genero = sc.nextLine();
                                    libros = BuscarGenero(libros, genero);
                                } else {
                                    System.out.println("Debe ingresar libros al librero primero");
                                }
                            }
                            break;
                            case 8: {
                                seguir2 = false;
                                break;
                            }

                            default:
                                System.out.println("Opcion incorrecta");
                                break;

                        }// fin switch
                    }
                }//fin case 1
                break;
                case 2: {
                    seguir = false;
                }
                break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        }
    }//fin main

    public static ArrayList<Libros> AgregarLibro(ArrayList<Libros> librito) {
        boolean valid = false;
        System.out.println("Ha elegido la opcion para agregar un libro, por favor aporte la informacion solicitada");
        System.out.println("Titulo: ");
        String titulo = sc.nextLine();
        System.out.println("Autor: ");
        String autor = sc.nextLine();
        System.out.println("Genero: ");
        String genero = sc.nextLine();
        System.out.println("Edad minima: ");
        int edad = leer.nextInt();
        if (edad < 0) {
            System.out.println("La edad debe ser mayor a 0");
            valid = true;
        }
        if (valid == false) {
            Libros libreria = new Libros(titulo, autor, genero, edad);
            librito.add(libreria);
            System.out.println("Libro agregado exitosamente! ");
        }
        return librito;
    }

    public static void ImprimirLibros(ArrayList<Libros> librito) {
        for (int i = 0; i < librito.size(); i++) {
            System.out.println("Libro " + (i + 1));
            System.out.println("Titulo: " + librito.get(i).getTitulo());
            System.out.println("Autor: " + librito.get(i).getAutor());
            System.out.println("Genero: " + librito.get(i).getGenero());
            System.out.println("Edad minima: " + librito.get(i).getEdad());
            System.out.println("");
        }
    }

    public static void ImprimirLibros2(ArrayList<Libros> librito, int i) {
        System.out.println("Libro " + (i + 1));
        System.out.println("Titulo: " + librito.get(i).getTitulo());
        System.out.println("Autor: " + librito.get(i).getAutor());
        System.out.println("Genero: " + librito.get(i).getGenero());
        System.out.println("Edad minima: " + librito.get(i).getEdad());
        System.out.println("");
    }

    public static ArrayList<Libros> ModificarLibros(ArrayList<Libros> libritos, int libronum) {
        ArrayList<Libros> Libreria = libritos;
        int cont = 0;
        for (int i = 0; i < Libreria.size(); i++) {
            if (libronum - 1 == i) {
                System.out.println("Ha seleccionado el libro " + libritos.get(i).getTitulo() + " , que tributo desea modificar ?");
                System.out.println("1.Titulo");
                System.out.println("2.Autor");
                System.out.println("3.Genero");
                System.out.println("4.Edad minima");
                System.out.println("Opcion Ingresada: ");
                int op2 = leer.nextInt();
                switch (op2) {
                    case 1: {
                        System.out.println("Modificara el Titulo del libro, ingrese un nuevo titulo: ");
                        Libreria.get(i).setTitulo(sc.nextLine());
                        System.out.println("Libro modificado exitosamente!");
                    }
                    break;
                    case 2: {
                        System.out.println("Modificara el Autor del libro, ingrese un nuevo autor: ");
                        Libreria.get(i).setAutor(sc.nextLine());
                        System.out.println("Libro modificado exitosamente!");
                    }
                    break;
                    case 3: {
                        System.out.println("Modificara el Genero del libro, ingrese un nuevo genero: ");
                        Libreria.get(i).setGenero(sc.nextLine());
                        System.out.println("Libro modificado exitosamente!");
                    }
                    break;
                    case 4: {
                        System.out.println("Modificara el Edad Minima del libro, ingrese una nueva edad: ");
                        int edad = leer.nextInt();
                        boolean valid = false;
                        if (edad < 0) {
                            System.out.println("La edad debe ser mayor a 0");
                            valid = true;
                        }
                        if (valid == false) {
                            Libreria.get(i).setEdad(edad);
                            System.out.println("Libro modificado exitosamente!");
                        }

                    }
                    break;

                    default:
                        System.out.println("Opcion Ingresada Incorrecta");
                        break;
                }

            } else {
                cont++;
            }
            if (cont >= Libreria.size()) {
                System.out.println("El libro no se encuentra en la libreria");
            }

        }

        return Libreria;
    }

    public static ArrayList<Libros> EliminarLibros(ArrayList<Libros> libritos, int libronum) {
        boolean found = false;
        for (int i = 0; i < libritos.size(); i++) {
            if (libronum - 1 == i) {
                System.out.println("Ha eliminado el libro: " + libritos.get(i).getTitulo());
                libritos.remove(i);
                found = true;
                break;
            }

        }
        if (!found) {
            System.out.println("El libro no se encuentra en la libreria");
        }
        return libritos;
    }

    public static ArrayList<Libros> BuscarTitulo(ArrayList<Libros> libritos, String titulo) {
        ArrayList<Libros> Libreria = libritos;
        int cont = 0;
        for (int i = 0; i < Libreria.size(); i++) {
            if (titulo.equalsIgnoreCase(libritos.get(i).getTitulo())) {
                System.out.println("Libros con titulo: " + titulo);
                ImprimirLibros2(libritos, i);
            } else {
                cont++;
            }
        }
        if (cont >= Libreria.size()) {
            System.out.println("El libro no se encuentra en la libreria");
        }
        return Libreria;
    }

    public static ArrayList<Libros> BuscarAutor(ArrayList<Libros> libritos, String autor) {
        ArrayList<Libros> Libreria = libritos;
        int cont = 0;
        for (int i = 0; i < Libreria.size(); i++) {
            if (autor.equalsIgnoreCase(libritos.get(i).getAutor())) {
                System.out.println("Libros con el autor: " + autor);
                ImprimirLibros2(libritos, i);
            } else {
                cont++;
            }
        }
        if (cont >= Libreria.size()) {
            System.out.println("El libro no se encuentra en la libreria");
        }
        return Libreria;
    }

    public static ArrayList<Libros> BuscarGenero(ArrayList<Libros> libritos, String genero) {
        ArrayList<Libros> Libreria = libritos;
        int cont = 0;
        for (int i = 0; i < Libreria.size(); i++) {
            if (genero.equalsIgnoreCase(libritos.get(i).getGenero())) {
                System.out.println("Libros con el genero de: " + genero);
                ImprimirLibros2(libritos, i);
            } else {
                cont++;
            }
        }
        if (cont >= Libreria.size()) {
            System.out.println("El libro no se encuentra en la libreria");
        }
        return Libreria;
    }

}//fin clase
