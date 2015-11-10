package com.jean.entity;

import com.jean.Constants;
import com.jean.CustomDfmException;

public class FactoryProduser {

    public static AbstractFish createFish(String type) throws CustomDfmException {

        if (type.equalsIgnoreCase(Constants.FISH_TYPE_PREDATOR)) {
            return new PredatorFish();
        }

        if (type.equalsIgnoreCase(Constants.FISH_TYPE_CALM)) {
            return new CalmFish();
        } else {
            throw new CustomDfmException("Fish type not Valid..!!! =(");
        }

    }
}
