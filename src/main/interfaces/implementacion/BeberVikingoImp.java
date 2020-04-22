package main.interfaces.implementacion;

import main.interfaces.IBeber;

import java.util.Random;

public class BeberVikingoImp implements IBeber {
    public BeberVikingoImp() {
    }
    @Override
    public int beber(int bebedorProfesional) {

        System.out.println("Bebi como vikingo");
        Random r = new Random(System.currentTimeMillis());
        if (r.nextInt(100) < bebedorProfesional - 1){
            return 2;
        }
        else return 1;

    }
}