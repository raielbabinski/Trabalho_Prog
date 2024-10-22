package br.uffs.bibliotecapessoal.livro;

import java.util.Scanner;
import br.uffs.bibliotecapessoal.utils.*;

public class Livro implements ILivro{
    private String titulo;
    private String autor;
    private int paginas;
    private String status;
    private Scanner scanner = new Scanner(System.in);
    
    //private List<String> anotacoes;

    public void criarLivro(){
        utils.limparTerminal();
        System.out.println("------Registro de Livro------");
        System.out.println("--Titulo:");
        String titulo = scanner.nextLine();
        System.out.println("--Autor:");
        String autor = scanner.nextLine();
        System.out.println("--Paginas");
        int paginas = utils.getInt();
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
        this.status = "Para ler";
    }

    @Override
    public void printLivro(int opcao){
        boolean opcao2Invalida = (opcao == 2 && !this.status.equals("Para ler"));
        boolean opcao3Invalida = (opcao == 3 && !this.status.equals("Lendo"));
        boolean opcao4Invalida = (opcao == 4 && !this.status.equals("Lido"));
    
        if (opcao2Invalida || opcao3Invalida || opcao4Invalida) {
            return;
        }
    
        System.out.println("=========================================");
        System.out.println("-- Titulo: " + this.titulo);
        System.out.println("-- Autor: " + this.autor);
        System.out.println("-- Paginas: " + this.paginas);
        System.out.println("-- Status: " + this.status);
        System.out.println("=========================================");
    
    }

    @Override
    public void editar(){

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
