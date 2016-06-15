/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4
{
	/**
	* @param buf Destination buffer
	* @param n   Maximum number of characters to read
	* @return    The number of characters read
	*/
	char [] buffer = new char [4];
	int bufferSize = 0;
	int offset = 0;

	public int read(char [] buf,int n)
	{
		int readBytes = 0;
		boolean eof = false;

		while(!eof && readBytes < n)
		{
			int x = bufferSize > 0 ? bufferSize:read4(buffer);
			if(bufferSize == 0 && x < 4) eof = true;
			int bytes = Math.min(n - readBytes,x);
			System.arraycopy(buffer,offset,buf,readBytes,bytes);
			bufferSize = x - bytes;
			offset = (offset + bytes) % 4;
			readBytes += bytes;
		}

		return readBytes;
	}
}