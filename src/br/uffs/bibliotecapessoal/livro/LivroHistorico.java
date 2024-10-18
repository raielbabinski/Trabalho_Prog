package br.uffs.bibliotecapessoal.livro;

import java.util.Scanner;
import br.uffs.bibliotecapessoal.utils.*;

public class LivroHistorico extends Livro implements ILivro{
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

    public void editar() {

    }

    public void printLivro() {

    }

}
