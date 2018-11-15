package jdbc_coffee.ui;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public interface MydocumentListener extends DocumentListener {

	@Override
	default void insertUpdate(DocumentEvent e) {
		warning();
		
	}

	@Override
	default void removeUpdate(DocumentEvent e) {
		warning();
		
	}

	@Override
	default void changedUpdate(DocumentEvent e) {
		warning();
		
	}

	void warning();
	
}
