package clinica_medica.comandos;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Scanner;

import clinica_medica.entidades.ClinicaMedica;
import clinica_medica.entidades.Consulta;
import clinica_medica.entidades.Medico;
import clinica_medica.entidades.Paciente;
import clinica_medica.entidades.Pagamento;
import clinica_medica.entidades.Prescricao;

public class LeitorDados {

	public static ClinicaMedica leDadosClinica(Scanner sc) {
		ClinicaMedica clinica = new ClinicaMedica();

		System.out.println("\n== Dados da Clínica Médica ==");

		System.out.print("CNPJ: ");
		clinica.setCnpj(sc.nextLine());

		System.out.print("Nome: ");
		clinica.setNome(sc.nextLine());

		System.out.print("Telefone: ");
		clinica.setTelefone(sc.nextLine());

		System.out.print("CEP: ");
		clinica.setCepClinica(sc.nextLine());

		System.out.print("Rua: ");
		clinica.setRuaClinica(sc.nextLine());

		System.out.print("Número: ");
		clinica.setNumeroClinica(sc.nextLine());

		System.out.print("Bairro: ");
		clinica.setBairroClinica(sc.nextLine());

		System.out.print("Cidade: ");
		clinica.setCidadeClinica(sc.nextLine());

		System.out.print("Estado (UF): ");
		clinica.setEstadoClinica(sc.nextLine());

		return clinica;
	}

	public static Paciente leDadosPaciente(Scanner sc) {
		Paciente paciente = new Paciente();

		System.out.println("\n== Dados do Paciente ==");

		System.out.print("CPF: ");
		paciente.setCpf(sc.nextLine());

		System.out.print("Nome: ");
		paciente.setNome(sc.nextLine());

		System.out.print("Data de nascimento (dd/MM/yyyy): ");
		paciente.setDataNascimento(Date.valueOf(sc.next()));

		System.out.print("Telefone 1: ");
		paciente.setTelefone1(sc.nextLine());

		System.out.print("Telefone 2: ");
		paciente.setTelefone2(sc.nextLine());

		System.out.print("Email: ");
		paciente.setEmail(sc.nextLine());

		System.out.print("CEP: ");
		paciente.setCep(sc.nextLine());

		System.out.print("Rua: ");
		paciente.setRua(sc.nextLine());

		System.out.print("Número: ");
		paciente.setNumero(sc.nextLine());

		System.out.print("Bairro: ");
		paciente.setBairro(sc.nextLine());

		System.out.print("Cidade: ");
		paciente.setCidade(sc.nextLine());

		System.out.print("Estado (UF): ");
		paciente.setEstado(sc.nextLine());

		System.out.print("CNPJ da Clínica: ");
		paciente.setCnpjClinica(sc.nextLine());

		return paciente;
	}

	public static Medico leDadosMedico(Scanner sc) {
		Medico medico = new Medico();

		System.out.println("\n== Dados do Médico ==");

		System.out.print("CRM: ");
		medico.setCrm(sc.nextLine());

		System.out.print("Nome: ");
		medico.setNome(sc.nextLine());

		System.out.print("Especialidade: ");
		medico.setEspecialidade(sc.nextLine());

		System.out.print("Telefone 1: ");
		medico.setTelefone1(sc.nextLine());

		System.out.print("Telefone 2: ");
		medico.setTelefone2(sc.nextLine());

		System.out.print("Email: ");
		medico.setEmail(sc.nextLine());

		return medico;
	}

	public static Consulta leDadosConsulta(Scanner sc) {
		Consulta consulta = new Consulta();

		System.out.println("\n== Dados da Consulta ==");

		// id_consulta é SERIAL (gerado no DB), geralmente não é entrada manual, mas
		// pode adaptar se quiser
		System.out.print("Data e hora (dd/MM/yyyy HH:mm): ");
		consulta.setDataHora(Timestamp.valueOf(sc.next()));

		System.out.print("CRM do médico: ");
		consulta.setCrmMedico(sc.nextLine());

		System.out.print("CPF do paciente: ");
		consulta.setCpfPaciente(sc.nextLine());

		System.out.print("Observações: ");
		consulta.setObservacoes(sc.nextLine());

		System.out.print("Status: ");
		consulta.setStatus(sc.nextLine());

		return consulta;
	}

	public static Prescricao leDadosPrescricao(Scanner sc) {
		Prescricao prescricao = new Prescricao();

		System.out.println("\n== Dados da Prescrição ==");

		// id_prescricao é SERIAL, geralmente não informado pelo usuário
		System.out.print("ID da consulta: ");
		prescricao.setIdConsulta(Integer.parseInt(sc.nextLine()));

		System.out.print("Medicação: ");
		prescricao.setMedicacao(sc.nextLine());

		System.out.print("Orientações: ");
		prescricao.setOrientacoes(sc.nextLine());

		System.out.print("Data de emissão (dd/MM/yyyy): ");
		prescricao.setDataEmissao(Date.valueOf(sc.next()));

		System.out.print("Data de vencimento (dd/MM/yyyy): ");
		prescricao.setDataVencimento(Date.valueOf(sc.next()));

		return prescricao;
	}

	public static Pagamento leDadosPagamento(Scanner sc) {
		Pagamento pagamento = new Pagamento();

		System.out.println("\n== Dados do Pagamento ==");

		// id_pagamento é SERIAL, geralmente não inserido manualmente
		System.out.print("ID da consulta: ");
		pagamento.setIdConsulta(Integer.parseInt(sc.nextLine()));

		System.out.print("Valor: ");
		pagamento.setValor(Double.parseDouble(sc.nextLine()));

		System.out.print("Método (Cartão de crédito, Cartão de débito, Dinheiro, Pix): ");
		pagamento.setMetodo(sc.nextLine());

		System.out.print("Data do pagamento (dd/MM/yyyy): ");
		pagamento.setData(Date.valueOf(sc.next()));

		return pagamento;
	}
}
