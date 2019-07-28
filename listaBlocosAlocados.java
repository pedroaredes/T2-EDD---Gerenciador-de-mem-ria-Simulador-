//********************NOMES*****************************
//Pedro Henrique Lacerda Aredes                  *******
//Emerson Marques Ferreira                       *******
//******************************************************
package testalistaligada;

import testalistaligada.*;

public class listaBlocosAlocados {

    private No end_I;// endereço inicial da lista
    private int tam;
    private int nProc;
    private int ref;
    private int tam_p;
    private int end_i;
    private listaBlocosLivres listaLivre;

    public listaBlocosAlocados() {
        this.end_I = null; // lista esta vazia
        this.tam = 4000;
        this.nProc = 0;
        this.ref = 0000;
        this.tam_p = 0;
        this.end_i = 0;
        this.listaLivre = null;
    }

    public boolean isEmpty() {
        return this.end_I == null;
    }

    // versao recursiva
    public No buscaRec(int x) {
        No resposta = null;
        if (busca(x, this.end_I)) {
            resposta = Remover(x);
        }
        return resposta;
    }

    private boolean busca(int x, No aux) {
        // condicoes de parada
        if (aux == null) {
            return false;
        }

        if (aux.GetId() == x) {
            return true;
        }

        return busca(x, aux.getProx());
    }

    public boolean addOrdenado(int x, int processo, listaBlocosLivres listaLivre) {
        No melhorMemoria = null;
        No aux = this.end_I;
        No ant = null;
        this.listaLivre = listaLivre;
        //escolhe o melhor No
        melhorMemoria = listaLivre.MelhorMemoria(x);
        if (melhorMemoria != null) {
            if (x <= melhorMemoria.getElemento()) {
                if (this.tam == 4000) {
                    this.ref = 0;
                } else {
                    this.ref += aux.getElemento();
                }
                this.tam_p = x;
                this.nProc = processo;
                while (aux != null && aux.GetId() < processo) {
                    ant = aux;
                    aux = aux.getProx();
                }
                No novo = new No(x, aux, processo, melhorMemoria.getRefInicial());
                if (ant == null)// insere  no inicio
                {
                    this.end_I = novo;
                } else {
                    ant.setProx(novo);
                }
                listaLivre.MemoriaLocada(x, melhorMemoria);
                this.tam = tam - x;
                this.end_i = listaLivre.getEnd_i();
                return true;
            }
        } else {
            System.out.println("Não tem memória suficiente.");// colocar uma exceção aqui dps
            return false;
        }
        System.out.println("Não tem memória suficiente.");
        return false;
    }

    public No Remover(int elemento) {
        No resposta = null;
        No temp = this.end_I;
        No ant = null;
        if (temp.GetId() == elemento) {
            this.end_I = this.end_I.getProx();
            resposta = temp;
        } else {
            while (temp != null && temp.GetId() != elemento) {
                ant = temp;
                temp = temp.getProx();
            }
            if (temp != null) {
                ant.setProx(temp.getProx());
                resposta = temp;
            }
            if (temp.getProx() == null) {
                ant.setProx(null);
                resposta = temp;
            }
        }
        return resposta;
    }

    public void imprime() {
        No aux = this.end_I;
        No ant = null;
        while (aux != null) {
            System.out.println("Nº Proc:" + aux.GetId() + "\n" + "Endereco Inicial:" + aux.getRefInicial() + "\n" + "Tamanho:" + aux.getElemento() + "\n");
            System.out.println("--------------------------------------------------------");
            ant = aux;
            aux = aux.getProx();
        }
    }

    public boolean processoDisponivel(int processo) {
        No aux = this.end_I;
        No ant = null;
        while (aux != null) {
            if (processo == aux.GetId()) {
                return false;
            }
            ant = aux;
            aux = aux.getProx();
        }
        return true;
    }

}
