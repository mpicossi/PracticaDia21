import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringJoiner;

public class Main {

    public static void main(String[] args) {
        //ejercicio1();
        //ejercicio2();
       //ejercicio3();
        //ejercicio4();
        //ejercicio5();

        int iArr[] = {4,28,132,3,61,5};

        String[] strings = convertirArrayStr(iArr);

        for (String s: strings) {

            System.out.println(s);

        }
    }

    public static void ejercicio1(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de numeros pares:" );
        int n = scanner.nextInt();
        int i = 1;
        int p = 0;

        while (i <= n){

            System.out.println(p);
            p = p+2;
            i++;
        }

    }

    public static void ejercicio2() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el numero:");
        int numero = scanner.nextInt();
        int acum = numero;
        System.out.println("Ingrese la cantidad de multiplos a mostrar:");
        int cantidadMultiplos = scanner.nextInt();

        int i = 1;
        while (i <= cantidadMultiplos) {

            System.out.println(acum);
            acum += numero;
            i++;
        }
    }
    public static void ejercicio3() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el numero:");
        int numero = scanner.nextInt();
        int i = 2;
        boolean noEsPrimo = false;

        while(i < numero ){

            if(numero%i==0 && numero!=i){
                noEsPrimo = true;
                break;
            }
            i++;
        }

        if(noEsPrimo){
            System.out.println("El numero "+numero +" no es primo.");
        }
        else{
            System.out.println("El numero "+numero +" es primo.");
        }

    }
    public static void ejercicio4() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la cantidad de numeros primos a mostrar:");
        int numero = scanner.nextInt();
        int i = 0;

        while(i <= numero ){

            if(!noEsPrimo(i)){
                System.out.println(i);
                i++;
            }

        }



    }


    public static boolean noEsPrimo(int numero){
        int i = 2;
        boolean noEsPrimo = false;

        while(i < numero ){

            if(numero%i==0 && numero!=i){
                noEsPrimo = true;
                break;
            }
            i++;
        }

        return noEsPrimo;
    }


    public static String[] convertirArrayStr(int[] ar){
        int mayor = 0;
        String[] str = new String[ar.length];

        for (int i = 0; i < ar.length; i++) {
            if(ar[i]>mayor)
                mayor = ar[i];

            str[i] = Integer.toString(ar[i]);
        }

        //Cantidad de digitos del Mayor
        int digitos = Integer.toString(mayor).length();

        for (int i = 0; i < str.length; i++) {
            if(str[i].length() < digitos){

               int cantCeros =  digitos - str[i].length();

               while(cantCeros>0){

                   str[i] = "0"+str[i];
                   cantCeros --;
               }
            }
        }

        //Ordeno la cantidad de veces como digitos tenga el mayor numero
        for (int i = digitos -1; i >= 0; i--) {
             str = ordenaStringArray(i,str);
        }

        return str;
    }

    public static String[] ordenaStringArray(int digitoVerificar, String[] str){

        HashMap<String,ArrayList> map = new HashMap<>();
        String auxDigit = "";
        ArrayList<String> arrayFinal = new ArrayList<>();

        for (int i = 0; i < str.length; i++) {

         auxDigit = str[i].substring(digitoVerificar,digitoVerificar+1);
            if(map.containsKey(auxDigit)){
                ArrayList arrayList = map.get(auxDigit);
                arrayList.add(str[i]);
                map.put(auxDigit,arrayList);
            }
            else{

                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(str[i]);
                map.put(auxDigit,arrayList);
            }
        }

        for (int i = 0; i < 10; i++) {

            if(map.containsKey(Integer.toString(i))){
                ArrayList<String> arrayList = map.get(Integer.toString(i));
                for (String s: arrayList) {

                    arrayFinal.add(s);
                }
            }
        }

        String[] s = new String[arrayFinal.size()];
        s = arrayFinal.toArray(s);
        
        return s;
    }

    public static void ejercicio5() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la cantidad de numeros a mostrar:");
        int n = scanner.nextInt();
        System.out.println("Ingrese la cantidad de digitos minimos que debe tener:");
        int m = scanner.nextInt();
        System.out.println("Ingrese el numero que debe repetirse:");
        int d = scanner.nextInt();
        char c = (char)(48 + d);

        int i = 0;
        int cantVeces = 0;
        int largo = 0;
        int cantDigit = 0;
        String aux;

        while(cantVeces < n ){
            aux = Integer.toString(i);
            largo = aux.length();
            cantDigit = 0;

            if(largo >= m){
                char[] cNumero = aux.toCharArray();
                for (char ci:cNumero) {
                    if(ci == c){
                        cantDigit++;
                    }
                }
                if(cantDigit>=m){
                    cantVeces++;
                    System.out.println(aux);
                }
            }
            i++;
        }
    }

}
