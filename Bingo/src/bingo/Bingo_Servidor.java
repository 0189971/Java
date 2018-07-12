package bingo;
/**
 *
 * @author Yuca
 */
public class Bingo_Servidor {
      public static void main(String[] args) {
        try {
          new ServidorThread().start();
        } catch (Exception e) {
          e.printStackTrace();
        }
  }
    
}
