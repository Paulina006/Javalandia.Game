package UI;

import Excepcion.*;
import Modelo.*;
import Repositorio.IRepositorio;
import Repositorio.RepositorioHabitantes;

import java.util.Scanner;

public class Menu {
    private IRepositorio repositorio;
    private ForjaReal forja;
    private ArchivoBibliotecaReal archivoBibliotecaReal;
    private final String archivo="armasForjadas";

    Scanner sc = new Scanner(System.in);


    public Menu() {
        this.repositorio = new RepositorioHabitantes();
        this.forja = new ForjaReal();
        this.archivoBibliotecaReal = new ArchivoBibliotecaReal();
    }

    public void menuCargarForja()
    {
        char seguir='s';
        int opcion=0;
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
            sc.nextLine();
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
            System.out.println("Habitante a seleccionar...");
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
                default:
                    System.out.println("Error. Opcion no valida");
            }
            System.out.println("¿Desea elegir otro habitante?");
            seguir = sc.next().charAt(0);

        }while(seguir=='s');

    }
    public void elegirRegistrar() {
        int opcion;
        char seguir = 's';
        do {

            System.out.println("Seleccione que desea cargar");
            System.out.println("1. Forja Real");
            System.out.println("2. Habitante del reino");
            System.out.println("3. Salir");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    menuCargarForja();
                    break;
                case 2:
                    menuCargarHabitantes();
                    break;
                case 3:
                    seguir='n';
                    break;
                default:
                    System.out.println("Error. Opcion no valida");
            }
            if(opcion!=3)
            {
                System.out.println("Desea cargar otro?");
                seguir = sc.next().charAt(0);
            }
        }while(seguir=='s' && opcion!=3);
    }

    public void elegirEliminar()
    {
        int opcion;
        char seguir='s';

        do {
            System.out.println("Ingrese que desea eliminar");
            System.out.println("1. Forja Real");
            System.out.println("2. Habitante del reino");
            System.out.println("3. Salir");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese nombre del arma a eliminar:");
                    String nombre=sc.nextLine();
                    try
                    {
                        boolean encontrado=forja.eliminar(nombre);
                        if(encontrado==true)
                        {
                            System.out.println("Arma eliminada en la forja");
                        }
                    }catch (ArmaNoEncontradaException e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Ingrese id del habitante a eliminar:");
                    int id=sc.nextInt();
                    sc.nextLine();
                    try
                    {
                       boolean encontrado = repositorio.eliminar(id);
                        if(encontrado==true)
                        {
                            System.out.println("Habitante eliminado");
                        }
                    }catch (Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    seguir='n';
                    break;
                default:
                    System.out.println("Error. Opcion no valida");

            }
            if(opcion!=3)
            {
                System.out.println("Desea elegir otro?");
                seguir = sc.next().charAt(0);
            }
        }while(seguir=='s' && opcion!=3);
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
            System.out.println("6. Guardar armas en JSON");
            System.out.println("7. Mostrar archivo JSON");
            System.out.println("8. Salir");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    elegirRegistrar();
                    break;
                case 2:
                    elegirEliminar();
                    break;
                case 3:
                    elegirBuscar();
                    break;
                case 4:
                    elegirMostrar();
                    break;
                case 5:
                    elegirContar();
                    break;
                case 6:
                    archivoBibliotecaReal.objetoAjson(forja);
                    archivoBibliotecaReal.escribirArchivo(archivo);
                    break;
                case 7:
                    String contenidoArchivo=archivoBibliotecaReal.mostrarArchivo(archivo);
                    System.out.println(contenidoArchivo);
                    break;
                case 8:
                    seguir = 'n';
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
            if (opcion != 8) {
                System.out.println("Desea elegir otra opcion?");
                seguir = sc.next().charAt(0);
            }

        } while (seguir == 's');
    }

    private void elegirMostrar() {
        Scanner sc = new Scanner(System.in);
        char seguir = 's';
        while (seguir == 's') {
            System.out.println("Que desea mostrar");
            System.out.println("1. Habitantes");
            System.out.println("2. Forja real");
            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println(repositorio.listar());
                    break;
                case 2:
                    System.out.println(forja.listar());
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
            System.out.println("quiere mostrar otra opcion? s-n");
            seguir = sc.next().charAt(0);
        }

    }

    private void elegirContar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Que desea contar");
        System.out.println("1. Habitantes");
        System.out.println("2. Forja real");
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                int cant = repositorio.contar();
                System.out.println("Cantidad de habitantes: " + cant);
                break;
            case 2:
                cant = forja.contar();
                System.out.println("Cantidad de Armas: " + cant);
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }
    }

    private void elegirBuscar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Que desea buscar");
        System.out.println("1. Habitantes");
        System.out.println("2. Forja real");
        int opcion = sc.nextInt();
        sc.nextLine();
        switch (opcion) {
            case 1:
                System.out.println("ingrese id habitante a buscar");
                int id = sc.nextInt();
                sc.nextLine();
                try {
                    System.out.println(repositorio.buscar(id));
                }catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                break;
            case 2:
                System.out.println("ingrese nombre de arma a buscar");
                String nombre = sc.nextLine();
                try {
                    System.out.println(forja.buscar(nombre));
                }catch (ArmaNoEncontradaException e) {
                    System.out.println(e.getMessage());
                }
                break;
        }
    }
}
