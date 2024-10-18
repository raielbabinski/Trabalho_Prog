package br.uffs.bibliotecapessoal.livro;

import java.util.Scanner;

public class LivroFilosofico extends Livro implements ILivro{
    private Scanner scanner = new Scanner(System.in);
    private String filosofo;
    private String filosofia;

    public void criar(){
        criarLivro();
        System.out.println("--Filosofo:");
        String filosofo = scanner.nextLine();
        this.filosofo = filosofo;
        System.out.println("--Filosofia:");
        String filosofia = scanner.nextLine();
        this.filosofia = filosofia;
    }

    public String getFilosofoAbordado() {
        return filosofo;
    }

    public void setFilosofoAbordado(String filosofoAbordado) {
        this.filosofo = filosofoAbordado;
    }

    public String getFilosofiaAbordada() {
        return filosofia;
    }

    public void setFilosofiaAbordada(String filosofiaAbordada) {
        this.filosofia = filosofiaAbordada;
    }

    public void editar() {

    }

    public void printLivro() {

    }

    

}
