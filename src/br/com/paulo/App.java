package br.com.paulo;

import br.com.paulo.DAO.ClienteMapDAO;
import br.com.paulo.DAO.IClienteDAO;
import br.com.paulo.domain.Cliente;

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
            } else if (isCadastro(opcao)) {
                String dados = JOptionPane.showInputDialog(null,
                        "Digite os seguintes dados separados por virgular: nome, cpf, telefone, endereço, número, cidade e estado.",
                        "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                cadastra(dados);
            } else if (isConsultar(opcao)) {
                String dados = JOptionPane.showInputDialog(null, "Digite o CPF que deseja consultar!",
                        "Consulta Cliente", JOptionPane.INFORMATION_MESSAGE);
                consultar(dados);
            } else if (isAlterar(opcao)) {
                String dados = JOptionPane.showInputDialog(null, "Digite o CPF que deseja alterar!",
                        "Alterar Cliente", JOptionPane.INFORMATION_MESSAGE);
            } else if (isExcluir(opcao)) {
                String dados = JOptionPane.showInputDialog(null, "Digite o CPF que deseja deletar!",
                        "Deletar Cliente", JOptionPane.INFORMATION_MESSAGE);
            }
            opcao = JOptionPane.showInputDialog(null,
                    "Opção inválida, digite o número das opções que deseja seguir: 1 - Cadastro, 2 - Consulta, 3 - Editar, 4 - Excluir, 5 - sair",
                    "Opção inválida", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void cadastra(String dados) {
        String[] dadosSeparados = dados.split(",");
        Cliente cliente = new Cliente(dadosSeparados[0], dadosSeparados[1], dadosSeparados[2],
                dadosSeparados[3], dadosSeparados[4], dadosSeparados[5], dadosSeparados[6]);

        boolean isCadastro = iClienteDAO.cadastro(cliente);

        if(isCadastro) {
            JOptionPane.showMessageDialog(null,"Cliente cadastrado com sucesso!",
                    "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            sair();
        } else {
            JOptionPane.showMessageDialog(null,
                    "Cliente já cadastrado!", "Erro", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void consultar(String dados) {
        Cliente cliente = iClienteDAO.consultar(Long.parseLong(dados));
        if (cliente != null) {
            JOptionPane.showMessageDialog(null, "Cliente consultado: " + cliente.toString(),
                    "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "CLIENTE NÃO ENCONTRADO!",
                    "Error!", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static boolean isCadastro(String opcao) {
        if("1".equals(opcao)) {
            return true;
        }
        return false;
    }

    private static boolean isConsultar(String opcao) {
        if("2".equals(opcao)) {
            return true;
        }
        return false;
    }

    private static boolean isAlterar(String opcao) {
        if ("3".equals(opcao)) {
            return true;
        }
        return false;
    }

    private static boolean isExcluir (String opcao) {
        if ("4".equals(opcao)) {
            return true;
        }
        return false;
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
