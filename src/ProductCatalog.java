public class ProductCatalog {
    Product[] products = new Product[100];
    static final int nMax = 100;
    int numberOfCatalog = 0;

    void printProducts() {
        if (numberOfCatalog==0){
            System.out.println("Nu exista produse in catalor");
            return;
        }
        System.out.println("Lista produselor este: ");
        for (int i = 0; i < numberOfCatalog; i++) {
            System.out.println(i+1 + ". Produs: " + products[i]);
        }
    }

    boolean addProduct(Product product) {
        boolean add = true;
        if (numberOfCatalog >= nMax) {
            add = false;
        } else {
            for (int i = 0; i <= numberOfCatalog; i++) {
                if (products[i] == product) {
                    add = false;
                    break;
                }
            }
        }
        if (add) {
            products[numberOfCatalog] = product;
            numberOfCatalog++;
        }
        return add;
    }

    Product getProductByName(String product) {
        Product getProduct;
        int j = findProduct(product);
        if (j == -1) {
            getProduct = null;
        } else {
            getProduct = products[j];
        }
        return getProduct;
    }

    boolean deleteProduct(String delProduct) {
        boolean isProduct;
        int j = findProduct(delProduct);
        if (j == -1) {
            isProduct = false;
        } else {
            isProduct = true;
            for (int i = j; i < (numberOfCatalog - 1); i++) {
                products[i] = products[i + 1];
            }
            products[numberOfCatalog - 1] = null;
            numberOfCatalog--;
        }
        return isProduct;
    }

    int findProduct(String product) {
        int index = -1;
        for (int i = 0; i < numberOfCatalog; i++) {
            if (product.equals(products[i].name)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
