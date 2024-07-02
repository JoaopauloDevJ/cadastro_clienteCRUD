package br.com.paulo;

import br.com.paulo.DAO.ClienteMapDAO;
import br.com.paulo.DAO.IClienteDAO;

import javax.swing.*;

/**
 * @author João Paulo
 */

public class App {
    private static IClienteDAO iClienteDAO;

    public static void main(String[] args) {
        iClienteDAO = new ClienteMapDAO();

        String opcao = JOptionPane.showInputDialog(null,
                "Digite o número das opções que deseja seguir: 1 - Cadastro, 2 - Consulta, 3 - Editar, 4 - Excluir, 5 - sair",
                "Bem vindo", JOptionPane.INFORMATION_MESSAGE);

        while(!isOpcaoValida(opcao)) {
            if("".equals(opcao)) {
                sair();
            }
            opcao = JOptionPane.showInputDialog(null,
                    "Opção inválida, digite o número das opções que deseja seguir: 1 - Cadastro, 2 - Consulta, 3 - Editar, 4 - Excluir, 5 - sair",
                    "Opção inválida", JOptionPane.INFORMATION_MESSAGE);
        }

        while(isOpcaoValida(opcao)) {
            if(isOpcaoSair(opcao)) {
                sair();
            }
        }
    }

    private static void sair() {
        JOptionPane.showMessageDialog(null, "Até logo", "Longout", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    public static boolean isOpcaoSair(String opcao) {
        if("5".equals(opcao)) {
            return true;
        }
        return false;
    }

    public static boolean isOpcaoValida(String opcao) {
        if("1".equals(opcao) || "2".equals(opcao) || "3".equals(opcao) ||
                "4".equals(opcao) || "5".equals(opcao)) {
            return true;
        }
        return false;
    }
}
