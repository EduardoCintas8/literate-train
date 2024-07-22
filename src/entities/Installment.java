package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Installment {

	private LocalDate dueDate;
	private Double amount;

	static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public Installment() {
	}

	public Installment(LocalDate dueDate, Double amount) {
		this.amount = amount;
		this.dueDate = dueDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(dueDate.format(fmt));
		sb.append(" - " + String.format("%.2f", this.getAmount()));

		return sb.toString();

	}

}
