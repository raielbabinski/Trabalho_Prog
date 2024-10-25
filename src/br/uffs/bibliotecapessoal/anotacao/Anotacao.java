package br.uffs.bibliotecapessoal.anotacao;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Anotacao {
    private String conteudo;
    private String data;
    private int capitulo;

    public Anotacao(){
        this.conteudo = null;
        LocalDateTime dataAtual = LocalDateTime.now();
        this.data = dataAtual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss "));
        this.capitulo = 0;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getCapitulo() {
        return capitulo;
    }

    public void setCapitulo(int capitulo) {
        this.capitulo = capitulo;
    }

    
}
