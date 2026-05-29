package LatihanUASDDP2.CrazyEight;
import java.util.ArrayList;
// init tuh untuk draw pile dan discard pile yang awalnya kosong
public class Hand extends CardCollection {
    private String name;
    private Player owner;

    public Hand(String name) { // nama tipe draw/pile/namaPlayer
        super(name);
        this.name = name;
    }



}
