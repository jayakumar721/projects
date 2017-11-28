package in.vamsoft.bank;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FactFile {

	public static void main(String[] args) {

		try {
			Scanner scan=new Scanner(new File("src/number"));
			Scanner scan1=new Scanner(new File("src/pnr"));
			int n,i=1,f=1;
			double p,y,r,si=0.0;
			double[] ci=new double[5];
			while(scan.hasNextInt()) {
				n=scan.nextInt();
				for(i=1;i<=n;i++) {
					f=i*f;
				}
				System.out.println("factorial"+f);
			}
			while(scan1.hasNext()) {
				
				p=scan1.nextDouble();
				y=scan1.nextDouble();
				r=scan1.nextDouble();
					si=p*y*r/100;
				
				System.out.println("Simple interest"+si);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}