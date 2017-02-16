
public class BucketSort {
	
	public static void Bucketsort(int[] a) {
	      int maiorvalor = a[0];
    	for(int j = 1 ; j < a.length;j++){
    	   if(a[j]> maiorvalor)
    	   maiorvalor = a[j];
    	}

	      int [] b = new int[maiorvalor+1];
	 		 	

	      for (int i=0; i < b.length; i++) {
	         b[i]=0;
	      }
	 
	      for (int i=0; i < a.length; i++) {
	         b[a[i]]++;
	      }
	 
	      int outPos=0;
	      for (int i=0; i < b.length; i++) {
	         for (int j=0; j<b[i]; j++) {
	            a[outPos++]=i;
	         }
	      }
	   }

}