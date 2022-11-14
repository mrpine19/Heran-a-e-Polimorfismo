package aula.ExercicioDeFixacao.application;

import aula.ExercicioDeFixacao.entities.ImportedProduct;
import aula.ExercicioDeFixacao.entities.Product;
import aula.ExercicioDeFixacao.entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        List<Product> list = new ArrayList<>();

        System.out.print("Digite o número de produtos: ");
        int n = sc.nextInt();

        for (int i=1; i<=n; i++){
            System.out.println("Informações do produto #"+i);
            System.out.print("Comum, usado ou importado? (c/u/i) ");
            char ch = sc.next().charAt(0);
            System.out.print("Nome: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Preço: ");
            double price = sc.nextDouble();

            if (ch == 'c'){
                Product pd = new Product(name, price);
                list.add(pd);
            }
            else if (ch == 'u'){
                System.out.print("Data de fabricação (DD/MM/AAAA): ");
                Date date = sdf.parse(sc.next());
                list.add(new UsedProduct(name, price, date));
            }
            else {
                System.out.print("Taxa alfandegária: ");
                double customsFree = sc.nextDouble();
                list.add(new ImportedProduct(name, price, customsFree));
            }
        }

        System.out.println();
        System.out.println("Price tags: ");
        for (Product pd : list){
            System.out.println(pd.priceTag());
        }


        sc.close();
    }
}
