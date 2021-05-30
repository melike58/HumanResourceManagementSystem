package KodlamaIO.HRMS.business.concretes.checkHelper;

import java.util.List;

import KodlamaIO.HRMS.core.utilities.results.ErrorResult;
import KodlamaIO.HRMS.core.utilities.results.Result;
import KodlamaIO.HRMS.core.utilities.results.SuccessResult;

public class UserCheckHelper {

    public static Result checkLogicResults(List<Result> logicResults) {
        StringBuilder message = new StringBuilder();

        int errorCounter = 0;
        for (var result : logicResults) {
            if (result != null) {
                message.append(result.getMessage()).append(" ");
                errorCounter++;
            }
        }

        if (errorCounter > 0) {
            return new ErrorResult(message.toString());
        }

        return new SuccessResult("Verification Successfull");
    }

}