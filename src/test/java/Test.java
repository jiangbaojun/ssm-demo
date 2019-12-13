import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("5");
		list.add("5");
		list.add("5");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("3");
		list.add("3");
		list.add("1");
		list.add("3");
		System.out.println(new Test().f3(list));
	}

	public List<String> f1(List<String> list) {
        for (String temp : list) {
            if ("3".equals(temp)) {
                list.remove(temp);
            }
        }
        return list;
    }

  public List<String> f2(List<String> list) {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String temp = iterator.next();
            if ("3".equals(temp)) {
                list.remove(temp);
            }
        }
        return list;
    }

   public List<String> f3(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if ("3".equals(list.get(i))) {
                list.remove(i);
            }
        }
        return list;
    }


}
