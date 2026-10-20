import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[]args){
        Scanner teclado=new Scanner(System.in);
        ArrayList<Processos>Listaprocessos=new ArrayList<>();

        System.out.println("Digite o número de Processos");
        int numprocessos=teclado.nextInt();

        for (int i = 1; i <= numprocessos; i++) {
            System.out.println("Digite o tempo em centésimos do Processo " + i);
            double tempoprocesso = teclado.nextDouble();
            Processos p = new Processos(tempoprocesso, i);
            Listaprocessos.add(p);
        }

        for (int i = 0; i < Listaprocessos.size() - 1; i++) {

            for (int j = 0; j < Listaprocessos.size() - 1 - i; j++) {

                if (Listaprocessos.get(j).getTempoProcesso() >
                        Listaprocessos.get(j + 1).getTempoProcesso()) {

                    Processos temp = Listaprocessos.get(j);

                    Listaprocessos.set(j, Listaprocessos.get(j + 1));

                    Listaprocessos.set(j + 1, temp);
                }
            }
        }

        for (Processos p : Listaprocessos) {
            p.start();
            try {
                p.join();
            }
            catch (InterruptedException e){
                System.out.println("Processo foi interrompido");
            }
        }

    }
}
