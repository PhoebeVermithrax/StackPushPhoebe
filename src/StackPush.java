/*
 * Created by: Phoebe Vermithrax
 * Created on: 05/06/07-March-2018
 * Created for: ICS4U
 * Daily Assignment – Day #15 & 16 & 17 & 18
 * This program gets the user's input, pushes it onto a stack and can also pop it, check the peak, and clear the list.
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
//Import javax.swing to allow message boxes.
import javax.swing.*;

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
		String valuePop = null; 
		
		//Pop the stack.
		valuePop = stackPush.pop();

		//Return the result.
		return valuePop;
	}
	
	public String PeakStack (String tmpValue)
	{
		//Create a value to hold the result.
		String valuePeak = null;
		
		try
		{
			//Find the peak of the stack.
			valuePeak = stackPush.peek();
		}
		catch (Exception ref)
		{
			//Show a message, telling the user that there's nothing to peak.
			JOptionPane.showMessageDialog(null, "There's nothing in the stack.");
		}
		
		//Return the result.
		return valuePeak;
	}
	
	public void ClearStack()
	{
		//Clear the stack.
		stackPush.removeAllElements();
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
		lstOfValues.setBounds(52, 80, 316, 140);
		
		Label lblPeak = new Label(shell, SWT.NONE);
		lblPeak.setBounds(133, 226, 55, 15);
		lblPeak.setText("New Label");
		//Set the label to invisible.
		lblPeak.setVisible(false);

		Label lblPopped = new Label(shell, SWT.NONE);
		lblPopped.setBounds(313, 226, 55, 15);
		lblPopped.setText("New Label");
		//Set the label to invisible.
		lblPopped.setVisible(false);
		
		Button btnAddValue = new Button(shell, SWT.NONE);
		btnAddValue.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				//Create variables for the values.
				String value;
				String listPush;
				
				//Get the text from the textbox.
				value = txtValue.getText();
				
				//If the user added nothing in the textbox,
				if (value == "")
				{
					//Tell them that this is invalid.
					JOptionPane.showMessageDialog(null, "There is no input.");
				}
				
				//Pass value to the function, PushStack
				listPush = PushStack(value);
				
				//Add the values to the listbox.
				lstOfValues.add(listPush);
				
			}
		});
		btnAddValue.setBounds(52, 49, 65, 25);
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
				
				try 
				{
					//Call the function, PopStack and pass the value.
					listPop = PopStack(value);
					
					//Remove the value from the listbox.
					lstOfValues.remove(listPop);
					
					lblPopped.setVisible(true);
					lblPopped.setText("" + listPop);
					
				}
				catch (Exception ref)
				{
					//Tell the user that there's nothing to remove.
					JOptionPane.showMessageDialog(null, "There's nothing to remove");
				}
				
			}
		});
		btnRemoveValue.setBounds(123, 49, 86, 25);
		btnRemoveValue.setText("Remove Value");
		
		Button btnPeak = new Button(shell, SWT.NONE);
		btnPeak.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				//Create variables for the value.
				String value;
				String listPeak;
				
				//Get the string from the text.
				value = txtValue.getText();
				
				//Call the function, PopStack and pass the value.
				listPeak = PeakStack(value);
				
				//Enter this into a label.
				lblPeak.setVisible(true);
				lblPeak.setText("" + listPeak);
			}
		});
		btnPeak.setBounds(232, 49, 65, 25);
		btnPeak.setText("Peak");
		
		Button btnClear = new Button(shell, SWT.NONE);
		btnClear.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				//Call the function, ClearStack, to clear the stack.
				ClearStack();
				
				//Clear the listbox.
				lstOfValues.removeAll();
			}
		});
		btnClear.setBounds(303, 49, 65, 25);
		btnClear.setText("Clear");
		
		Label lblThePeak = new Label(shell, SWT.NONE);
		lblThePeak.setBounds(52, 226, 76, 15);
		lblThePeak.setText("The peak is:");
		
		Label lblPoppedValue = new Label(shell, SWT.NONE);
		lblPoppedValue.setBounds(213, 226, 84, 15);
		lblPoppedValue.setText("Popped Value:");
		
		
		

	}
}
