import java.util.Scanner;

public class CalorieCounter {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int option;
        String name;
        int fats;
        int carbohydrates;
        int proteins;
        ProductCatalog productCatalog = new ProductCatalog();

        do {
            printMenu();
            option = console.nextInt();
            performSelectedAction(productCatalog, option, console);
        } while (option != 6);
    }

    public static void performSelectedAction(ProductCatalog productCatalog, int option, Scanner console) {
        switch (option) {
            case 1:
                System.out.println("Adauga un produs si calculeza-i caloriile:");
                System.out.println("Introdu numele produsului ");
                String name = console.next();
                System.out.println("Introdu nr. de grasimi ");
                int fats = console.nextInt();
                System.out.println("Introdu nr. de carbohidrati ");
                int carbohydrates = console.nextInt();
                System.out.println("Introdu nr. de proteine ");
                int proteins = console.nextInt();
                Product newProduct = new Product(name, fats, carbohydrates, proteins);
                newProduct.totalCalories = Product.computeCalories(fats, carbohydrates, proteins);
                if (productCatalog.addProduct(newProduct)) {
                    System.out.println("Produsul a fost adaugat ");
                } else {
                    System.out.println("Produsul se afla deja in lista sau lista este deja plina ");
                }
                System.out.println("Numarul total de calorii aferent produsului " + newProduct.name + " este " + newProduct.totalCalories);
                break;
            case 2:
                System.out.println("Introdu produsul pentru care vrei sa-i calculezi caloriile:");
                System.out.println("Introdu numele produsului ");
                name = console.next();
                System.out.println("Introdu nr. de grasimi ");
                fats = console.nextInt();
                System.out.println("Introdu nr. de carbohidrati ");
                carbohydrates = console.nextInt();
                System.out.println("Introdu nr. de proteine ");
                proteins = console.nextInt();
                int totalCalories1 = Product.computeCalories(fats, carbohydrates, proteins);
                System.out.println("Numarul total de calori al produsului " + name + " este " + totalCalories1);
                break;
            case 3:
                System.out.println("Am afisat toate produsele din catalog si caloriile aferente: ");
                productCatalog.printProducts();
                break;
            case 4:
                System.out.println("Introdu numele produsului pe care doresti sa il stergi ");
                String delProduct = console.next();
                if (productCatalog.deleteProduct(delProduct)) {
                    System.out.println("Stergerea produsului s-a efectuat cu succes ");
                } else {
                    System.out.println("Produsul pe care doreai sa-l stergi nu se afla in catalog ");
                }
                ;
                break;
            case 5:
                System.out.println("Introdu numele produsului pe care il cauti ");
                String findProduct = console.next();
                Product getProduct = productCatalog.getProductByName(findProduct);
                if (getProduct == null) {
                    System.out.println("Produsul cautat nu a fost gasit in lista ");
                } else
                    System.out.println("Produsul: " + getProduct);
                break;
            case 6:
                System.out.println("Ai iesit din aplicatie");
                break;
            default:
                System.out.println("Optiunea introdusa este invalida, mai incearca odata!");
        }
    }

    public static void printMenu() {
        System.out.println("MENIU:");
        System.out.println("1. Adauga produs in calculator si calculeaza-i caloriile");
        System.out.println("2. Calculeaza caloriile pentru un produs fara a fi adaugat in catalog");
        System.out.println("3. Afiseaza toate produsele din catalog si caloriile pentru fiecare");
        System.out.println("4. Sterge un produs din catalog");
        System.out.println("5. Gaseste produs dupa nume");
        System.out.println("6. Iesi din aplicatie");
        System.out.println("_________________________________________");
        System.out.println("Alege actiunea cu numarul: ");
    }
}