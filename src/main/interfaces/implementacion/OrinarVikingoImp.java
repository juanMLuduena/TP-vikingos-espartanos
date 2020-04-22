package main.interfaces.implementacion;

import main.interfaces.IOrinar;

import java.util.Random;

public class OrinarVikingoImp implements IOrinar {
    public OrinarVikingoImp() {
    }

    //aca nose como hacer, el segundo parametro no se usa, pense en sobreescribir el metodo pero nose
    @Override
    public boolean orinar(int vejiga, int zero) {

        if (vejiga < 40) {
            return false;
        }
        if (vejiga > 100) {
            return true;
        } else {
            Random r = new Random(System.currentTimeMillis());
            return r.nextInt(100) < vejiga - 1;
        }
    }

}