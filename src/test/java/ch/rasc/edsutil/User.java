package ch.rasc.edsutil;

import java.math.BigDecimal;
import java.time.LocalDate;

public class User {
	private long id;
	private String name;
	private LocalDate dayOfBirth;
	private BigDecimal salary;

	public User(long id, String name, LocalDate dayOfBirth, BigDecimal salary) {
		this.id = id;
		this.name = name;
		this.dayOfBirth = dayOfBirth;
		this.salary = salary;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDayOfBirth() {
		return dayOfBirth;
	}

	public void setDayOfBirth(LocalDate dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

}
