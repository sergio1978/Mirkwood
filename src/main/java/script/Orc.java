/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package script;

import java.util.Random;

/**
 *
 * @author Trainerpl022
 */
public class Orc extends Character {
    
    public Orc(int hp, int attack, int defense) {
        super(hp, 0, attack, defense);
        
        Random r = new Random();
        int p = 4 + r.nextInt(7);
        
        setPower(p);
    }
    
}
