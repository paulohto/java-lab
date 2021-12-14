public class Mamifero extends Vertebrado {
  private String tipo3;

  public Mamifero (String t1, String t2, String t3){
    super(t1, t2);
    this.tipo3 = t3;
  }

  public void nomeAnimal(){
    if (tipo3.equals("onivoro")) {
      System.out.println("homem");
    }
    if (tipo3.equals("herbivoro")) {
      System.out.println("vaca");
    }
  }
} 