package legacy.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestSplitArr {
	public List<byte[]> tokens(byte[] array, byte[] delimiter) {
        List<byte[]> byteArrays = new ArrayList<>();
        if (delimiter.length == 0) {
            return byteArrays;
        }
        int begin = 0;

        //int i = 0; i < array.length - delimiter.length + 1; i++
        outer:
        for (int i = 0; i < array.length; i++) {
        		//判断定界符是否=array里面的字符
            for (int j = 0; j < delimiter.length; j++) {
                if (array[i + j] != delimiter[j]) {
                    continue outer;
                }
            }
            byteArrays.add(Arrays.copyOfRange(array, begin, i));
            begin = i + delimiter.length;
        }
        byteArrays.add(Arrays.copyOfRange(array, begin, array.length));
        return byteArrays;
    }
	
	public static void main(String[] args) {
		byte[] arrayA = {0,3,0,5,8,5,9,0,6,74};
		byte[] delimiter = {0};
		TestSplitArr tsa = new TestSplitArr();
		List<byte[]> result = tsa.tokens(arrayA, delimiter);
		System.out.println(result.toString());
//		for (byte[] bs : result) {
//			for (byte b : bs) {
//				System.out.println(b);
//			}
//			System.out.println(" delimiter");
//		}
		
	}
}
