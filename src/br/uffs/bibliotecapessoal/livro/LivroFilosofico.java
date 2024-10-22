package br.uffs.bibliotecapessoal.livro;

import java.util.Scanner;

public class LivroFilosofico extends Livro {
    private Scanner scanner = new Scanner(System.in);
    private String filosofo;
    private String filosofia;

    public void criar(){
        criar();
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

    @Override
    public void editar() {

    }
    @Override
    public void printLivro(int opcao) {
        boolean opcao2Invalida = (opcao == 2 && !this.getStatus().equals("Para ler"));
        boolean opcao3Invalida = (opcao == 3 && !this.getStatus().equals("Lendo"));
        boolean opcao4Invalida = (opcao == 4 && !this.getStatus().equals("Lido"));
    
        if (opcao2Invalida || opcao3Invalida || opcao4Invalida) {
            return;
        }     
        System.out.println("=========================================");
        System.out.println("-- Titulo: " + this.getTitulo());
        System.out.println("-- Autor: " + this.getAutor());
        System.out.println("-- Paginas: " + this.getPaginas());
        System.out.println("-- Status: " + this.getStatus());
        System.out.println("=========================================");
        
    }
    

}
