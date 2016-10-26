/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artefactos;

/**
 *
 * @author Trainerpl022
 */
public class LayerTrees extends MapLayer {
    public LayerTrees() {
        super();
        
        this.objectos[5][5] = new Tree2();
        this.objectos[7][3] = new Tree2();
        this.objectos[8][2] = new Tree2();
        this.objectos[7][7] = new Tree2();
        this.objectos[7][8] = new Tree2();
    }
}
