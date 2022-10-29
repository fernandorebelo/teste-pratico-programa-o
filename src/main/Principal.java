package main;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.time.Clock;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entity.Auxiliar;
import entity.Funcionario;

public class Principal {

	public static void main(String[] args) {
		
		List<Funcionario> lista = new ArrayList<>();
		
		lista.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
		lista.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
		lista.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
		lista.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
		lista.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
		lista.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
		lista.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.87"), "Contador"));
		lista.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
		lista.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.84"), "Eletricista"));
		lista.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));
		

		System.out.println("LISTA DE FUNCIONÁRIOS COMPLETA:");
	    for(int i = 0; i < lista.size(); i++)
	    {
	        System.out.print(lista.get(i) + "\n");
	    }
	    System.out.println();
			
	    
	    
	    /*
	     * TODO Remover "João" da lista.
	     */
	    for(int i = 0; i < lista.size(); i++)
	    {
	    	Funcionario funcionario = lista.get(i);
	    	
	        if(funcionario.getNome().equals("João"))
	        {
	            lista.remove(funcionario);
	            break;
	        }
	    }
	    
	    System.out.println("LISTA DE FUNCIONÁRIOS SEM O JOÃO:");
	    for(int i = 0; i < lista.size(); i++)
	    {
	        System.out.print(lista.get(i) + "\n");
	    }
	    System.out.println();
	    
	    
	    
	    /*
	     * TODO Os funcionários receberam 10% de aumento de salário, 
	     * atualizar a lista de funcionários com novo valor.
	     */
	    
	    for(int i = 0; i < lista.size(); i++) {
	    	Funcionario funcionario = lista.get(i);
	    	BigDecimal aumento = new BigDecimal("1.1");
	    	BigDecimal resultado = aumento.multiply(funcionario.getSalario());
	    	funcionario.setSalario(resultado);
	    }

	    System.out.println("LISTA DE FUNCIONÁRIOS COM AUMENTO DE 10% NO SALÁRIO:");
	    for(int i = 0; i < lista.size(); i++)
	    {
	        System.out.print(lista.get(i) + "\n");
	    }
	    System.out.println();
	    
	    
	    
	    
	    /*
	     * TODO Agrupar os funcionários por função em um MAP, 
	     * sendo a chave a “função” e o valor a “lista de funcionários”.
	     */
	    Map<String, List<Funcionario>> listaAgrupadaPorFuncao = new HashMap<String, List<Funcionario>>();
	    
	    /*
	     * TODO Imprimir os funcionários, agrupados por função.
	     */
	    System.out.println("LISTA DE FUNCIONÁRIOS AGRUPADOS POR FUNÇÃO:");
	    for (Funcionario funcionario : lista) {
			String funcao = funcionario.getFuncao();
			List<Funcionario> listaFuncoesEncontradas = listaAgrupadaPorFuncao.get(funcao);
			if(listaFuncoesEncontradas == null) {
				listaFuncoesEncontradas = new ArrayList<>();
				listaFuncoesEncontradas.add(funcionario);
				listaAgrupadaPorFuncao.put(funcao, listaFuncoesEncontradas);
				continue;
			}
			listaFuncoesEncontradas.add(funcionario);
		}
	    System.out.println(listaAgrupadaPorFuncao);
	    System.out.println();
	    
	    
	    
	    /*
	     * TODO Imprimir os funcionários que fazem aniversário no mês 10 e 12.
	     */
	    System.out.println("LISTA DE FUNCIONÁRIOS QUE FAZEM ANIVERSÁRIO NO MÊS 10 E 12:");
	    List<Funcionario> listaPorMes = new ArrayList<Funcionario>();
	    for (Funcionario funcionario : lista) {
			if(funcionario.getDataNascimento().getMonthValue() == 10 || funcionario.getDataNascimento().getMonthValue() == 12) {
				listaPorMes.add(funcionario);
			}
		}
	    System.out.println(listaPorMes);
	    System.out.println();
	    
	    
	    
	    /*
	     * TODO Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.
	     */
	    System.out.println("IMPRIMIR FUNCIONÁRIO COM MAIOR IDADE E EXIBIR NOME E IDADE");
	    int idade1 = 0;
	    String nome = "";
	    for (Funcionario funcionario : lista) {
			int idade2 = LocalDate.now().getYear() - funcionario.getDataNascimento().getYear();
			if(idade1 < idade2) {
				idade1 = idade2;
				nome = funcionario.getNome();
			}
		}
	    System.out.println("Nome: " + nome + "\nIdade: " + idade1 + " anos");
	    System.out.println();
	    
	    /*
	     * TODO Imprimir a lista de funcionários por ordem alfabética.
	     */
	    System.out.println("LISTA DE FUNCIONÁRIOS POR ORDEM ALFABÉTICA");
	    Auxiliar.Ordenar(lista);
//	    lista.sort(null);
	    for (Funcionario funcionario : lista) {
			System.out.println(funcionario.getNome());
		}
	    System.out.println();
	    
	    
	    
	    /*
	     * TODO Imprimir o total dos salários dos funcionários.
	     */
	    System.out.println("SOMA TOTAL DO SALÁRIOS DOS FUNCIONÁRIOS (JÁ COM 10% DE AUMENTO)");
	    BigDecimal somaTotal = new BigDecimal("0");
	    for (Funcionario funcionario : lista) {
			BigDecimal salario = funcionario.getSalario();
			somaTotal = salario.add(somaTotal);
		}
	    System.out.println("Soma total: " + somaTotal.toString().format("R$%,.2f", somaTotal.setScale(2, RoundingMode.UP)));
	    System.out.println();
	    
	    
	    
	    /*
	     * TODO Imprimir quantos salários mínimos ganha cada funcionário, 
	     * considerando que o salário mínimo é R$1212.00.
	     */
	    System.out.println("QUANTIDADE DE SALÁRIO MÍNIMO QUE CADA FUNCIONÁRIO RECEBE");
	    BigDecimal salarioMinino = new BigDecimal("1212.0");
	    for (Funcionario funcionario : lista) {
			BigDecimal salario = funcionario.getSalario();
			BigDecimal quantidadeSalMin = salario.divide(salarioMinino, 2, RoundingMode.UP);
			System.out.println(funcionario.getNome() + ": " + quantidadeSalMin + " salários mínimos");
		}
	    System.out.println();
	    
	}

}
