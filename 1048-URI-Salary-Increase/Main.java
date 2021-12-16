import java.util.*;
import java.util.Scanner;
import java.io.IOException;

class Main {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);

    double s = sc.nextDouble(); 
    
    Salario ns = new Salario(s);
    Range rg = new Range(s);

    System.out.printf("Novo salario: %.2f\n",ns.getSal(rg));
    System.out.printf("Reajuste ganho: %.2f\n",ns.getRj(rg));
    System.out.printf("Em percentual: %.0f %%",ns.getPct(rg));
    System.out.println();

  }
}