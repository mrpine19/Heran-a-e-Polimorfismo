package aula.exercícioResolvido.application;

import aula.exercícioResolvido.entities.Employee;
import aula.exercícioResolvido.entities.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o número de funcionários: ");
        int n = sc.nextInt();

        List<Employee> list = new ArrayList<>();

        for (int i=1; i<=n; i++){
            System.out.println("Funcionário #"+i+" data: ");
            System.out.print("O funciário é terceiro? (s/n) ");
            char ch = sc.next().charAt(0);
            System.out.print("Nome: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Horas: ");
            int hours = sc.nextInt();
            System.out.print("Valor por hora: ");
            double valuePerHour = sc.nextDouble();

            if (ch == 's'){
                System.out.print("Taxa adicional: ");
                double additionalCharge = sc.nextDouble();
                Employee emp = new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge);
                list.add(emp);
            }
            else {
                Employee emp = new Employee(name, hours, valuePerHour);
                list.add(emp);
            }

        }

        System.out.println();
        System.out.println("Payments: ");

        for (Employee emp : list){
            System.out.println(emp.getName() + " - " + emp.payment());
        }
        sc.close();
    }
}
