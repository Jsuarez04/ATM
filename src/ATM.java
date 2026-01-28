import java.util.Scanner;
import java.time.LocalDateTime;

public class ATM {
    // Definimos el scanner como estático para reusarlo en toda la clase
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // 1. Inicialización de Datos
        User[] users = {
                new User("Pedro Perez", "V-20123456", "1234",
                        new Direction("Calle Alta Vista", "Puerto Ordaz", "Bolivar", "8050"),
                        "pedro@email.com", "0414-1234567"),
                new User("Maria Gomez", "V-18987654", "admin.2024",
                        new Direction("Av. Principal", "Caracas", "Distrito Capital", "8051"),
                        "maria.g@email.com", "0412-9876543"),
                new User("Juan Rodriguez", "V-25111222", "password99",
                        new Direction("Urb. Los Olivos", "Ciudad Guayana", "Bolivar", "8052"),
                        "juanr@email.com", "0424-5556677")
        };

        Account[] accounts = {
                new Account("001-P", users[0], 1500.50, LocalDateTime.now(), true, 500.0, "Ahorros"),
                new Account("002-M", users[1], 25000.00, LocalDateTime.now(), true, 2000.0, "Corriente"),
                new Account("003-J", users[2], 50.25, LocalDateTime.now(), false, 100.0, "Ahorros")
        };


        ATM atm = new ATM();

        // 2. Bucle principal del programa
        while (true) {
            atm.showMenu();
            atm.validateOptionMainMenu(accounts);
            atm.userInfo(accounts[0]);
        }

    }

    // --- MÉTODOS DE MENÚ ---

    public void showMenu() {
        System.out.println("\n=== CAJERO UNEG ===");
        System.out.println("1. Iniciar sesión");
        System.out.println("2. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public void showATMMenu() {
        System.out.println("\n--- OPERACIONES ---");
        System.out.println("1. Retirar");
        System.out.println("2. Depositar");
        System.out.println("3. Ver Saldo");
        System.out.println("4. Cerrar Sesión");
        System.out.print("Seleccione una opción: ");
    }

    // --- LÓGICA DE OPCIONES ---

    public void validateOptionMainMenu(Account[] accounts) {
        int option = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        if (option == 1) {
            login(accounts);
        } else if (option == 2) {
            System.out.println("Gracias por usar el ATM. ¡Adiós!");
            System.exit(0);
        }
    }

    public void login(Account[] accounts) {
        System.out.print("Ingrese su ID: ");
        String id = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String password = scanner.nextLine();

        Account currentAccount = findAccount(id, password, accounts);

        if (currentAccount != null) {
            System.out.println("Inicio de sesión exitoso. Bienvenido, " + currentAccount.getAccountHolder().getFullName());
            boolean inSession = true;
            while (inSession) {
                showATMMenu();
                inSession = validateOptionATMMenu(currentAccount);
            }
        } else {
            System.out.println("Credenciales incorrectas o cuenta inexistente.");
        }
    }

    public boolean validateOptionATMMenu(Account account) {
        int option = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        switch (option) {
            case 1:
                validateWithDraw(account);
                return true;
            case 2:
                validateDeposit(account);
                return true;
            case 3:
                System.out.println("Su saldo actual es: $" + account.getBalance());
                return true;
            case 4:
                return false; // Sale del bucle de sesión
            default:
                System.out.println("Opción inválida.");
                return true;
        }
    }

    // --- OPERACIONES BANCARIAS ---

    public void validateWithDraw(Account account) {
        System.out.print("Ingrese el monto a retirar: ");
        double amount = scanner.nextDouble();
        if (account.withDraw(amount)) {
            System.out.println("Retiro exitoso. Nuevo saldo: $" + account.getBalance());
        }
    }

    public void validateDeposit(Account account) {
        System.out.print("Ingrese el monto a depositar: ");
        double amount = scanner.nextDouble();
        if (account.deposit(amount)) {
            System.out.println("Depósito exitoso. Nuevo saldo: $" + account.getBalance());
        }
    }

    public Account findAccount(String id, String password, Account[] accounts) {
        for (Account acc : accounts) {
            if (id.equals(acc.getAccountHolder().getID()) && password.equals(acc.getAccountHolder().getPassword())) {
                return acc;
            }
        }
        return null;
    }

    public void userInfo(Account account){
        account.getAccountHolder().showInfo();
    }
}
