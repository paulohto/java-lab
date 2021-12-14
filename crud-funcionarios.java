import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.InputMismatchException;

class Main {

public static class Funcionario {
 private String codigo;
  private String nome;
  private String cargo;
  private String salario;
  private String numdeps;
  private String bonus;

  public Funcionario(String Codigo, String Nome, String Cargo,String Salario, String Numdeps, String Bonus){
    this.codigo = Codigo;
    this.nome = Nome;
    this.cargo = Cargo;
    this.salario = Salario;
    this.numdeps = Numdeps;
    this.bonus = Bonus;
  }
  //SETTERS
  public void setCodigo(String Codigo) {
    codigo = Codigo;
  }  
  public void setNome(String Nome) {
    nome = Nome;
  }
  public void setCargo(String Cargo) {
    cargo = Cargo;
  }
  public void setSalario(String Salario) {
    salario = Salario;
  }
  public void setBonus(String Bonus) {
    bonus = Bonus;
  }
  public void setNumdeps(String Numdeps) {
    numdeps = Numdeps;
  }
  //GETTERS
  public String getCodigo() {
    return codigo;
  }
  public String getNome() {
    return nome;
  }
  public String getCargo() {
    return cargo;
  }
  public String getSalario() {
    return salario;
  }
  public String getNumdeps() {
    return numdeps;
  }
  public String getBonus() {
    return bonus;
  }
}
  
//MAIN CLASS
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
     //lista geral que será preenchida por Maps
    Map<Integer,Map> listfunc = new HashMap<Integer,Map>();

    System.out.println("\n-#- CADASTRO DE FUNCIONÁRIOS -#-\n");

