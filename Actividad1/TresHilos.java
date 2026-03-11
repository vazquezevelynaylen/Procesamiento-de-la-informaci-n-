// Clase que guarda el contador compartido
class Contador {
    int valor = 0; // variable del contador
    // synchronized evita que dos hilos modifiquen el contador al mismo tiempo
    public synchronized void incrementar() {
        valor++;
    }
}
// Clase que define la tarea que ejecutarán los hilos
class TareaContador implements Runnable {
    Contador contador; // referencia al contador compartido
    // constructor que recibe el contador
    public TareaContador(Contador contador) {
        this.contador = contador;
    }
    // código que ejecuta el hilo
    public void run() {

        for (int i = 0; i < 1000; i++) {
            contador.incrementar(); // incrementa el contador
        }

    }
}
// clase principal del programa
public class TresHilos {
    public static void main(String[] args) throws InterruptedException {
        // se crea el contador compartido
        Contador contador = new Contador();
        // se crean dos hilos que ejecutan la misma tarea
        Thread hilo1 = new Thread(new TareaContador(contador));
        Thread hilo2 = new Thread(new TareaContador(contador));
        // se inician los hilos
        hilo1.start();
        hilo2.start();
        // join hace que el programa espere a que los hilos terminen
        hilo1.join();
        hilo2.join();
        // se imprime el valor final del contador
        System.out.println("Valor final: " + contador.valor);
    }
}