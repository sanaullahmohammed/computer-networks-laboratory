import java.util.*;

class CRC 
{
		int  W;
		String message;
		String P;
		String checksum;

		CRC()
		{
			W=16;
			P="10001000000100001";
		}

		void crc()
		{
			String msg = message+"0000000000000000";
			char[] rem = new char[P.length()];

			for(int i=0; i<msg.length(); i++)
			{
				rem[W]=msg.charAt(i);
				boolean xor = rem[0] == '1';
				
				for(int j=1; j<=W; j++)
				{
					if(xor)
						rem[j] = (rem[j]==P.charAt(j)) ? '0' : '1';
					rem[j-1] = rem[j];
				}
			}
			checksum = String.valueOf(rem).substring(0,W);
		}

		void input()
		{
			System.out.println("Enter your message: ");
			Scanner sc = new Scanner(System.in);
			message = sc.next();
			sc.close();
		}

		void output()
		{
			System.out.println("The checksum is: "+checksum);
		}

		public static void main(String[] args)
		{
			CRC crc = new CRC();
			crc.input();
			crc.crc();
			crc.output();
		}
}
