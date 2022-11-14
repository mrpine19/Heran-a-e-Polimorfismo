package aula.ExercicioDeFixacao.entities;

public class ImportedProduct extends Product {
    double customsFree;

    public ImportedProduct(String name, double price, double customsFree) {
        super(name, price);
        this.customsFree = customsFree;
    }

    public double getCustomsFree() {
        return customsFree;
    }

    public void setCustomsFree(double customsFree) {
        this.customsFree = customsFree;
    }

    public double totalPrice(){
        return getPrice() + customsFree;
    }
    @Override
    public String priceTag(){
        return name
                    + " $ "
                    + String.format("%.2f", totalPrice())
                    + " (Customs free: $ "
                    + String.format("%.2f", customsFree)
                    + ")";
    }
}
