package model;

public class Principal {
    public static void main(String[] args) {

        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();


        lista.inserirOrdemCresc(10);
        lista.inserirOrdemCresc(5);
        lista.inserirOrdemCresc(15);

        System.out.println("Lista após inserções:");
        lista.imprimirLista();

        lista.removerInicio();
        lista.removerFim();

        System.out.println("\nLista após remoções no início e no fim:");
        lista.imprimirLista();

        lista.inserirInicio(2);
        lista.inserirFim(20);

        System.out.println("\nLista após novas inserções no início e no fim:");
        lista.imprimirLista();

        lista.inserirOrdemCresc(12);
        lista.removerMeio(12);

        System.out.println("\nLista após remoção no meio:");
        lista.imprimirLista();

        System.out.println("\nTamanho da lista: " + lista.obterTamanho());
        System.out.println("A lista está vazia? " + lista.estaVazia());
    }
}