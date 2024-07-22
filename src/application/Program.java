package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import entities.service.ContractService;
import entities.service.PaypalService;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.println("Entre com os dados do contrato: ");
		System.out.print("Numero: ");
		Integer number = sc.nextInt();
		System.out.print("Data (dd/MM/yyyy): ");
		LocalDate date = LocalDate.parse(sc.next(), fmt);
		System.out.print("Valor do contrato: ");
		Double totalValue = sc.nextDouble();

		Contract obj = new Contract(number, date, totalValue);

		System.out.print("Entre com o numero de parcelas: ");
		int months = sc.nextInt();

		ContractService cs = new ContractService(new PaypalService());
		cs.processContract(obj, months);

		System.out.println("Parcelas:");
		for (Installment installment : obj.getInstallments()) {
			System.out.println(installment);
		}

		sc.close();
	}

}
