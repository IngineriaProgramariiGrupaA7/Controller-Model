package FisaCerinte;

/**
 * Created by Cosmin on 5/17/2016.
 *
 * Class modeling an actor in requirements document
 *
 */
public class Author {

    public Author(String author){
        this.author=author;
    }

    private String author;

    public void setAuthor(String nume){
        this.author=nume;
    }

    public String getAuthor(){
        return this.author;
    }
}
