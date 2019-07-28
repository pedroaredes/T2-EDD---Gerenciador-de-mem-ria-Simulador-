//********************NOMES*****************************
//Pedro Henrique Lacerda Aredes                  *******
//Emerson Marques Ferreira                       *******
//******************************************************
package testalistaligada;

public class listaBlocosLivres {

    private No end_I;// endereço inicial da lista
    private int tam;
    private int ref;

    public listaBlocosLivres() {
        this.end_I = null; // lista esta vazia
        this.tam = 4000;
        this.ref = 0000;
    }

    public void MemoriaLocada(int elemento, No melhorMemoria) {
        No temp = this.end_I;
        No ant = null;
        if (this.end_I.getProx() == null) {
            this.end_I.setElemento(this.end_I.getElemento() - elemento);
            this.tam = this.end_I.getElemento();
            this.end_I.setRefInicial(this.end_I.getRefInicial() + elemento);
        } else {
            melhorMemoria.setRefInicial(melhorMemoria.getRefInicial() + elemento);
            if (melhorMemoria.reduzMemoria(elemento) == 0) {
                if (temp.getElemento() == melhorMemoria.getElemento()) {
                    this.end_I = this.end_I.getProx();
                }
                while (temp.getElemento() != 0) {
                    ant = temp;
                    temp = temp.getProx();
                }
                if (temp != null && temp.getProx() != null && ant != null) {
                    ant.setProx(temp.getProx());
                } else if (temp.getProx() == null) {
                    ant.setProx(null);
                }
            }
        }
    }

    public boolean isEmpty() {
        return this.end_I == null;
    }

    // versao recursiva
    public boolean buscaRec(int x) {
        return busca(x, this.end_I);
    }

    public int getEnd_i() {
        return this.end_I.getRefInicial();
    }

    private boolean busca(int x, No aux) {
        // condicoes de parada
        if (aux == null) {
            return false;
        }

        if (aux.getElemento() == x) {
            return true;
        }

        return busca(x, aux.getProx());
    }

    public void addOrdenadoLivre(No removido) {
        if (this.end_I == null) {
            No inicio = new No(removido.getElemento(), null, 0, this.ref);
            this.end_I = inicio;
        }
        No aux = this.end_I;
        No ant = null;
        if (removido.getElemento() < this.tam) {
            while (aux != null && aux.getRefInicial() < removido.getRefInicial()) {
                ant = aux;
                aux = aux.getProx();
            }
            System.out.println(removido.getRefInicial());
            No novo = new No(removido.getElemento(), aux, 0, removido.getRefInicial());
            if (ant == null)// insere  no inicio
            {
                this.end_I = novo;
            } else {
                ant.setProx(novo);
            }
            this.ref = removido.getRefInicial();

        } else {
            System.out.println();
        }

    }

    public void contiguo() {
        No inicio = this.end_I;
        No prox = this.end_I.getProx();
        while (inicio.getProx() != null) {
            if (inicio.getElemento() + inicio.getRefInicial() != prox.getRefInicial()) {
                break;
            }

            if (inicio.getElemento() + inicio.getRefInicial() == prox.getRefInicial()) {
                System.out.println("Juntando memoria..");
                this.end_I.setElemento(this.end_I.getElemento() + prox.getElemento());
                this.end_I.setProx(prox.getProx());
                this.tam = this.end_I.getElemento();
            }
            prox = this.end_I.getProx();
        }

    }

    public void imprime() {
        No aux = this.end_I;
        No ant = null;
        while (aux != null) {
            System.out.println("Endereco Inicial:" + aux.getRefInicial() + "\n" + "Tamanho:" + aux.getElemento() + "\n");
            System.out.println("--------------------------------------------------------");
            ant = aux;
            aux = aux.getProx();
        }
    }

    public No MelhorMemoria(int tamanho) {
        int resto, restoFinal = this.end_I.getElemento();
        No resposta = null;
        No aux = this.end_I;
        while (aux != null) {
            if (aux.getElemento() >= tamanho) {
                resto = aux.getElemento() - tamanho;
                if (resto < restoFinal) {
                    restoFinal = resto;
                    resposta = aux;
                }
            }
            aux = aux.getProx();
        }
        return resposta;
    }
}
