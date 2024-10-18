package br.uffs.bibliotecapessoal.livro;

import java.util.Scanner;
import br.uffs.bibliotecapessoal.utils.*;

public class LivroFiccao extends Livro implements ILivro{
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'editar'");
    }


    @Override
    public void printLivro() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'printLivro'");
    }
    
}
