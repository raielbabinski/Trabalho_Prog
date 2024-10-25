package br.uffs.bibliotecapessoal.biblioteca;

import java.util.Scanner;

import java.util.ArrayList;
import br.uffs.bibliotecapessoal.livro.LivroBiografia;
import br.uffs.bibliotecapessoal.livro.LivroFiccao;
import br.uffs.bibliotecapessoal.livro.LivroFilosofico;
import br.uffs.bibliotecapessoal.livro.Livro;
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
            System.out.println("1 - Abrir Anotações");
            System.out.println("2 - Registrar Livro");
            System.out.println("3 - Visualizar Livros");
            System.out.println("4 - Mudar status do Livro");
            System.out.println("5 - Excluir Livro");
            System.out.println("6 - Editar Livro");
            System.out.println("0 - Sair da Biblioteca");
            System.out.print("-- Escolha uma opção: ");


            escolha = utils.getInt();
                
            switch (escolha) {
                case 1:
                    opcoesAnotacao(usuario);
                    break;
                case 2:
                    registrarLivro(usuario);
                    break;
                case 3:
                    visualizarLivros(usuario);
                    break;
                case 4:
                    mudarStatusLivro(usuario);
                    break;
                case 5:
                    excluirLivro(usuario);
                    break;
                case 6:
                    editarLivro(usuario);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("-- Opção inválida, tente novamente.");
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
                Livro livroGenerico = new Livro();
                livroGenerico.criarLivro();
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

    public static void visualizarLivros(Usuario usuario){
        if(usuario.getEmptyLivros()){
            System.out.println("-- Não há livros cadastrados");
            scanner.nextLine();
            return;
        }
        utils.limparTerminal();
        System.out.println("------- Visualização de livros -------");
        System.out.println("1 - Todos os livros");
        System.out.println("2 - Livros para ler");
        System.out.println("3 - Livros que está lendo");
        System.out.println("4 - Livros lidos");
        System.out.println("0 - Voltar");
        System.out.println("-- Selecione a opção de visualização de livros:");
        int escolha = utils.getInt();
        if(escolha == 0){
            return;
        }
        usuario.visualizarLivros(escolha);
        System.out.println("-- Pressione para continuar...");
        scanner.nextLine();
    }

    public static void mudarStatusLivro(Usuario usuario){
        Livro livro = null;
        String livrosLer = "\n";
        String livrosLendo = "\n";
        String livrosLidos = "\n";
        int a = 1 ,b = 1 ,c = 1;

        if (usuario.getEmptyLivros()){
            System.out.println("-- Não há livros cadastrados");
            scanner.nextLine();
            return;
        }

        int sizeLista = usuario.getSizeLista();
        for(int i = 0; i < sizeLista; i++){
            livro = usuario.getLivro(i);

            if(livro.getStatus().equals("Ler")){
                livrosLer += (a) + " - " + livro.getTitulo() + "\n";
                a++;
            }
            if(livro.getStatus().equals("Lendo")){
                livrosLendo += (b) + " - " + livro.getTitulo() + "\n";
                b++;
            }
            if(livro.getStatus().equals("Lido")){
                livrosLidos += (c) + " - " + livro.getTitulo() + "\n";
                c++;
            }

        } 
        System.out.println("---- Livros para Ler ----");
        System.out.println(livrosLer);
        System.out.println("---- Livros em Leitura ----");
        System.out.println(livrosLendo);
        System.out.println("---- Livros Lidos ----");
        System.out.println(livrosLidos);


        int escolha = 1;
        while(true){
            try{
                System.out.println("-- Digite o nome do livro que deseja mudar o status:");
                String nome = scanner.nextLine();
                livro = usuario.getLivroNome(nome);
                if (livro == null){
                    System.out.println("-- Erro: Livro não encontrado");
                    System.out.println("-- (1)Tentar novamente (0)Sair");
                    escolha = utils.getInt();
                    if(escolha == 0){
                        break;
                    }else{
                        continue;
                    }
                }
                break;
            }catch(Exception e){
                System.out.println("-- Erro: titulo não reconhecido" + e);
                System.out.println("-- (1)Tentar novamente (0)Sair");
                escolha = utils.getInt();
                if(escolha == 0){
                    break;
                }
                continue;
            }
        }

        if (escolha == 0){
            return;
        }
        System.out.println("-- Para qual status deseja mudar o " + livro.getTitulo()+ " :");
        System.out.println("-- (1)Ler (2)Lendo (3)Lido (0)Sair");
        escolha = utils.getInt();
        switch (escolha) {
            case 1:
                livro.setStatus("Ler");
                break;
            case 2:
                livro.setStatus("Lendo");
                break;
            case 3:
                livro.setStatus("Lido");
                break;
            case 0:
                escolha = 0;
                break;
            default:
                System.out.println("-- Valor não reconhecido");
        
        }
    }

    public static void excluirLivro(Usuario usuario){
        if(usuario.getEmptyLivros()){
            System.out.println("-- Não há livros cadastrados");
            scanner.nextLine();
            return;
        }
        
        int size = usuario.getSizeLista();
        utils.limparTerminal();
        System.out.println("---- Excluir Livro ----");
        for(int i = 0; i < size; i++){
            System.out.println((i+1) + " - " + usuario.getLivro(i).getTitulo());
        }
        
        int indice = 0;
        while(true){
            System.out.println("-- Selecine o livro para deletar:");
            indice = utils.getInt();
            if (indice > usuario.getSizeLista() || indice < 0){
                System.out.println("-- ERRO: Indice inválido");
                continue;
            }
            break;
        }
        

        usuario.getLivro(indice-1).printLivro(1);

        System.out.println("-- Deseja excluir esse livro?");
        System.out.println("(1)Sim  (2)Não");

        int escolha = utils.getInt();

        if (escolha == 1){
            usuario.excluirLivro(indice-1);
        }

    }

    public static void editarLivro(Usuario usuario){
        if(usuario.getEmptyLivros()){
            System.out.println("-- Não há livros cadastrados");
            scanner.nextLine();
            return;
        }
        
        int size = usuario.getSizeLista();
        utils.limparTerminal();
        System.out.println("---- Editar Livro ----");
        for(int i = 0; i < size; i++){
            System.out.println((i+1) + " - " + usuario.getLivro(i).getTitulo());
        }
        
        int indice = 0;
        while(true){
            System.out.println("-- Selecine o livro para editar:");
            indice = utils.getInt();
            if (indice > usuario.getSizeLista() || indice < 0){
                System.out.println("-- ERRO: Indice inválido");
                continue;
            }
            break;
        }

        usuario.editarLivro(indice-1);
    }    

    public static void opcoesAnotacao(Usuario usuario){
        if(usuario.getEmptyLivros()){
            System.out.println("-- Não há livros cadastrados");
            scanner.nextLine();
            return;
        }

        int size = usuario.getSizeLista();
        utils.limparTerminal();
        boolean flag = true;
        System.out.println("---- Anotações ----");
        ArrayList<Integer> indices = new ArrayList<>();
        for(int i = 0; i < size; i++){
            if(usuario.getLivro(i).getStatus().equals("Lendo")){
                System.out.println((i+1) + " - " + usuario.getLivro(i).getTitulo());
                indices.add(i);    //[0 ,2 ,4]
                flag = false;
            }
        }
        if(flag){
            System.out.println("-- Você não está lendo nenhum livro...");
            scanner.nextLine();
            return;
        }
        
        int indice = 0;
        while(true){
            System.out.println("-- Selecine o livro para ver as anotações:");
            indice = utils.getInt();
            if (indices.size() > usuario.getSizeLista() || indices.size() < 1){
                System.out.println("-- ERRO: Indice inválido");
                continue;
            }
            break;
        }

        BibliotecaAnotacao.opcoes(usuario.getLivro(indices.get(indice-1)));
    }
}