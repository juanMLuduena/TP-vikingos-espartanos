package main.interfaces.implementacion;

import main.interfaces.IOrinar;

import java.util.Random;

public class OrinarEspartanoImp implements IOrinar {
    public OrinarEspartanoImp() {
    }

    @Override
    public boolean orinar(int vejiga, int toleranciaExtra){

        if(vejiga<40){
            return false;
        }
        if(vejiga >100){
            return true;
        }
        else {
            Random r = new Random(System.currentTimeMillis());
            return r.nextInt(100) < vejiga - toleranciaExtra - 1;
        }
    }
}
