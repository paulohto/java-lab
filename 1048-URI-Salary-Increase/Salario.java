class Salario{
  private double s;
  private double ns;
  private double rj;
  private double pct;

  public Salario(double salario){
    this.s = salario;
  }

  public double getSal(Range x){
      ns = s * (1 + x.getRange());
      rj = ns - s;
      pct = (ns / s - 1)*100;
      return ns;
  }
  //
  public double getRj(Range x){
      ns = s * (1 + x.getRange());
      rj = ns - s;
      pct = (ns / s - 1)*100;
      return rj;
  }
  //
    public double getPct(Range x){
        ns = s * (1 + x.getRange());
        rj = ns - s;
        pct = (ns / s - 1)*100;
        return pct;
  } 
}