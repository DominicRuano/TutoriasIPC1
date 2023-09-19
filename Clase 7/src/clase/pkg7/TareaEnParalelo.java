
package clase.pkg7;

class TareaEnParalelo extends Thread {
    private int numeroThread;

    public TareaEnParalelo(int numeroThread) {
        this.numeroThread = numeroThread;
    }

    @Override
    public void run() {
        System.out.println("T"+numeroThread
                + " está ejecutando este codigo - " + Thread.currentThread().getName());

    }

}
