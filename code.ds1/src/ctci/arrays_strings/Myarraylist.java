package arrays_strings;

import java.util.Arrays;

public class Myarraylist {
	
	private Object[] myArr;
	private int actsize=0;
	private int DEFAULT_SIZE=10;
	public Myarraylist() {
		myArr = new Object[DEFAULT_SIZE];
		
	}
	
	public Object get(int index) {
		if(index<actsize) {
			return myArr[index];
		}else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}
	
	public void add(Object obj)
	{
		//threshold
		if(myArr.length-actsize<=5) {
			resize();
		}
		myArr[actsize++]=obj;
	}
	public Object remove(int index) {
		if(index<actsize)
		{
			Object obj = myArr[index];
			int tmp = index;
			myArr[tmp]=null;
			while(tmp<actsize)
			{
				myArr[tmp]=myArr[tmp+1];
				myArr[tmp+1]=null;
				tmp++;
			}
			actsize--;
			return obj;
		}
		else {
			 throw new ArrayIndexOutOfBoundsException();
		}
		
	}
	public void resize() {
		myArr=Arrays.copyOf(myArr, myArr.length*2);
		
	}
	
	public int size() {
		return actsize;
	}
			

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Myarraylist mal = new Myarraylist();
        mal.add(new Integer(2));
        mal.add(new Integer(5));
        mal.add(new Integer(1));
        mal.add(new Integer(23));
        mal.add(new Integer(14));
        for(int i=0;i<mal.size();i++){
            System.out.print(mal.get(i)+" ");
        }
        mal.add(new Integer(29));
        System.out.println("Element at Index 5:"+mal.get(5));
        System.out.println("List size: "+mal.size());
        System.out.println("Removing element at index 2: "+mal.remove(2));
        for(int i=0;i<mal.size();i++){
            System.out.print(mal.get(i)+" ");
        }
	}

}

//ref: http://www.java2novice.com/java-interview-programs/arraylist-implementation/
	