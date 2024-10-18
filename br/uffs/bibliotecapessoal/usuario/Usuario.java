package br.uffs.bibliotecapessoal.usuario;

import java.util.ArrayList;
import br.uffs.bibliotecapessoal.utils.utils;

import br.uffs.bibliotecapessoal.livro.*;

public class Usuario{
    private String nome;
    private int senha;
    private ArrayList<Livro> listaLivros = new ArrayList<Livro>();

    public Usuario(String nome, int senha){
        this.nome = nome;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public void setLivro(int modelLivro){
        int escolha;
        escolha = utils.getInt();

        switch (escolha) {
            case 1:
                LivroGenerico livroGenerico = new LivroGenerico();
                livroGenerico.criar();
                listaLivros.add(livroGenerico);
                break;
            case 2:
                LivroBiografia livroBiografia = new LivroBiografia();
                livroBiografia.criar();
                listaLivros.add(livroBiografia);
                break;
            case 3:
                LivroFiccao livroFiccao= new LivroFiccao();
                livroFiccao.criar();
                listaLivros.add(livroFiccao);
                break;
            case 4:
                LivroFilosofico livroFilosofico = new LivroFilosofico();
                livroFilosofico.criar();
                listaLivros.add(livroFilosofico);    
                break;
            case 5:
                LivroHistorico livroHistorico = new LivroHistorico();
                livroHistorico.criar();
                listaLivros.add(livroHistorico); 
                break;
            case 0:
                System.out.println("--Saindo...");
                break;
            default:
                System.out.println("--Opção inválida, tente novamente.");
            }

    }

    public void visualizarLivros(){

    }
}

