package baitapso2.ex14;

import java.util.Scanner;

public class ComplexNum {
	
	float thuc;
	float ao;
	
	public ComplexNum() {
		thuc =0;
		ao =0;
	}
	
	public ComplexNum(float thuc, float ao) {
		this.thuc = thuc;
		this.ao = ao;
	}

	public float getThuc() {
		return thuc;
	}

	public float getAo() {
		return ao;
	}

	public void hien() {
		if (ao<0) {
			System.out.printf("%.3f + j%.3f\n", thuc, -ao);
		}
		else {
			System.out.printf("%.3f + j%.3f\n", thuc, ao);
		}
	}
	
	public void nhap() {
		Scanner scanner = new Scanner(System.in);
		String in = scanner.nextLine();
		thuc = Float.parseFloat(in.substring(0, in.indexOf("+")));
		ao = Float.parseFloat(in.substring(in.indexOf("j")+1));
		scanner.close();
	}
	
	//Calculating Methods
	public ComplexNum cong(ComplexNum sp2) {
		return new ComplexNum(thuc+sp2.getThuc(), ao+sp2.getAo());
	}
	
	public ComplexNum tru(ComplexNum sp2) {
		return new ComplexNum(thuc-sp2.getThuc(), ao-sp2.getAo());
	}
	
	public ComplexNum nhan(ComplexNum sp2) {
			return new ComplexNum(thuc*sp2.getThuc() - ao*sp2.getAo(), thuc*sp2.getAo() + ao*sp2.getThuc());
	}
	
	public ComplexNum chia(ComplexNum sp2) {
		float thucAns = (sp2.getThuc()*thuc + sp2.getAo()*ao)/(sp2.getThuc()*sp2.getThuc()+sp2.getAo()*sp2.getAo());
		float aoAns = (sp2.getThuc()*ao - sp2.getAo()*thuc)/(sp2.getThuc()*sp2.getThuc()+sp2.getAo()*sp2.getAo());
		return new ComplexNum(thucAns, aoAns);
	}

}
