/*
 * Created by: Phoebe Vermithrax
 * Created on: 05-March-2018
 * Created for: ICS4U
 * Daily Assignment – Day #15 & 16
 * This program gets the user's input, pushes it onto a stack and can also pop it.
*/
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Button;
//Import java stack, so we can have the option of pushing and popping.
import java.util.Stack;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class StackPush {

	protected Shell shell;
	private Text txtValue;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			StackPush window = new StackPush();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	//Create a new stack.
	Stack<String> stackPush = new Stack<String>();
	
	public String PushStack(String tmpValue)
	{
		//Create a variable to hold the stack.
		String valueStack;
		
		//Push the tmpValue into the stack.
		valueStack = stackPush.push(tmpValue);
		
		//Return this.
		return valueStack;
	}
	
	public String PopStack(String tmpValue)
	{
		//Create a value to hold the result.
		String valuePop;
		
		//Pop the stack.
		valuePop = stackPush.pop();
		
		//Return the result.
		return valuePop;
	}

	
	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("Stack Push");
		
		Label lblPleaseEnterIn = new Label(shell, SWT.NONE);
		lblPleaseEnterIn.setBounds(52, 28, 155, 15);
		lblPleaseEnterIn.setText("Please enter in an integer:");
		
		txtValue = new Text(shell, SWT.BORDER);
		txtValue.setBounds(213, 25, 155, 21);
		
		List lstOfValues = new List(shell, SWT.BORDER);
		lstOfValues.setBounds(52, 99, 316, 140);
		
		Button btnAddValue = new Button(shell, SWT.NONE);
		btnAddValue.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				//Create variables for the values.
				String value;
				String listPush;
				
				//Get the text from the textbox.
				value = txtValue.getText();
				
				//Pass value to the function, PushStack
				listPush = PushStack(value);
				
				//Add the values to the listbox.
				lstOfValues.add(listPush);
				
			}
		});
		btnAddValue.setBounds(52, 68, 75, 25);
		btnAddValue.setText("Add Value");
		
		Button btnRemoveValue = new Button(shell, SWT.NONE);
		btnRemoveValue.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				//Create variables for the value.
				String value;
				String listPop;
				
				//Get the string from the text.
				value = txtValue.getText();
				
				//Call the function, PopStack and pass the value.
				listPop = PopStack(value);
				
				//Remove the value from the listbox.
				lstOfValues.remove(listPop);
			}
		});
		btnRemoveValue.setBounds(282, 68, 86, 25);
		btnRemoveValue.setText("Remove Value");

	}
}
