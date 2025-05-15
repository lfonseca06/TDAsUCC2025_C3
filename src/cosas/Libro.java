package cosas;

/**
 *
 * @author Leonardo
 */
public class Libro {
    private final String AUTOR;
    private final String TITULO;
    
  

    public Libro(String AUTOR, String TITULO) {
        this.AUTOR = AUTOR;
        this.TITULO = TITULO;
    }
    
    public String getAUTOR() {
        return AUTOR;
    }

   
    public String getTITULO() {
        return TITULO;
    }
    
   

    @Override
    public String toString() {
        return "Libro TITULO = " + TITULO + " AUTOR = " + AUTOR;
    }
    
    
 
}
