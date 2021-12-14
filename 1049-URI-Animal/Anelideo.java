public class Anelideo extends Invertebrado {
  private String tipo3;

  public Anelideo (String t1, String t2, String t3){
    super(t1, t2);
    this.tipo3 = t3;
  }

  public void nomeAnimal(){
    if (tipo3.equals("hematofago")) {
      System.out.println("sanguessuga");
    }
    if (tipo3.equals("onivoro")) {
      System.out.println("minhoca");
    }
  }
} 