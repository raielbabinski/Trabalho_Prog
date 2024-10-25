package br.uffs.bibliotecapessoal.biblioteca;

import java.util.Scanner;

import br.uffs.bibliotecapessoal.anotacao.*;
import br.uffs.bibliotecapessoal.utils.*;
import br.uffs.bibliotecapessoal.livro.*;

public abstract class BibliotecaAnotacao {
    public static Scanner scanner = new Scanner(System.in);
    
    public static void opcoes(Livro livro){
        int escolha = -1;

        while (escolha != 0) {  
            utils.limparTerminal();
            System.out.println("------- Biblioteca Anotacoes --------");
            System.out.println("1 - Criar Anotacao");
            System.out.println("2 - Visualizar Anotacoes");
            System.out.println("3 - Editar Anotacao");
            System.out.println("4 - Excluir Anotacao");
            System.out.println("0 - Sair");
            System.out.print("-- Escolha uma opção: ");

            
            escolha = utils.getInt();
                
            switch (escolha) {
                case 1:
                    CriarAnotacao(livro);
                    break;
                case 2:
                    VisualizarAnotacoes(livro);
                    break;
                case 3:
                    EditarAnotacao(livro);
                    break;
                case 4:
                    ExcluirAnotacao(livro);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("-- Opção inválida, tente novamente.");
            }
        }
    }
    public static void CriarAnotacao(Livro livro) {
        Anotacao anotacao = new Anotacao();
        System.out.println("------ Criação de Anotação ------");
        System.out.println("-- Anotação:");
        String conteudo = scanner.nextLine();
        StringBuilder novoConteudo = new StringBuilder();
        int spaceCount = 0; 
        for (char c : conteudo.toCharArray()) {
            novoConteudo.append(c);

            if (c == ' ') {
                spaceCount++;
            }
            if (spaceCount == 4) {
                novoConteudo.append("\n");
                spaceCount = 0; 
            }
        }
        anotacao.setConteudo(novoConteudo.toString());
        System.out.println("-- Capítulo:");
        anotacao.setCapitulo(utils.getInt()); 
        livro.getAnotacoes().add(anotacao);
        System.out.println("-- Anotação criada com sucesso!");
    }



    public static void VisualizarAnotacoes(Livro livro){
        utils.limparTerminal();
        System.out.println("------- Visualizacao de Anotacoes --------");
        if (livro.getAnotacoes().isEmpty()){
            System.out.println("-- Nenhuma anotação cadastrada.");
            return;
        }
        for (int i = 0; i < livro.getAnotacoes().size(); i++) {
            Anotacao anotacao = livro.getAnotacoes().get(i);
            System.out.println("[" + (i+1) + "] " + anotacao.getConteudo());
            System.out.println("---------------------------------");
            System.out.println("Capitulo: " + anotacao.getCapitulo() + " | " + anotacao.getData());
            System.out.println("=================================");
        }                     

        scanner.nextLine();
    }

    public static void EditarAnotacao(Livro livro){
        utils.limparTerminal();
        System.out.println("------- Editar Anotacao --------");
        VisualizarAnotacoes(livro);
        System.out.println("-- Digite o número da anotação que deseja editar:");
        int i = utils.getInt();
        if (i <= 0 || i > livro.getAnotacoes().size()){
            System.out.println("-- Anotacao inexistente.");
            return;
        }
        Anotacao anotacao = livro.getAnotacoes().get(i-1);
        System.out.println("-- Conteudo da anotação atual:");
        System.out.println(anotacao.getConteudo());
        System.out.println("-- Novo conteudo:");
        String conteudo = scanner.nextLine();
        StringBuilder novoConteudo = new StringBuilder();
        int spaceCount = 0; 
        for (char c : conteudo.toCharArray()) {
            novoConteudo.append(c);

            if (c == ' ') {
                spaceCount++;
            }
            if (spaceCount == 5) {
                novoConteudo.append("\n");
                spaceCount = 0; 
            }
        }
        anotacao.setConteudo(novoConteudo.toString());
        System.out.println("-- Anotacao editada com sucesso!");
    }

    public static void ExcluirAnotacao(Livro livro){
        utils.limparTerminal();
        System.out.println("------- Excluir Anotacao --------");
        VisualizarAnotacoes(livro);
        System.out.println("-- Digite o número da anotação que deseja excluir:");
        int i = utils.getInt();
        if (i <= 0 || i > livro.getAnotacoes().size()){
            System.out.println("-- Anotacao inexistente.");
            return;
        }
        livro.getAnotacoes().remove(i-1);
        System.out.println("-- Anotacao excluida com sucesso!");
    }
}

