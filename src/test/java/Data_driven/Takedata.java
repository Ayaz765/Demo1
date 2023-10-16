package Data_driven;

import java.io.IOException;
import java.util.ArrayList;

public class Takedata {

	public static void main(String[] args) throws IOException {
		Datafromexcel dat= new Datafromexcel();
	ArrayList hss=	dat.getData("ayaz");
	System.out.println(hss.get(2));

	}

}
