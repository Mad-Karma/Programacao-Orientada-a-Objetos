package src;
import java.util.Scanner;

public class Login {
    private Scanner scanner;
    private MenuPrincipal menuPrincipal;
    private MenuAdministrador menuAdministrador;
    private Store store;

    public Login(Store store) {
        this.scanner = new Scanner(System.in);
        this.menuPrincipal = new MenuPrincipal(store);
        this.menuAdministrador = new MenuAdministrador(store);
        this.store = store;
    }

    public void exibirLogin() {
        int codigo_user;
        do {
            System.out.println("\n====== Login ======");
            System.out.print("Insira o seu código de utilizador: ");
            codigo_user = scanner.nextInt();
            scanner.nextLine();
            System.out.println("\n");

            if(codigo_user == 0) {
                this.menuAdministrador.exibirMenuAdministrador();
            }
            else if(store.getUtilizador(codigo_user) != null) {
                store.setUser(codigo_user);
                this.menuPrincipal.exibirMenuPrincipal();
            }
            else {
                System.out.println("O código inserido é inválido. Tente novamente.");
            }
        } while (codigo_user != 999);
    }
}
