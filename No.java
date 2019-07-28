//********************NOMES*****************************
//Pedro Henrique Lacerda Aredes                  *******
//Emerson Marques Ferreira                       *******
//******************************************************
package testalistaligada;

public class No {
    private int elemento;
    private No prox;
    private int id;
    private int ref_inicial;
    

    public No(int elemento, No prox, int id, int ref) {
        this.elemento = elemento;
        this.prox = prox;
        this.id = id;
        this.ref_inicial = ref;
    }

    public int getElemento() {
        return elemento;
    }

    public No getProx() {
        return prox;
    }
    public void setId(int id){
    this.id = id;
    }
    public int GetId(){
    return id;
    }

    public void setElemento(int elemento) {
        this.elemento = elemento;
    }
    public int reduzMemoria(int memoria){
        this.elemento -= memoria;
        return this.elemento;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }

    public int getRefInicial() {
        return ref_inicial;
    }

    public void setRefInicial(int ref) {
        this.ref_inicial = ref;
    }
    @Override
    public String toString() {
        //return "{" + this.elemento + ", \n" + this.prox + '}';
        return "{" + this.elemento + ", \n" + this.ref_inicial + ", \n"+this.prox+ '}';
    }
    
    
    
}
