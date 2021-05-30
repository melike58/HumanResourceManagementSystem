package KodlamaIO.HRMS.core.utilities.results;

import KodlamaIO.HRMS.core.utilities.results.Result;

public class SuccessResult extends Result{

	public SuccessResult() {
		super(true);
	}
	
	public SuccessResult(String message) {
		super(true,message);
	}

}
