package Final_Part1;

public class test2 {
	
	public static void main(String[] args) {

	    Person first = new Person("Kim");
	    Person second = new Person("Pat");
	    first.post("Only Kim can read this");

	    first.meet(second);
	    second.post("Friends are awesome");
	    first.post("I agree");

	    first.listMessages();
	    second.listMessages();

	}

}
