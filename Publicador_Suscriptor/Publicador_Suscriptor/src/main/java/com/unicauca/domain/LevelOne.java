package com.unicauca.domain;

import com.unicauca.publicador_suscriptor.infra.Utilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LevelOne extends Handler {

    public LevelOne(String email) {
        super(email);
    }

    @Override
    public boolean attend(Chain claim) {
        if (claim.getType().equals(TypeEnum.BASIC)) {
            Logger logger = LoggerFactory.getLogger(Utilities.class);
            logger.info("La media es tomada en nivel 1 ");

            claim.setAttended(true);
            return true;

        } else {
            return getNextHandler().attend(claim);
        }
    }

}
