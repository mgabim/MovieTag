package otoni.omena.santos.machado.movietag.models;
import java.util.ArrayList;

public class Tag {
    public Integer id;
    public String nome;
    public ArrayList<Integer> listaIdsProducoes;

    public Tag getTagById(Integer id){
        if (id.equals(this.id)){
            return this;
        } else{
            return null;
        }
    }
}


