package Day5_session4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class List_learning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> arr_list= new ArrayList<String>();
		
		arr_list.add("Mango");
		arr_list.add("apple");
		arr_list.add("Guava");
		arr_list.add("banana");
		arr_list.add("Mango");
		
		
		//read by for each
//		for(String element:arr_list)
//		{
//			System.out.println(element);
//		}
		
		
		//normal for loop
//		
//		for(int i=0;i<arr_list.size();i++)
//		{
//			
//			System.out.println(arr_list.get(i));
//		}
//		
		
		//Iterator
		Iterator<String> itr = arr_list.iterator();
		
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
