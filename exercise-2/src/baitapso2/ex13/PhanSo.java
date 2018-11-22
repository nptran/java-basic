package baitapso2.ex13;

import java.util.Scanner;

public class PhanSo {
	private int ts;
	private int ms;
	private double value;
	private PhanSo ps;
	
	public PhanSo() {
		ts = 0;
		ms = 1;
		value = (double) ts/ms;
	}

	public PhanSo(int ts, int ms) {
		value = (double) ts/ms;
		this.ts = ts;
		this.ms = ms;
	}
	
	public int getTs() {
		return ts;
	}

	public int getMs() {
		return ms;
	}
	
	public double getValue() {
		return value;
	}
	
	public void toiGian() {
		int gcd = gcd(ts, ms);
		if(gcd!=1) {
			ts /=gcd;
			ms/=gcd;
		}
	}
	
	public PhanSo nghichDao() {
		ps = new PhanSo(ms, ts);
		return ps;
	}
	
	public PhanSo doiDau() {
		ts = -ts;
		return ps;
	}
	
	public boolean bang(PhanSo ps2) {
		if (value == ps2.getValue()) {
			return true;
		}
		return false;
	}

	public boolean lonHon(PhanSo ps2) {
		if (value > ps2.getValue()) {
			return true;
		}
		return false;
	}
	
	public boolean nhoHon(PhanSo ps2) {
		if (value > ps2.getValue()) {
			return true;
		}
		return false;
	}
	
	public void hien() {
		if(value<0)
			System.out.println("-"+ Math.abs(ts) +"/"+ Math.abs(ms));
		else
			System.out.println(ts +"/"+ ms);
	}
	
	public void nhap() {
		Scanner scanner = new Scanner(System.in);
		String in = scanner.nextLine(); int slashPos = in.indexOf("/");
		ts = Integer.parseInt(in.substring(0, slashPos));	ms = Integer.parseInt(in.substring(slashPos+1));
		scanner.close();
	}
	
	//Calculating Methods
	public PhanSo cong(PhanSo ps2) {
		PhanSo ans = new PhanSo();
		if (this.ms==ps2.getMs()) {
			ans = new PhanSo(ts+ps2.getTs(), ms);
		}
		else {
			ans = new PhanSo(ts*ps2.getMs() + ps2.getTs()*ms, ms*ps2.getMs());
		}
		ans.toiGian();
		return ans;
	}
	
	public PhanSo tru(PhanSo ps2) {
		PhanSo ans = new PhanSo();
		if (this.ms==ps2.getMs()) {
			ans = new PhanSo(ts-ps2.getTs(), ms);
		}
		else {
			ans = new PhanSo(ts*ps2.getMs()-ps2.getTs()*ms, ms*ps2.getMs());
		}
		ans.toiGian();
		return ans;
	}
	
	public PhanSo nhan(PhanSo ps2) {
		PhanSo ans = new PhanSo(ts*ps2.getTs(), ms*ps2.getMs());
		ans.toiGian();
		return ans;
	}
	
	public PhanSo chia(PhanSo ps2) {
		PhanSo ans = new PhanSo();
		ans = ps.nhan(ps2.nghichDao());
		ans.toiGian();
		return ans;
	}
	
	private static int gcd(int a, int b){
		return (b == 0) ? a: gcd(b, a % b);
	}
}
