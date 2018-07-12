package monstruo;

public class DragonZilla implements IMonstruoPeligroso {
   private String Estado;
   public DragonZilla(){
       Estado=new String();
   }
    @Override
   public String toString(){
       return "DragonZilla: "+Estado;
   }
//Implementando los metodos de la interface IMonstruoPeligroso
    @Override
   public void amenazar() {
       Estado+="Amenaza ";
   }
    @Override
   public void destruir(){
       Estado+="Destruye ";
   }
    public void actuar() {
        destruir();
        amenazar();
    }
}
