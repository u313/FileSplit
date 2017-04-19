package MySplitter;

/*public class SplitFiles {

}*/
import java.io.*;


class SplitFiles
{
	FileInputStream fin;
	FileOutputStream fout;
	int len;
	int splitlen;
	String str;

	SplitFiles(String fileName,int splitlength)
	{
		try
		{
			fin=new FileInputStream(fileName);
			str=fileName;
			len=0;
			splitlen=splitlength;
			Split();

		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found.");
		}
		catch(IOException e)
		{
			System.out.println("IOException generated");
		}
	}
	void Split()
	{

		try
		{
			int i=0;
			FileInputStream fin=new FileInputStream(str);
			int c=fin.read();
			while(c!=-1)
			{
				FileOutputStream fw=new FileOutputStream(str+"."+(i+1)+".spt");
				while(c!=-1 && len<splitlen)
				{
					fw.write(c);
					c=fin.read();
					len++;
				}
				len=0;
				fw.close();
				i++;
			}

		}
		catch(Exception e)
		{
			System.out.println("gg");
			e.printStackTrace();
		}
	}

}
