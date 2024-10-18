package br.uffs.bibliotecapessoal.livro;

import java.util.Scanner;

import br.uffs.bibliotecapessoal.utils.utils;

public class LivroBiografia extends Livro implements ILivro{
    private Scanner scanner = new Scanner(System.in);
    private String biografado;
    private int perildoCoberto;
    
    public void criar(){
        criarLivro();
        System.out.println("--Biografado:");
        String biografado = scanner.nextLine();
        this.biografado = biografado;
        System.out.println("--Perildo Coberto:");
        int perildo = utils.getInt();
        this.perildoCoberto = perildo;
    }

    public void editar(){

    }

    public String getBiografado() {
        return biografado;
    }

    public void setBiografado(String biografado) {
        this.biografado = biografado;
    }

    public int getPerildoCoberto() {
        return perildoCoberto;
    }

    public void setPerildoCoberto(int perildoCoberto) {
        this.perildoCoberto = perildoCoberto;
    }
    
}
