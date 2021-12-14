public class Ave extends Vertebrado {
  private String tipo3;

  public Ave (String t1, String t2, String t3){
    super(t1, t2);
    this.tipo3 = t3;
  }

  public void nomeAnimal(){
    if (tipo3.equals("carnivoro")) {
      System.out.println("aguia");
    }
    if (tipo3.equals("onivoro")) {
      System.out.println("pomba");
    }
  }
} 