/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaocho;

import java.util.*;

/**
 *
 * @author sdelaot
 */
public class PetCount {
    static String[] typenames = {
        "Pet", "Dog", "Pug", "Cat",
        "Rodent", "Gerbil", "Hamster"
        };
    /**
     * 
     * @param args
     * @throws Exception 
     */
    public static void main( String [] args ) throws Exception {
        ArrayList pets = new ArrayList();
        try {
            Class [] petTypes = {
                Class.forName( "practicaocho.Dog"     ),
                Class.forName( "practicaocho.Pug"     ),
                Class.forName( "practicaocho.Cat"     ),
                Class.forName( "practicaocho.Rodent"  ),
                Class.forName( "practicaocho.Gerbil"  ),
                Class.forName( "practicaocho.Hamster" )
                };
            for (int i = 0; i < 15; i++) {
                pets.add( petTypes[(int) (Math.random() * petTypes.length)].
                        newInstance() );
                }
        } catch ( InstantiationException e ) {
            System.err.println( "No puedo instanciar" );
            throw e;
        } catch ( IllegalAccessException e ) {
            System.err.println( "No puedo acceder" );
            throw e;
        } catch ( ClassNotFoundException e ) {
            System.err.println( "No puedo encontrar la clase" );
            throw e;
        }
        HashMap h = new HashMap();
        for( int i=0; i<typenames.length; i++ ) {
            h.put( typenames[i], new Counter() );
            }
        for( int i=0; i<pets.size(); i++ ) {
            Object o = pets.get( i );
            if( o instanceof Pet ) {
                ( (Counter) h.get( "Pet" ) ).i++;
                }
            if( o instanceof Dog ) {
                ( (Counter) h.get( "Dog" ) ).i++;
                }
            if( o instanceof Pug ) {
                ( (Counter) h.get( "Pug" ) ).i++;
                }
            if( o instanceof Cat ) {
                ( (Counter) h.get( "Cat" ) ).i++;
                }
            if( o instanceof Rodent ) {
                ( (Counter) h.get("Rodent" ) ).i++;
                }
            if( o instanceof Gerbil ) {
                ( (Counter) h.get( "Gerbil" ) ).i++;
                }
            if( o instanceof Hamster ) {
                ( (Counter) h.get( "Hamster" ) ).i++;
                }
            }
        for( int i=0; i<pets.size(); i++ ) {
            System.out.println( pets.get(i).getClass() );
            }
        for( int i=0; i<typenames.length; i++ ) {
            System.out.println( typenames[i] + " cantidad: " + 
                    ((Counter) h.get(typenames[i])).i );
            }
    }
}
