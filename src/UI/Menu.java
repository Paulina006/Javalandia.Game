package UI;

import Excepcion.ArmaDuplicadaException;
import Excepcion.DatosIncompletosException;
import Excepcion.HabitanteDuplicadoException;
import Modelo.*;
import Repositorio.IRepositorio;
import Repositorio.RepositorioHabitantes;

import java.util.Scanner;

public class Menu {
    IRepositorio repositorio;
    ForjaReal forja;

    Scanner sc = new Scanner(System.in);


    public Menu() {
        this.repositorio = repositorio;
        this.forja = new ForjaReal();
    }

    public void menuCargar() {
        int opcion;
        char seguir = 's';
        do {
            System.out.println("--Menu--");
            System.out.println("Seleccione que desea");
            System.out.println("1. Forja Real");
            System.out.println("2. Habitante del reino");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    menuCargarForja();
                    break;
                case 2:

                    break;
            }
        }
    }

    public void menuCargarForja()
    {
        char seguir='s';
        int opcion;
        while(seguir=='s')
        {
            System.out.println("Ingrese nombre arma:");
            String arma = sc.nextLine();
            System.out.println("Ingrese categoria arma:");
            String categoria = sc.nextLine();
            System.out.println("Ingrese cantidad disponible:");
            int cantidad = sc.nextInt();
            sc.nextLine();
            System.out.println("Cuantos materiales quiere cargar?");
            int num=sc.nextInt();
            Arma a1=new Arma(arma,categoria,cantidad);
            for(int i=0;i<num;i++)
            {
                System.out.println("Ingrese material creacion:");
                String materialCreacion = sc.nextLine();
                a1.cargarMaterialCreacion(materialCreacion);
            }
            try
            {
                forja.registrar(a1);
            }catch (ArmaDuplicadaException e)
            {
                System.out.println(e.getMessage());
            }
            catch (DatosIncompletosException e1)
            {
                System.out.println(e1.getMessage());
            }

            System.out.println("¿Desea cargar otra arma?");
            seguir = sc.next().charAt(0);

        }
    }

    public void menuCargarHabitantes() {
        int opcion;
        char seguir = 's';

        do {
            System.out.println("--Menu--");
            System.out.println("1. Escudero");
            System.out.println("2. Hechicero");
            System.out.println("3. Noble");
            opcion = sc.nextInt();
            sc.nextLine();

            System.out.println("Ingrese el nombre:");
            String nombre = sc.next();
            System.out.println("Ingrese reino de procedencia:");
            String reinoProcedencia = sc.next();
            System.out.println("Ingrese id:");
            int id = sc.nextInt();
            System.out.println("Ingrese honorabilidad: (true-false)");
            String rta = sc.nextLine();
            boolean honorabilidad = true;
            if (rta.equals("true")) {
                honorabilidad = true;
            } else {
                honorabilidad = false;
            }
            switch (opcion) {
                case 1:

                    Escudero e1 = new Escudero(nombre, reinoProcedencia, id, honorabilidad);
                    System.out.println("Cuantas armas desea cargar?");
                    int cantArmas = sc.nextInt();
                    for (int i = 0; i < cantArmas; i++) {
                        System.out.println("Ingrese nombre del arma:");
                        String nombreArma = sc.nextLine();
                        IArma arma = forja.buscarNombre(nombreArma);
                        if (arma != null) {
                            e1.cargarListaArmas(arma);
                        } else {
                            System.out.println("Arma no encontrada en la forja");
                        }

                    }
                    try {
                        repositorio.registrar(e1);

                    } catch (Exception a1) {
                        System.out.println(a1.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Ingrese su artefacto magico:");
                    String artefactoMagico=sc.nextLine();

                    try
                    {
                        repositorio.registrar(new AprendizHechicero(nombre,reinoProcedencia,id,honorabilidad,artefactoMagico));

                    }catch (Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el privilegio real del noble:");
                    String privilegioReal=sc.nextLine();

                    try {
                        repositorio.registrar(new Noble(nombre,reinoProcedencia,id,honorabilidad,privilegioReal));
                    }catch (Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }

    }

    public void menuFinal() {
        int opcion;
        char seguir = 's';
        do {
            System.out.println("Seleccione una opcion");
            System.out.println("1. Registrar");
            System.out.println("2. Eliminar");
            System.out.println("3. Buscar");
            System.out.println("4. Listar");
            System.out.println("5. Contar");
            System.out.println("6. Salir");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    repositorio.registrar();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    seguir = 'n';
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
            if (opcion != 6) {
                System.out.println("Desea elegir otra opcion?");
                seguir = sc.next().charAt(0);
            }

        } while (seguir == 's');
    }
}
