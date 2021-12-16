class Range {
  private double s;

  public Range (double range){
    this.s = range;
  }

  public double getRange(){
    double rg = 0;
     if (s <= 400.00){
          rg = 0.15;
    }
    if (s >= 400.01 && s <= 800.00){
          rg = 0.12;
    }
    if (s >= 800.01 && s <= 1200.00){
          rg = 0.10;
    }
    if (s >= 1200.01 && s <= 2000.00){
          rg = 0.07;
    }
    if (s > 2000.00){
          rg = 0.04;
    }

    return rg;
  }

}