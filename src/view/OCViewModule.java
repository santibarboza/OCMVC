package view;

import javax.swing.JFrame;

import model.OCModelModule;
import controller.OCController;

public class OCViewModule {
	  private static OCViewModule instance;

	  private OCViewModule() { }

	  public static OCViewModule getInstance() {
	    if (instance == null) {
	      instance = new OCViewModule();
	    }
	    return instance;
	  }

	  public OCView openOCWindow(OCController ocController) {
	    OCViewImpl ocView = new OCViewImpl(ocController,OCModelModule.getInstance().getOCModel());

	    JFrame frame = new JFrame("Update User");
//	    frame.setContentPane(editUserView.content);
//	    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    frame.pack();
	    frame.setVisible(true);

	    return ocView;
	  }
}
