package br.uffs.bibliotecapessoal.livro;

import java.util.Scanner;
import br.uffs.bibliotecapessoal.utils.*;

public class LivroFiccao extends Livro{
    private Scanner scanner = new Scanner(System.in);
    private String tema;
    private int idadeRecomendada;

    public void criar(){
        criarLivro();
        System.out.println("--Tema:");
        String tema = scanner.nextLine();
        this.tema = tema;
        System.out.println("--Idade Recomendada:");
        int idadeRecomendada = utils.getInt();
        this.idadeRecomendada = idadeRecomendada;
    }
    

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public int getIdadeRecomendada() {
        return idadeRecomendada;
    }

    public void setIdadeRecomendada(int idadeRecomendada) {
        this.idadeRecomendada = idadeRecomendada;
    }

    @Override
    public void editar() {
        utils.limparTerminal();
        System.out.println("------ Edicao de Livro ------");
        System.out.println("-- Titulo:");
        String titulo = scanner.nextLine();
        System.out.println("-- Autor:");
        String autor = scanner.nextLine();
        System.out.println("-- Paginas");
        int paginas = utils.getInt();
        System.out.println("-- Tema:");
        String tema = scanner.nextLine();
        System.out.println("-- Idade Recomendada:");
        int idadeRecomendada = utils.getInt();
        this.setTitulo(titulo);
        this.setAutor(autor);
        this.setPaginas(paginas);
        this.setTema(tema);
        this.setIdadeRecomendada(idadeRecomendada);
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
        System.out.println("-- Tema: " + this.tema);
        System.out.println("-- Idade Recomendada: " + this.idadeRecomendada);
        System.out.println("-- Status: " + this.getStatus());
        System.out.println("=================================");        
    }
    
}
