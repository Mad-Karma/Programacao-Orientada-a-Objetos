    package src;

    import java.io.File;

    public class Main {
        public static void main(String[] args) {
            File file = new File("StoreData.bin");

            if (file.exists() && !file.isDirectory()) {
                Store store_carregada = Store.carregarStore("StoreData.bin");
                System.out.println("Store carregada do arquivo.");

                Login login = new Login(store_carregada);

                login.exibirLogin();

                Store.salvarStore(store_carregada, "StoreData.bin");
            } else {
                Store store = new Store();

                Login login = new Login(store);

                login.exibirLogin();

                Store.salvarStore(store, "StoreData.bin");
            }
        }
    }
