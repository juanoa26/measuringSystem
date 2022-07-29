package com.unicauca.domain;

import com.unicauca.publicador_suscriptor.infra.Utilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LevelTwo extends Handler {

    public LevelTwo(String email) {
        super(email);
    }

    @Override
    public boolean attend(Chain claim) {
        if (claim.getType().equals(TypeEnum.DELIVERY)){
            Logger logger = LoggerFactory.getLogger(Utilities.class);
            logger.info("El resultado es evaluado en el nivel 2 ");      
            claim.setAttended(true);
            return true;
            
        } else {
            return getNextHandler().attend(claim);
        }
    }

}