  while( true ){

      System.out.println("-- -- -- -- -- -- -- -- -- -- --");
      System.out.println("1 - Cadastrar funcionário");
      int cads = 1;
      System.out.println("2 - Buscar funcionário");
      int buscar = 2;
      System.out.println("3 - Deletar funcionário");
      int delet = 3;
      System.out.println("4 - Alterar salário");
      int novosal = 4;
      System.out.println("5 - Sair");
      int fim = 5;

    try{
      System.out.print("\nSelecione uma opção: ");
      int select = sc.nextInt();

      while( select != 1 &&  select != 2 && select != 3 && select != 4 && select != 5){
        System.out.print("\nSelecione uma opção válida: ");
        select = sc.nextInt();        
      }

      System.out.println("-- -- -- -- -- -- -- -- -- -- --\n");

      double bonusdb;
      double salariodb;
      int dpts;
     
      Map<String,String> map1 = new HashMap<String,String>();
      // # 1 - CADASTRAR FUNCIONÁRIOS
      if (select == 1) {
        System.out.println("# - Cadastro de funcionário:");

    boolean continueLoop = true;
    do{
      try {
        System.out.print("Código: ");
        int cod = sc.nextInt();

          while(listfunc.get(cod) != null){
            System.out.print("Código já existente. Escolher outro. \nCódigo: ");
            cod = sc.nextInt();
          }
        String codigo = ""+cod;
        
        System.out.print("Nome: ");
        String nome = sc.next();

        System.out.print("Cargo: ");
        String cargo = sc.next();

        System.out.print("Salário: ");
        salariodb = sc.nextDouble();
        String salario = ""+salariodb;

        System.out.print("Quantidade de Dependentes: ");
        dpts = sc.nextInt();
        String numdeps = ""+dpts;

        //CALCULA BONUS
        bonusdb = (salariodb * 0.02)*dpts;
        String bonus = ""+bonusdb;
      
        Funcionario func = new Funcionario(codigo, nome, cargo, salario, numdeps, bonus);

        map1.put("CODIGO", func.getCodigo());
        map1.put("NOME", func.getNome());
        map1.put("CARGO", func.getCargo());
        map1.put("SALARIO", func.getSalario());
        map1.put("DEPENDENTES", func.getNumdeps());
        map1.put("BONUS", func.getBonus());

        listfunc.put(cod, map1);

        continueLoop = false;
        // FIM DO TRY - CADATRAR
      } catch (InputMismatchException e) {
        System.out.println("ERRO! Digite apenas números.\n");
        sc.nextLine();
      } 
    }  while (continueLoop); // LAÇO CASO TENHA ENTREADA ALGUMA LETRA
      }

      // # 2 - BUSCAR FUNCIONÁRIOS
      if(select == 2){
        if(!listfunc.isEmpty()){
          System.out.println("# - Pesquisar por Funcionário: ");

        boolean continueLoop = true;
        do{
          try {
          System.out.print("Qual o código do funcionário:  ");
          int y = sc.nextInt();

          // CASO CÓDIGO INEXISTENTE
            while(listfunc.get(y) == null) {
                System.out.print("Funcionário Inexistente. Digite outro código: ");
                y = sc.nextInt();   
            }

          Map<String,String> mapShow = new HashMap<String,String>();
          mapShow = listfunc.get(y);
          mapShow.forEach((k, v) -> System.out.println(String.format("%s: %s", k, v)));

          continueLoop = false;
          //FIM DO TRY - BUSCA FUNCIONÁRIO 
          } catch (InputMismatchException e) {
          System.out.println("ERRO! Digite apenas números.\n");
          sc.nextLine();
          } 
        } while (continueLoop); // LAÇO CASO TENHA ENTREADA ALGUMA LETRA
        
        } else { 
          System.out.println("#- Nenhum funcionário cadastrado.\n");
          continue; 
        } 
      }

      // # 3 -  DELETAR FUNCIONÁRIOS
      if(select == 3){
        if(!listfunc.isEmpty()){
        System.out.println("# - Deletar Funcionário: ");

        boolean continueLoop = true;
      do{
        try {
         System.out.print("Qual o código do funcionário:  ");
          int y = sc.nextInt();

          // CASO CÓDIGO INEXISTENTE
          while(listfunc.get(y) == null){
              System.out.print("Funcionário Inexistente: ");
              y = sc.nextInt();
          }
         listfunc.remove(y);

        continueLoop = false;
        //FIM DO TRY - DELETAR FUNCIONÁRIO
        } catch (InputMismatchException e){
          System.out.println("ERRO! Digite apenas números.\n");
          sc.nextLine();
        }
      } while (continueLoop); // LAÇO CASO TENHA ENTREADA ALGUMA LETRA

        }else { 
          System.out.println("#- Nenhum funcionário cadastrado.\n");
          continue; 
        }      
      }

      double mudasal;
      String strnovosal = "";
      double novobonus;

      // # 4 - ALTERAR SALÁRIO
      if(select == 4){
        if(!listfunc.isEmpty()){
        System.out.println("# - Alterar Salário: ");

        boolean continueLoop = true;
      do{
        try{
         System.out.print("Qual o código do funcionário:  ");
          int y = sc.nextInt();

          // CASO CÓDIGO INEXISTENTE
          while(listfunc.get(y) == null){
              System.out.print("Funcionário Inexistente: ");
              y = sc.nextInt();
          }

        Map<String,String> mapShow = new HashMap<String,String>();
        mapShow = listfunc.get(y);
                 
        System.out.println("Salário atual: " + mapShow.get("SALARIO"));

        System.out.print("Novo salário: ");
        mudasal = sc.nextDouble();
        strnovosal = ""+mudasal;
        mapShow.replace("SALARIO", strnovosal);

        //CALCULA NOVO BONUS
        for (String strdpts : mapShow.values()) {
              strdpts = mapShow.get("DEPENDENTES");
              int intdpts = Integer.parseInt(strdpts);
              novobonus = (mudasal * 0.02)*intdpts;
              String bonus = ""+novobonus;
              mapShow.replace("BONUS", bonus);
          }     
          
        //mapShow.forEach((k, v) -> System.out.println(String.format("%s: %s", k, v)));   

        continueLoop = false;
        //FIM DO TRY - ALTERAR SALÁRIO
        } catch (InputMismatchException e){
          System.out.println("ERRO! Digite apenas números.\n");
          sc.nextLine();
        }
      } while (continueLoop); // LAÇO CASO TENHA ENTREADA ALGUMA LETRA     

        } else { 
          System.out.println("#- Nenhum funcionário cadastrado.\n");
          continue; 
        }      
      }

      // # 5 - ENCERRAR
      if(select == 5){
        System.out.print("Encerrada todas as operações.");
        break;    
      }
      System.out.println("");

      //FIM DO TRY 1 - ELECIONE A AÇÃO
      } catch (InputMismatchException e) {
          System.out.println("ERRO! Digite apenas números.\n");
          sc.nextLine();
      }
  }

  }
}
