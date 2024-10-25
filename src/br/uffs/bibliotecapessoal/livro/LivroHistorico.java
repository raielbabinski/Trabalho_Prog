package br.uffs.bibliotecapessoal.livro;

import java.util.Scanner;
import br.uffs.bibliotecapessoal.utils.*;

public class LivroHistorico extends Livro{
    private Scanner scanner = new Scanner(System.in);
    private String perildoHistorico;
    private int anoCoberto;

    public void criar(){
        criarLivro();
        System.out.println("--Perildo Histórico:");
        String perildoH = scanner.nextLine();
        this.perildoHistorico = perildoH;
        System.out.println("--Ano Coberto:");
        int ano = utils.getInt();
        this.anoCoberto = ano;

    }

    public String getPerildoHistorico() {
        return perildoHistorico;
    }

    public void setPerildoHistorico(String perildoHistorico) {
        this.perildoHistorico = perildoHistorico;
    }

    public int getAnoPerildoHistorico() {
        return anoCoberto;
    }

    public void setAnoPerildoHistorico(int anoCoberto) {
        this.anoCoberto = anoCoberto;
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
        System.out.println("-- Perildo Histórico:");
        String perildoH = scanner.nextLine();
        this.setPerildoHistorico(perildoH);
        System.out.println("-- Ano Coberto:");
        int ano = utils.getInt();
        this.setAnoPerildoHistorico(ano);
        this.setTitulo(titulo);
        this.setAutor(autor);
        this.setPaginas(paginas);
        System.out.println("Livro editado com sucesso!");

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
        System.out.println("-- Perildo Histórico: " + this.perildoHistorico);
        System.out.println("-- Ano Coberto: " + this.anoCoberto);
        System.out.println("-- Status: " + this.getStatus());
        System.out.println("=================================");
    
    }

}
