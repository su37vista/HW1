import java.io.*;
public class HWa {
	private static int[] days={31,28,31,30,31,30,31,31,30,31,30,31};    //�إߤ���Ѽ�
	public static void isleapyear(int value) {							//�P�_�O�_���|�~�A�A��2�밵�վ�
		if ((value%400==0) || ((value%4==0) && (value%100!=0))) {
			days[1]=29;
		}
		else days[1]=28;
	}		
	public static void print(int year,int month) {                   //�ϥΤ����p��
		int calmonth=0;
		if(month==1||month==2){                                      //�إ߭p��Τ���Φ~��
			calmonth=month+12;
			year--;
		}
		else calmonth=month;
		int weekday= (1+2*calmonth+3*(calmonth+1)/5+year+year/4-year/100+year/400) % 7;   //�����p����o�Ĥ@�ѬP���X
		weekday = (weekday+1) % 7 ;														//�H�P���鬰�}�l  �������վ�
		System.out.println("Sun Mon Tue wed Thr Fri Sat");                              //���Ĥ@�ƿ�X
		for (int i=0 ; i<weekday ; i++)
		    System.out.print("    ");                                                   //�}�Y�L����B��X�ť�
		for (int i=1 ; i<=days[month-1] ; i++)											//��X���
	    {
	     System.out.printf("%3d ",i);
	     if(weekday %7 == 6)    
		 System.out.println();      	     
	     weekday++;
	    }		
		System.out.println(); 															//��������
	}	
	public static void main(String[] args) throws IOException {
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));  
		int data;
		System.out.println("Please input (year/month)");
		while(true){
			   String keyin = input.readLine();					//���o��J�r��
			   if(keyin.indexOf('/')==0)                       
			      data = keyin.indexOf(' ');   
			   else  
				      data = keyin.indexOf('/');   
			   String year = keyin.substring(0, data);
			   String month = keyin.substring(data+1);   
			   int intyear = Integer.parseInt(year);            //�Ѧr���ର�Ʀr
			   int intmonth = Integer.parseInt(month);			   
			isleapyear(intyear);
			print(intyear,intmonth);
		}
	}
}
