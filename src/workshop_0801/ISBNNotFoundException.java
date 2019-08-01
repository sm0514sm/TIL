package workshop_0801;

public class ISBNNotFoundException extends Exception {

	public ISBNNotFoundException() {
		super("ISBN을 찾을 수 없당!");
	}
	
	public ISBNNotFoundException(String string) {
		super(string);
	}

}
