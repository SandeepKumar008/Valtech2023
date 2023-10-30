package com.valtech.training.day3;

import java.io.IOException;
import java.io.Writer;

public class Rot13Writer extends Writer{
	
	private Writer dest;
	
	public Rot13Writer(Writer dest) {
		this.dest = dest;
	}
	
	@Override
	public void write(int c) throws IOException {
		dest.write(Rot30Helper.rotate((char)c));
		
	}

	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {
		for (int i = 0; i < len; i++) {
			cbuf[off + i] = Rot30Helper.rotate(cbuf[off+i]);
			
			
		}
		dest.write(cbuf,off,len);
		
	}

	@Override
	public void flush() throws IOException {
		dest.flush();
	}

	@Override
	public void close() throws IOException {
		dest.close();
	}

}
