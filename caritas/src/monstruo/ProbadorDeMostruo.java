package monstruo;
public class ProbadorDeMostruo{
  public static void main(String[]args) {

     VampiroMuyMalo dracula=new VampiroMuyMalo();
     DragonZilla    barney =new DragonZilla();

//     dracula.matar();
//     dracula.amenazar();
//     dracula.destruir();
//     dracula.bebeSangre();
     dracula.actuar();
     System.out.println(dracula);


//     barney.destruir();
//     barney.amenazar();
     barney.actuar();
     System.out.println(barney);
  }

}
