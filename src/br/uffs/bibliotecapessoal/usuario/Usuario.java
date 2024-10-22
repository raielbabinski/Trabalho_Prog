package br.uffs.bibliotecapessoal.usuario;

import java.util.ArrayList;


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

    public void setLivro(Livro livro){
        listaLivros.add(livro);
    }

    public void visualizarLivros(int opcao){
        for(Livro l: listaLivros){
            l.printLivro(opcao);
        }
    }
}

