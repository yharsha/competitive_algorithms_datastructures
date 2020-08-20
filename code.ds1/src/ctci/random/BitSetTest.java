package random;

import java.util.BitSet;

public class BitSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BitSet bitSet = new BitSet();
		System.out.println("before: "+bitSet);
		bitSet.set(0);
		bitSet.set(3);
		bitSet.set(2);
		bitSet.set(20);
		System.out.println("after: "+bitSet);
		
		  StringBuilder s = new StringBuilder();
          for( int i = 0; i < bitSet.length();  i++ )
          {
              s.append( bitSet.get( i ) == true ? 1: 0 );
          }

          System.out.println( s );
	}

}
