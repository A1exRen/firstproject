package scanner;

import java.util.Scanner;

public class Scanforuser {
    private Scanner scanner;

    public Scanforuser(Scanner scanner) {
        this.scanner = scanner;
    }

    public String nextLine() {
        return scanner.nextLine();

    }

    public Boolean nextBoolean() {
        return scanner.nextBoolean();
    }
}
