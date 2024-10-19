package br.uffs.bibliotecapessoal.biblioteca;

import java.util.InputMismatchException;
import java.util.Scanner;

import br.uffs.bibliotecapessoal.livro.LivroBiografia;
import br.uffs.bibliotecapessoal.livro.LivroFiccao;
import br.uffs.bibliotecapessoal.livro.LivroFilosofico;
import br.uffs.bibliotecapessoal.livro.LivroGenerico;
import br.uffs.bibliotecapessoal.livro.LivroHistorico;
import br.uffs.bibliotecapessoal.usuario.*;
import br.uffs.bibliotecapessoal.utils.*;

abstract public class BibliotecaLivro{
    public static Scanner scanner = new Scanner(System.in);

    public static void opcoes(Usuario usuario){
        int escolha = -1;

        while (escolha != 0) {
            utils.limparTerminal();
            System.out.println("------- Biblioteca --------");
            System.out.println("1 - Criar Anotação");
            System.out.println("2 - Registrar Livro");
            System.out.println("3 - Visualizar Livros");
            System.out.println("4 - Excluir Livro");
            System.out.println("5 - Editar Livro");
            System.out.println("0 - Sair da Biblioteca");
            System.out.print("-- Escolha uma opção: ");

            try {
                escolha = scanner.nextInt();
                
                switch (escolha) {
                    case 1:
                        
                        break;
                    case 2:
                        registrarLivro(usuario);
                        break;
                    case 3:
                        visualizarLivros();
                        break;
                    case 4:
                       
                        break;
                    case 5:

                        break;
                    case 0:
                        System.out.println("-- Saindo...");
                        break;
                    default:
                        System.out.println("-- Opção inválida, tente novamente.");
                }

            } catch (InputMismatchException e) {
                utils.limparTerminal();
                System.out.println("-- Erro: Por favor, insira um número.");
                scanner.nextLine();
                scanner.nextLine();
                utils.limparTerminal();
            }
        }
    }

    public static void registrarLivro(Usuario usuario){
        utils.limparTerminal();
        System.out.println("-------Registro de livros-------");
        System.out.println("1 - Livro Generico");
        System.out.println("2 - Livro Biografico");
        System.out.println("3 - Livro de Ficção");
        System.out.println("4 - Livro Filosofico");
        System.out.println("5 - Livro Histórico");       
        System.out.println("0 - Sair");
        System.out.println("-- Selecione o modelo do Livro:");
        
        int escolha = utils.getInt();

        switch (escolha) {
            case 1:
                LivroGenerico livroGenerico = new LivroGenerico();
                livroGenerico.criar();
                usuario.setLivro(livroGenerico);
                break;
            case 2:
                LivroBiografia livroBiografia = new LivroBiografia();
                livroBiografia.criar();
                usuario.setLivro(livroBiografia);
                break;
            case 3:
                LivroFiccao livroFiccao= new LivroFiccao();
                livroFiccao.criar();
                usuario.setLivro(livroFiccao);
                break;
            case 4:
                LivroFilosofico livroFilosofico = new LivroFilosofico();
                livroFilosofico.criar();
                usuario.setLivro(livroFilosofico);   
                break;
            case 5:
                LivroHistorico livroHistorico = new LivroHistorico();
                livroHistorico.criar();
                usuario.setLivro(livroHistorico);
                break;
            case 0:
                System.out.println("-- Saindo...");
                break;
            default:
                System.out.println("-- Opção inválida, tente novamente.");
        }
    }

    public static void visualizarLivros(){
        System.out.println("-------Visualização de livros-------");
        System.out.println("1 - Todos os livros");
        System.out.println("2 - Livros para ler");
        System.out.println("3 - Livros que está lendo");
        System.out.println("4 - Livros lidos");
        System.out.println("0 - Voltar");
        System.out.println("-- Selecione a opção de visualização de livros:");
    }
}

