
public class Test {

	public static void main(String[] args) {
		new Test().t1();
	}

	private void t1() {
		int[] templates = {1,2,3};
		String[] strs = {"11","22"};
		for (int i = 0; i < templates.length; i++) {
	      if (2 == templates[i]) {
	        System.out.println(this);
	      }
	    }
		
	}
	

}
