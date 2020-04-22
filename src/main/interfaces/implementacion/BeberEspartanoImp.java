package main.interfaces.implementacion;

import main.interfaces.IBeber;

public class BeberEspartanoImp implements IBeber {

    public BeberEspartanoImp() {
    }

    @Override
    public int beber(int especial) {
        System.out.println("Bebi como espartano");
        return 1;
    }
}
