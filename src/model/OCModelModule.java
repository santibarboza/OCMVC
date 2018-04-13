package model;

public class OCModelModule {
	private static OCModelModule instance;
	  private OCModel ocModel;

	  private OCModelModule() {
	   // ocModel =  new OCModelImpl();
	  }

	  public static OCModelModule getInstance() {
	    if(instance == null) {
	      instance =  new OCModelModule();
	    }
	    return instance;
	  }

	  public OCModel getOCModel() {
	    return ocModel;
	  }

}
