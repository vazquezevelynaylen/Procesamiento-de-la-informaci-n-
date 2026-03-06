public class DosHilos {
    public static void main(String[] args) {
        Thread letras = new Thread() {
            public void run() {
                System.out.println("A B C D E");
            }
        };
        Thread numeros = new Thread() {
            public void run() {
                System.out.println("1 2 3 4 5");
            }
        };
        letras.start();
        numeros.start();
    }
}