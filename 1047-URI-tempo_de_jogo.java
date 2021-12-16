import java.util.Scanner;
import java.io.IOException;

class Main {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);

    int h1 = sc.nextInt();
    int m1 = sc.nextInt();

    int h2 = sc.nextInt();
    int m2 = sc.nextInt();

    int th;
    double tm;
    int tt = 24*60;
    int tdif;

    //

    int th1 = (h1*60)+m1;
    int th2 = (h2*60)+m2;

    if (th2 <= th1) {
        tdif = th1 - th2;

        th = (tt - tdif) / 60;
        tm = (tt - tdif) % 60;
    } else {
      th = (th2 - th1) / 60;
      tm = (th2 - th1) % 60;
    }

    System.out.print("O JOGO DUROU " + th + " HORA(S) E ");
    System.out.printf("%.0f MINUTO(S)" , tm);
    System.out.println();

  }
}
