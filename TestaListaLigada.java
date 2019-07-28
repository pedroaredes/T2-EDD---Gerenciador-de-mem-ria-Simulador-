//********************NOMES*****************************
//Pedro Henrique Lacerda Aredes                  *******
//Emerson Marques Ferreira                       *******
//******************************************************
package testalistaligada;
import java.util.Scanner;

public class TestaListaLigada {

    public static void main(String[] args) {
        int escolha = 0, qtdMemoria = 0, processo = 0, remover = 0, referencia = 0;
        No removido = null;
        No MemoriaInicial = new No(4000,null,0,0);
        boolean loop = true;
        listaBlocosLivres listaLivre = new listaBlocosLivres();
        listaBlocosAlocados listaAlocada = new listaBlocosAlocados();
        Scanner ler = new Scanner(System.in);
        listaLivre.addOrdenadoLivre(MemoriaInicial);
        while (loop) {
            System.out.println("________________________________________________________");
            System.out.println("Digite 1 para alocar memória");
            System.out.println("Digite 2 para finalizar um processo");
            System.out.println("Digite 3 para imprimir a situação atual da memória");
            System.out.println("Digite 4 para sair.");
            System.out.println("________________________________________________________");
            escolha = ler.nextInt();
            
            if (escolha == 1) {
                System.out.println("Quanto de memoria deseja alocar?");
                qtdMemoria = ler.nextInt();
                System.out.println("Numero do processo: ");
                processo = ler.nextInt();
                if (listaAlocada.processoDisponivel(processo)) {
                    listaAlocada.addOrdenado(qtdMemoria, processo, listaLivre);
                } else {
                    System.out.println("Processo Nao esta disponivel, tente novamente.");
                }
            } else if (escolha == 2) {
                System.out.println("Escolha o numero do processo que deseja remover da memoria.");
                processo = ler.nextInt();
                removido = listaAlocada.buscaRec(processo);
                if (removido == null) {
                    System.out.println("Esse processo nao existe!");
                } else {
                    listaLivre.addOrdenadoLivre(removido);
                    listaLivre.contiguo();
                }
            } else if (escolha == 3) {
                System.out.println("*****LISTA LIVRE****");
                listaLivre.imprime();
                System.out.println("--------------------------------------------------------");
                System.out.println("*****LISTA ALOCADA****");
                listaAlocada.imprime();
            } else {
                break;
            }
        }
    }

}
