package controller;

import model.OCModelModule;
import view.OCView;
import view.OCViewModule;

public class OCControllerModule {
	private static OCControllerModule instance;

	  private OCControllerModule() { }

	  public static OCControllerModule getInstance() {
	    if (instance == null) {
	      instance = new OCControllerModule();
	    }
	    return instance;
	  }

	  void startApplication() {
	    OCController controller = getOCController();

	    OCView view = openEditUserWindowAndGetView(controller);

	    controller.setOCView(view);
	  }

	  private OCController getOCController() {
	    return new OCControllerImpl(OCModelModule.getInstance().getOCModel());
	  }

	  private OCView openEditUserWindowAndGetView(OCController editUserController) {
	    return OCViewModule.getInstance().openOCWindow(editUserController);
	}

}
