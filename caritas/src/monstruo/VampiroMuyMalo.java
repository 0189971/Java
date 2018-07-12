package monstruo;

public class VampiroMuyMalo implements IVampiro {
   private String Estado;
   public VampiroMuyMalo(){
       Estado = new String();
   }
    @Override
   public String toString() { 
    return("Vampiro muy malo:"+Estado);
   }
//Implementando los metodos de la interface IVampiro
    @Override
   public void matar(){
       Estado+="Matar ";
   }
    @Override
   public void amenazar(){
       Estado+="Amenaza ";
   }
    @Override
   public void destruir(){
       Estado+="Destruye "; 
   }
    @Override
   public void bebeSangre(){
       Estado+="Bebe Sangre ";
   }
   public void actuar() {
       matar();
       amenazar();
       destruir();
       bebeSangre();
   }
}
