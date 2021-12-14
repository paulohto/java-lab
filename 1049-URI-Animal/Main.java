import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String t1 = sc.next();
    String t2 = sc.next();
    String t3 = sc.next();

    Animal[] tipoAnimal = new Animal[4];

    if (t1.equals("vertebrado")){
      if(t2.equals("mamifero")){
        tipoAnimal[0] = new Mamifero (t1,t2,t3);
        tipoAnimal[0].nomeAnimal();
      }
      if(t2.equals("ave")){
        tipoAnimal[1] = new Ave (t1,t2,t3);
        tipoAnimal[1].nomeAnimal();
      }
    }
    //
    if (t1.equals("invertebrado")){
      if(t2.equals("inseto")){
        tipoAnimal[2] = new Inseto (t1,t2,t3);
        tipoAnimal[2].nomeAnimal();
      }
      if(t2.equals("anelideo")){
        tipoAnimal[3] = new Anelideo (t1,t2,t3);
        tipoAnimal[3].nomeAnimal();
      }
    }

  }
}