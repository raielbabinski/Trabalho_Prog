package br.uffs.bibliotecapessoal.livro;

import java.util.Scanner;

import br.uffs.bibliotecapessoal.utils.utils;

public class LivroBiografia extends Livro{
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
    
    @Override
    public void printLivro(int opcao) {
        boolean opcao2Invalida = (opcao == 2 && !this.getStatus().equals("Para ler"));
        boolean opcao3Invalida = (opcao == 3 && !this.getStatus().equals("Lendo"));
        boolean opcao4Invalida = (opcao == 4 && !this.getStatus().equals("Lido"));
    
        if (opcao2Invalida || opcao3Invalida || opcao4Invalida) {
            return;
        }
    
        System.out.println("=================================");
        System.out.println("-- Titulo: " + this.getTitulo());
        System.out.println("-- Autor: " + this.getAutor());
        System.out.println("-- Paginas: "+ this.getPaginas());
        System.out.println("-- Biografado: " + this.biografado);
        System.out.println("-- Perildo Coberto: " + this.perildoCoberto);
        System.out.println("-- Status: " + this.getStatus());
        System.out.println("=================================");
        
    }

    @Override
    public void editar(){
        utils.limparTerminal();
        System.out.println("------ Edicao de Livro ------");
        System.out.println("-- Titulo:");
        String titulo = scanner.nextLine();
        System.out.println("-- Autor:");
        String autor = scanner.nextLine();
        System.out.println("-- Paginas");
        int paginas = utils.getInt();
        System.out.println("-- Biografado:");
        String biografado = scanner.nextLine();
        System.out.println("-- Perildo Coberto:");
        int perildo = utils.getInt();
        
        this.setTitulo(titulo);
        this.setAutor(autor);
        this.setPaginas(paginas);
        this.setBiografado(biografado);
        this.setPerildoCoberto(perildo);
    }
}
