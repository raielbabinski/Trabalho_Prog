package br.uffs.bibliotecapessoal.livro;

import java.util.Scanner;
import br.uffs.bibliotecapessoal.utils.*;

public class LivroFilosofico extends Livro {
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
        System.out.println("-- Filosofo:");
        String filosofo = scanner.nextLine();
        System.out.println("-- Filosofia:");
        String filosofia = scanner.nextLine();
        this.setTitulo(titulo);
        this.setAutor(autor);
        this.setPaginas(paginas);
        this.setFilosofoAbordado(filosofo);
        this.setFilosofiaAbordada(filosofia);
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
        System.out.println("-- Paginas: " + this.getPaginas());
        System.out.println("-- Filosofo: " + this.filosofo);
        System.out.println("-- Filosofia: " + this.filosofia);
        System.out.println("-- Status: " + this.getStatus());
        System.out.println("=================================");
        
    }
    

}
