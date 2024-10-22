package br.uffs.bibliotecapessoal.biblioteca;

import java.util.ArrayList;

import java.util.Scanner;
import br.uffs.bibliotecapessoal.utils.*;
import br.uffs.bibliotecapessoal.usuario.*;


abstract public class BibliotecaUsuario{
    public static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();    

    public static void opcoes() {
        int escolha = -1;

        while (escolha != 0) {
            utils.limparTerminal();
            System.out.println("------- Usuário --------");
            System.out.println("1 - Selecionar Usuario");
            System.out.println("2 - Criar Usuario");
            System.out.println("3 - Excluir Usuario");
            System.out.println("4 - Editar Nome do Usuario");
            System.out.println("0 - Sair");
            System.out.print("-- Escolha uma opção: \n");
            
            escolha = utils.getInt();
            switch (escolha) {
                case 1:
                    selecionarUsuario();
                    break;
                case 2:
                    criarUsuario();
                    break;
                case 3:
                    excluirUsuario();
                    break;
                case 4:
                    editarNomeUsuario();
                    break;
                case 0:
                    System.out.println("-- Saindo...");
                    break;
                default:
                    System.out.println("-- Opção inválida, tente novamente.");
                }
        }
    }

    public static void selecionarUsuario(){
        utils.limparTerminal();
        System.out.println("-------- Seleção do Usuário -------");
        BibliotecaUsuario.printUsuarios();
        System.out.println("\n-- Digite o número do Usuário:");
        int i = utils.getInt();
        Usuario u = null;
        if (i <= listaUsuarios.size()){
            u = listaUsuarios.get(i - 1);
        }else{
            System.out.println("-- Opção inválida");
            scanner.nextLine();
            scanner.nextLine();
            return ;
        }
        System.out.println("-- Digite a senha:");
        int senha = utils.getInt();
        if (senha == u.getSenha()){
            BibliotecaLivro.opcoes(u);
        }else{
            System.out.println("-- Senha errada");
            scanner.nextLine();
            scanner.nextLine();
        }
        
    }

    public static void criarUsuario(){
        utils.limparTerminal();
        System.out.println("--------- Criar Úsuario ---------");
        System.out.println("-- Digite um nome para seu Usuário");
        String nome = getUserNome();
        System.out.println("-- Digite uma senha para o Usuário");
        int senha = utils.getInt();
        Usuario usuario = new Usuario(nome, senha);

        listaUsuarios.add(usuario);
        
        System.out.println("-- Usuario criado!!");
        scanner.nextLine();
        utils.limparTerminal();
    }

    public static void excluirUsuario(){
        int flag = 0;
        utils.limparTerminal();
        System.out.println("----- Excluir Usuario ------");
        System.out.println("-- Digite o nome do usuário:");
        String nome = scanner.next();
        if (!nomeExiste(nome)){
            System.out.println("-- ERRO: Nome não existe");
            return;
        }
        Usuario usuario = null;
        for(Usuario u : listaUsuarios){
            if (nome.equals(u.getNome())){
                flag = 1;
                usuario = u;
                break;
            }
        }
        if (flag == 1){
            listaUsuarios.remove(usuario);            
            System.out.println("-- Usuário " + nome + " excluido");
            scanner.nextLine();
            scanner.nextLine();
            utils.limparTerminal();
        }else{
            System.out.println("-- Usuário " + nome + " não existe");
            scanner.nextLine();
            scanner.nextLine();
            utils.limparTerminal();
        }
    }

    public static void editarNomeUsuario(){
        utils.limparTerminal();
        System.out.println("----- Editar Usuário -----");
        printUsuarios();
        System.out.println("-- Digite o número do usuário:");
        int i = utils.getInt();
        Usuario usuario = null;
        if (i <= listaUsuarios.size()){
            usuario = listaUsuarios.get(i - 1);
        }else{
            System.out.println("-- Opção inválida");
            scanner.nextLine();
            scanner.nextLine();
            return ;
        }
        System.out.println("-- Novo Nome:");
        String nome = scanner.next();
        usuario.setNome(nome);
        System.out.println("-- Nome modificado!!");
        scanner.nextLine();
        scanner.nextLine();
    }

    public static void printUsuarios(){
        int i = 1;
        for (Usuario u : listaUsuarios){
            System.out.println(i + " - " + u.getNome());
            i++;
        }
    }

    public static boolean nomeExiste(String nome){
        for(Usuario u : listaUsuarios){
            if(u.getNome().equals(nome)){
                return true;
            }
        }
        return false;
    }

    public static String getUserNome(){
        String nome;
        while(true){
            nome = scanner.next();
            if (nomeExiste(nome)){
                System.out.println("-- O nome digitado já existe");
                System.out.println("-- Digite um nome válido");
                continue;
            }else{
                break;
            }
        }
        return nome;
    }
}