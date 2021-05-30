package KodlamaIO.HRMS.core.utilities.business;

import KodlamaIO.HRMS.core.utilities.results.Result;

public class BusinessEngine {

    public static Result run(Result ...logics) {
        for(Result logic: logics) {
            if(!logic.isSuccess()) {
                return logic;
            }
        }

        return null;
    }
}