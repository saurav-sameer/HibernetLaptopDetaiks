package util;

import java.util.Scanner;

import dao.LaptopDao;
import dao.LaptopDaoHql;
import dto.LaptopDetails;

public class Test {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		LaptopDetails details = new LaptopDetails();
		System.out.println("Enter laptop name");
		details.setLaptopName(scanner.next());
		System.out.println("Enter Procsser Name");
		details.setProcesser(scanner.next());
		System.out.println("Enter Ram Size");
		details.setRam(scanner.nextInt());
		System.out.println(details.getLaptopName());
		System.out.println(details.getProcesser());
		System.out.println(details.getRam());
		LaptopDao.laptoDetailsSave(details);
		
		System.out.println(LaptopDao.searchById(2));
		
		System.out.println(LaptopDao.deleteLaptopDetails(1));
		
		System.out.println(LaptopDao.UpdateLptopDetails(1, 6, "hp", "intel"));
		
		System.out.println(LaptopDaoHql.searchById(2));
		
		System.out.println(LaptopDaoHql.updateLpDetails(1, 1, "dell", "int"));
		
		System.out.println(LaptopDaoHql.delateLaptopDetails(2));
	}

}
