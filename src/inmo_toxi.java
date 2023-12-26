
import java.util.Scanner;

public class inmo_toxi {

    public static void panelControlGestor(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Opciones del panel de control del gestor: ");
        System.out.println("1.-Resumen de proyectos existentes: ");
        System.out.println("2.-Mis proyectos: ");
        System.out.println("3.-Configuración");
        System.out.println("4.-Salir");
        int opcion = sc.nextInt();
        switch (opcion){
            case 1:
                System.out.println("Este es el resumen de los proyectos existentes:");
                break;
            case 2:
                System.out.println("Estas dentro de la pestaña mis proyectos");
                break;
            case 3:
                System.out.println("Estas dentro de configuración");
                break;
            case 4:
                System.out.println("Saliendo...");
                break;
        }
    }

    public static String[] crearProyecto(){
        Scanner sc = new Scanner(System.in);
        String[] proyecto = new String[6];
        String nombreProyectoo ="";


            System.out.println("Dime el nombre del proyecto: ");
            nombreProyectoo= sc.next();
            System.out.println();
            System.out.println("Descripcion del proyecto: ");
            String descripcionProyecto = sc.next();
            System.out.println();
            System.out.println("Dime cantidad necesaria para el proyecto:");
            int cantidadNecesaria = sc.nextInt();
            System.out.println();
            System.out.println("Dime el año de inicio");
            int añoIni= sc.nextInt();
            System.out.println();
            System.out.println("Dime el año de fin: ");
            int añoFinn = sc.nextInt();


            proyecto[0]= nombreProyectoo;
            proyecto[1]= descripcionProyecto;
            proyecto[2]= String.valueOf(cantidadNecesaria);
            proyecto[3]= String.valueOf(añoIni);
            proyecto[4]= String.valueOf(añoFinn);


                System.out.print("Nombre del proyecto: "+proyecto[0]+
                        "\n"+ "Descripcion del proyecto: "+proyecto[1]+
                        "\n"+"Cantidad necesaria para el proyecto: "+proyecto[2]+" Euros"+
                        "\n"+"Fecha de inicio de proyecto: "+proyecto[3]+
                        "\n"+"Fecha de fin de proyecto: "+proyecto[4]);









        return proyecto;
    }

    public static void menuUsuarioAdmin(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Estas en el menú del Administrador: ");
        System.out.println("1.-Panel de control" +
                "\n 2.-Proyectos" +
                "\n 3.-Configuración" +
                "\n 4.-Salir");
        System.out.println("Elige opción: ");
        int opcion = sc.nextInt();
        switch (opcion){
            case 1:
                System.out.println("Estas dentro del panel de control");
                break;
            case 2:
                System.out.println("Estas dentro de la pestaña proyectos:");
                break;
            case 3:
                System.out.println("Estas dentro de la pestaña configuración: ");
                break;
            case 4:
                System.out.println("Saliendo...");
                break;
        }
    }

    public static void menuUsuarioGestor(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Estas en el menú del gestor: ");
        System.out.println("1.-Panel de control" +
                "\n 2.-Mis proyectos" +
                "\n 3.-Configuración" +
                "\n 4.-Salir" +
                "\n 5.-Crear nuevo proyecto");
        System.out.println("Introduce numero de opción:");
        int opcion = sc.nextInt();
        switch (opcion){
            case 1:
                System.out.println("Estas en el panel de control:");
                panelControlGestor();
                break;

            case 2:
                System.out.println("Estas en la pestaña Mis Proyectos");
                break;
            case 3:
                System.out.println("Estas en la pestaña configuración");
                break;
            case 4:
                System.out.println("Saliendo...");
                break;
            case 5:
                crearProyecto();
                break;



        }
    }



    public static void main(String[] args) {
        boolean usuarioBloqueado = false;
        int contadorIntentos=3;
        Scanner sc = new Scanner(System.in);
        String usuarioElegido ="";
        String[] usuarios = {"administrador","gestor","inversor","inversor2"};
        String[] contraseñas = {"admin","gestor","inversor","inversor2"};

        System.out.println("Dime que usuario eres(-Administrador." +
                "-Gestor." +
                "-inversor." +
                "-inversor2:");
        String numSeleccionUsuario = sc.next();
        for (int i =0;i<usuarios.length;i++){
            if (usuarios[i].equals(numSeleccionUsuario)){
                usuarioElegido=usuarios[i];
                break;
            }

        }

        if (!usuarioElegido.isEmpty()){
            System.out.println("Introduce la contraseña: ");
            String contraseñaIntroducida = sc.next();

            int indiceUsuario = -1;
            for (int i =0;i<usuarios.length;i++){
                if (usuarios[i].equals(usuarioElegido)){
                    indiceUsuario= i;
                    break;
                }
            }

            if (indiceUsuario!=-1 && contraseñas[indiceUsuario].equals(contraseñaIntroducida)&& usuarioBloqueado==false){
                while (true){
                    if (usuarioElegido.equals("administrador")){
                        menuUsuarioAdmin();
                        break;

                    } else if (usuarioElegido.equals("gestor")) {
                        menuUsuarioGestor();
                        break;

                    }



                }
            }else{
                while (contadorIntentos > 0 && usuarioElegido!="administrador") {
                    contadorIntentos--;
                    System.out.println("Contraseña incorrecta, te quedan " + contadorIntentos + " intentos");

                    if (contadorIntentos == 0) {
                        usuarioBloqueado=true;
                        System.out.println("Ahora además estás bloqueado.");
                        break;
                    } else {
                        System.out.println("Introduce la contraseña: ");
                        contraseñaIntroducida = sc.next();
                        if (indiceUsuario != -1 && contraseñas[indiceUsuario].equals(contraseñaIntroducida)) {
                            System.out.println("Contraseña correcta. Acceso permitido.");
                            break;
                        }
                    }
                }
            }
        }else{
            System.out.println("Usuario incorrecto");
        }








    }
}
