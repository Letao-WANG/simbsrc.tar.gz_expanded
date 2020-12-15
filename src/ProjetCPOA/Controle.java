package ProjetCPOA;

public class Controle {

	MainGUI mainGUI;
	Message message;
	SuccessMessage successMessage;
	
	public Controle() {
		mainGUI = new MainGUI(this);
	}
	
	public void disposeMain() {
		mainGUI.dispose();
	}
	
	public void disposeMessage() {
		message.dispose();
	}
	
	public void ShowMessage() {
		message = new Message(this);
	}
	
	public void ShowSuccessMessage() {
		successMessage = new SuccessMessage(this);
	}
	
	public void ShowMain() {
		mainGUI = new MainGUI(this);
	}
	
	public void Quit() {
		System.exit(0);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Controle();
	}

}
