package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.Funcionario;
import entidades.FuncionarioTercerizado;

public class Programa {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Funcionario>list = new ArrayList<>();
		
		System.out.print("Entre com o n�mero de funcion�rios: ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Dados do Funcion�rio n�mero:" + i);
			System.out.print("O funcion�rio � tercerizado(s/n)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Horas:");
			int horas = sc.nextInt();
			System.out.print("Valor por hora: ");
			double valorPorHora = sc.nextDouble();
			
			if (ch == 's') {
				System.out.print("Digite o valor da Despesa Adicional: ");
				double despesaAdicional = sc.nextDouble();
				Funcionario func = new FuncionarioTercerizado(nome,horas, valorPorHora, despesaAdicional);
				list.add(func);
			}
			else {
				Funcionario func = new Funcionario(nome,horas, valorPorHora); 
					
				list.add(func);
			}
			
			
		}
		System.out.println();
		System.out.println("PAGAMENTOS: ");
		for (Funcionario func : list) {
			System.out.println(func.getNome() + " - $ " + String.format("%.2f", func.pagamento()));
		}
		sc.close();

	}

}
