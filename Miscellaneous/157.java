/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4
{
   	 /**
   	  * @param buf Destination buffer
    	  * @param n   Maximum number of characters to read
    	  * @return    The number of characters read
    	  */
    	public int read(char [] buf,int n)
	{
		char [] buffer = new char [4];
		boolean eof = false;
		int readBytes = 0;

		while(!eof && readBytes < n)
		{
			int x = read4(buffer);
			if(x < 4) eof = true;
			int bytes = Math.min(n - readBytes,x);
			System.arraycopy(buffer,0,buf,readBytes,bytes);
			readBytes += bytes;
		}

		return readBytes;
	}
}