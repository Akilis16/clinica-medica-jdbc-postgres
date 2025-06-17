package clinica_medica;

import java.util.Scanner;

import clinica_medica.conexao.Banco;
import clinica_medica.comandos.ConsultaBanco;
import clinica_medica.comandos.AtualizarBanco;
import clinica_medica.comandos.DeletarBanco;
import clinica_medica.comandos.InserirBanco;
import clinica_medica.comandos.LeitorDados;
import clinica_medica.entidades.ClinicaMedica;
import clinica_medica.entidades.Consulta;
import clinica_medica.entidades.Medico;
import clinica_medica.entidades.Paciente;
import clinica_medica.entidades.Pagamento;
import clinica_medica.entidades.Prescricao;

public class ClinicaAplicacao {

    private static Banco banco = new Banco();
    private static ConsultaBanco consultaBanco = new ConsultaBanco(banco);
    private static AtualizarBanco atualizarBanco = new AtualizarBanco(banco);
    private static DeletarBanco deletarBanco = new DeletarBanco(banco);
    private static InserirBanco inserirBanco = new InserirBanco(banco);
    private static LeitorDados leitorDados = new LeitorDados();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            exibirMenu();
            String opcao = sc.nextLine();

            switch (opcao) {
                case "1":
                    visualizarDados(sc);
                    break;
                case "2":
                    inserirDados(sc);
                    break;
                case "3":
                    atualizarDados(sc);
                    break;
                case "4":
                    deletarDados(sc);
                    break;
                case "0":
                    System.out.println("Encerrando aplicação...");
                    banco.desconectar();
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("\n=== Clínica Médica - Menu Principal ===");
        System.out.println("1 - Visualizar tabelas e views");
        System.out.println("2 - Inserir registro");
        System.out.println("3 - Atualizar registro");
        System.out.println("4 - Deletar registro");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void visualizarDados(Scanner sc) {
        System.out.println("\nVisualizar:");
        System.out.println("1 - Clínicas Médicas");
        System.out.println("2 - Médicos");
        System.out.println("3 - Pacientes");
        System.out.println("4 - Consultas");
        System.out.println("5 - Pagamentos");
        System.out.println("6 - Prescrições");
        System.out.println("7 - View: Consultas Completas");
        System.out.println("8 - View: Prescrições Paciente");
        System.out.println("9 - View: Consultas com Pagamento");
        System.out.println("10 - Total de Consultas por Médico");
        System.out.print("Escolha uma opção: ");
        String opcao = sc.nextLine();

        switch (opcao) {
            case "1":
                consultaBanco.consultarClinicasMedica();
                break;
            case "2":
                consultaBanco.consultarMedicos();
                break;
            case "3":
                consultaBanco.consultarPacientes();
                break;
            case "4":
                consultaBanco.consultarConsultas();
                break;
            case "5":
                consultaBanco.consultarPagamentos();
                break;
            case "6":
                consultaBanco.consultarPrescricao();
                break;
            case "7":
                consultaBanco.viewConsultasCompletas();
                break;
            case "8":
                consultaBanco.viewPrescricoesPaciente() ;
                break;
            case "9":
                consultaBanco.viewConsultasComPagamento();  
                break;
            case "10":
                System.out.print("Digite o CRM do médico: ");
                String crm = sc.nextLine();
                Medico medico = consultaBanco.getMedico(crm);
                try {
                    consultaBanco.totalConsultasMedico(medico);
                } catch (Exception e) {
                    System.out.println("Erro ao obter total de consultas: " + e.getMessage());
                }
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }


    private static void inserirDados(Scanner sc) {
        System.out.println("\nInserir dados:");
        System.out.println("1 - Clínica Médica");
        System.out.println("2 - Médico");
        System.out.println("3 - Paciente");
        System.out.println("4 - Consulta");
        System.out.println("5 - Pagamento");
        System.out.println("6 - Prescrição");
        System.out.print("Escolha uma opção: ");
        String opcao = sc.nextLine();

        switch (opcao) {
            case "1":
                ClinicaMedica novaClinica = leitorDados.leDadosClinica(sc);
                inserirBanco.inserirClinicaMedica(novaClinica);
                break;
            case "2":
                Medico novoMedico = leitorDados.leDadosMedico(sc);
                inserirBanco.inserirMedico(novoMedico);
                break;
            case "3":
                Paciente novoPaciente = leitorDados.leDadosPaciente(sc);
                inserirBanco.inserirPaciente(novoPaciente);
                break;
            case "4":
                Consulta novaConsulta = leitorDados.leDadosConsulta(sc);
                inserirBanco.inserirConsulta(novaConsulta);
                break;
            case "5":
                Pagamento novoPagamento = leitorDados.leDadosPagamento(sc);
                inserirBanco.inserirPagamento(novoPagamento);
                break;
            case "6":
                Prescricao novaPrescricao = leitorDados.leDadosPrescricao(sc);
                inserirBanco.inserirPrescricao(novaPrescricao);
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private static void atualizarDados(Scanner sc) {
        System.out.println("\nAtualizar dados:");
        System.out.println("1 - Clínica Médica");
        System.out.println("2 - Médico");
        System.out.println("3 - Paciente");
        System.out.println("4 - Consulta");
        System.out.println("5 - Atualizar status de uma consulta");
        System.out.println("6 - Pagamento");
        System.out.println("7 - Prescrição");
        System.out.print("Escolha uma opção: ");
        String opcao = sc.nextLine();

        switch (opcao) {
            case "1":
                ClinicaMedica clinicaAtual = leitorDados.leDadosClinica(sc);
                atualizarBanco.atualizarClinicaMedica(clinicaAtual);
                break;
            case "2":
                Medico medicoAtual = leitorDados.leDadosMedico(sc);
                atualizarBanco.atualizarMedico(medicoAtual);
                break;
            case "3":
                Paciente pacienteAtual = leitorDados.leDadosPaciente(sc);
                atualizarBanco.atualizarPaciente(pacienteAtual);
                break;
            case "4":
                Consulta consultaAtual = leitorDados.leDadosConsulta(sc);
                atualizarBanco.atualizarConsulta(consultaAtual);
                break;
            case "5":
                try {
                    System.out.print("Digite o ID da consulta: ");
                    Integer idConsulta = Integer.parseInt(sc.nextLine());
                    System.out.print("Digite o novo status: ");
                    String novoStatus = sc.nextLine();
                    atualizarBanco.atualizarStatusConsulta(idConsulta, novoStatus);
                } catch (Exception e) {
                    System.out.println("Erro na busca, ou ID consulta invalido!");
                }
                break;
            case "6":
                Pagamento pagamentoAtual = leitorDados.leDadosPagamento(sc);
                atualizarBanco.atualizarPagamento(pagamentoAtual);
                break;
            case "7":
                Prescricao prescricaoAtual = leitorDados.leDadosPrescricao(sc);
                atualizarBanco.atualizarPrescricao(prescricaoAtual);
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private static void deletarDados(Scanner sc) {
        System.out.println("\nDeletar dados:");
        System.out.println("1 - Clínica Médica");
        System.out.println("2 - Médico");
        System.out.println("3 - Paciente");
        System.out.println("4 - Consulta");
        System.out.println("5 - Pagamento");
        System.out.println("6 - Prescrição");
        System.out.print("Escolha uma opção: ");
        String opcao = sc.nextLine();

        try {
            switch (opcao) {
                case "1":
                    System.out.print("Digite o CNPJ da clínica: ");
                    String cnpj = sc.nextLine();
                    deletarBanco.deletarClinicaMedica(cnpj);
                    break;
                case "2":
                    System.out.print("Digite o CRM do médico: ");
                    String crm = sc.nextLine();
                    deletarBanco.deletarMedico(crm);
                    break;
                case "3":
                    System.out.print("Digite o CPF do paciente: ");
                    String cpf = sc.nextLine();
                    deletarBanco.deletarPaciente(cpf);
                    break;
                case "4":
                    System.out.print("Digite o ID da consulta: ");
                    int idConsulta = Integer.parseInt(sc.nextLine());
                    deletarBanco.deletarConsulta(idConsulta);
                    break;
                case "5":
                    System.out.print("Digite o ID do pagamento: ");
                    int idPagamento = Integer.parseInt(sc.nextLine());
                    deletarBanco.deletarPagamento(idPagamento);
                    break;
                case "6":
                    System.out.print("Digite o ID da prescrição: ");
                    int idPrescricao = Integer.parseInt(sc.nextLine());
                    deletarBanco.deletarPrescricao(idPrescricao);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida, esperado número.");
        }
    }
}
