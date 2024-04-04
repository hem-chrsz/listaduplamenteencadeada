package model;

public class ListaDuplamenteEncadeada {
    ListaNo inicio;
    ListaNo fim;
    int tamanho;

    public void inserirInicio(int dado){
        ListaNo novoNo = new ListaNo(dado);

        if (inicio == null) {
            inicio = fim = novoNo;
        } else {
            novoNo.proximo = inicio;
            inicio.anterior = novoNo;
            inicio = novoNo;
        }
        tamanho++;
    }
    public void inserirFim(int dado) {
        ListaNo novoNo = new ListaNo(dado);
        if (inicio == null) {
            inicio = fim = novoNo;
        } else {
            fim.proximo = novoNo;
            novoNo.anterior = fim;
            fim = novoNo;
        }
        tamanho++;
    }
    public void inserirOrdemCresc(int dado) {
        ListaNo novoNo = new ListaNo(dado);
        if (inicio == null || inicio.dado >= dado) {
            inserirInicio(dado);
            return;
        }
        if (fim.dado <= dado) {
            inserirFim(dado);
            return;
        }
        ListaNo atual = inicio;
        while (atual != null && atual.dado < dado) {
            atual = atual.proximo;
        }
        novoNo.proximo = atual;
        novoNo.anterior = atual.anterior;
        atual.anterior.proximo = novoNo;
        atual.anterior = novoNo;
        tamanho++;
    }
    public void removerInicio() {
        if (inicio == null) return;
        if (inicio == fim) {
            inicio = fim = null;
        } else {
            inicio = inicio.proximo;
            inicio.anterior = null;
        }
        tamanho--;
    }
    public void removerFim() {
        if (inicio == null) return;
        if (inicio == fim) {
            inicio = fim = null;
        } else {
            fim = fim.anterior;
            fim.proximo = null;
        }
        tamanho--;
    }
    public void removerMeio(int dado) {
        if (inicio == null) return;
        if (inicio.dado == dado) {
            removerInicio();
            return;
        }
        if (fim.dado == dado) {
            removerFim();
            return;
        }
        ListaNo atual = inicio;
        while (atual != null && atual.dado != dado) {
            atual = atual.proximo;
        }
        if (atual != null) {
            atual.anterior.proximo = atual.proximo;
            atual.proximo.anterior = atual.anterior;
            tamanho--;
        }
    }
    public int obterTamanho() {
        return tamanho;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public void imprimirLista() {
        ListaNo atual = inicio;
        while (atual != null) {
            System.out.print(atual.dado + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }
}

