class Processos extends Thread {

    private double tempoprocesso;
    private int Numprocesso;

    public Processos(double tempoprocesso,int Numprocesso){
        this.tempoprocesso=tempoprocesso;
        this.Numprocesso=Numprocesso;
    }

    public double getTempoProcesso() {
        return tempoprocesso;
    }

    public void run(){
        for (int i=1;i<=tempoprocesso;i++){
            System.out.println("Processo N"+Numprocesso+" está em processo a "+i+" centésimos" );

            try {
                Thread.sleep(100);
            }
            catch (InterruptedException e){
                System.out.println("Processo foi interrompido");
            }
        }
        System.out.println("Processo N"+Numprocesso+" foi finalizado");
    }
}
