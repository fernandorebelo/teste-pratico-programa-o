package entity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Funcionario extends Pessoa implements Comparable{

	private BigDecimal salario;
	private String funcao;
	
	public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
		super(nome, dataNascimento);
		this.salario = salario;
		this.funcao = funcao;
	}
	public BigDecimal getSalario() {
		return salario;
	}
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	
	@Override
	public String toString() {
		return "Nome=" + getNome() + ", Data de Nascimento=" + getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ", Salário="
				+ getSalario().toString().format("%,.2f", salario.setScale(2, RoundingMode.UP)) + ", Função=" + getFuncao();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(funcao, salario);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return Objects.equals(funcao, other.funcao) && Objects.equals(salario, other.salario);
	}
	
	public int compareTo(Object o) {
        Funcionario e = (Funcionario) o;
        return this.getNome().compareToIgnoreCase(e.getNome());
    }
	
}
