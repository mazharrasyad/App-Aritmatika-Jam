import java.util.Calendar;
import java.util.Scanner;

public class Time
{
    public static void main(String args[])
    {
        Calendar time = Calendar.getInstance();

        System.out.println("Sekarang Pukul : " + 
        time.get(Calendar.HOUR_OF_DAY) + ":" +
        time.get(Calendar.MINUTE) + ":" +
        time.get(Calendar.SECOND));
	System.out.println();

        int time1 = time.get(Calendar.HOUR_OF_DAY);
        int time2 = time.get(Calendar.MINUTE);
	int time3 = time.get(Calendar.SECOND);
	
	int error = 0;
	int typo = 0;

	do
	{
		typo = 0;
		error = 0;

	        Scanner scan = new Scanner(System.in);
		System.out.print("Aritmatika : ");
		String[] waktu = scan.nextLine().split(" ");

		if(waktu.length % 2 == 0 || waktu.length % 3 == 2)
		{
			for(int i = 0; i < waktu.length; i++)
			{
			    if("jam".equalsIgnoreCase(waktu[i])){
				time.add(Calendar.HOUR, Integer.parseInt(waktu[i-1]));
				typo = 0;
			    }else if("menit".equalsIgnoreCase(waktu[i])){
				time.add(Calendar.MINUTE, Integer.parseInt(waktu[i-1]));
				typo = 0;
			    }else if("detik".equalsIgnoreCase(waktu[i])){
				time.add(Calendar.SECOND, Integer.parseInt(waktu[i-1]));
				typo = 0;
			    }else if(!"jam".equalsIgnoreCase(waktu[i % (i + 1)]) || !"menit".equalsIgnoreCase(waktu[i % (i + 1)]) || !"detik".equalsIgnoreCase(waktu[i % (i + 1)])){
				typo++;
			    }
			}	

			System.out.println("Typo : " + typo);

			if(typo == 0){
				System.out.println("Hasil : " + 
				"Jam " + time.get(Calendar.HOUR_OF_DAY) +
				" Menit " + time.get(Calendar.MINUTE) +
				" Detik " + time.get(Calendar.SECOND));

				scan.close();			
				error = 1;
			}else{
				System.out.println("Aritmatika Error Ulangi");
				System.out.println();
				time.set(Calendar.HOUR_OF_DAY,time1);
				time.set(Calendar.MINUTE,time2);
				time.set(Calendar.SECOND,time3);								
			}
		}
		else{
			System.out.println("Aritmatika Error Ulangi");
			System.out.println();				
		}
	}while(error == 0);
    }
}
