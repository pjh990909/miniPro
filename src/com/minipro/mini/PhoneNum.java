package com.minipro.mini;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneNum {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		
		
		Reader rd = new FileReader("C:\\javaStudy\\PhoneDB.txt");
		BufferedReader br = new BufferedReader(rd);

		List<Phone> pList = new ArrayList<Phone>();

		while(true) {
			String str = br.readLine();
			if(str==null) {
				break;
			}

			String[] per = str.split(",");

			Phone p01 = new Phone(per[0],per[1],per[2]);
			pList.add(p01);
		}

		System.out.println("*************************");
		System.out.println("*    전화번호 관리 프로그램   *");
		System.out.println("*************************");

		while (true) {
			System.out.println("1.리스트 2.등록 3.삭제 4.검색 5.종료");
			System.out.println("-------------------------------");
			System.out.print(">메뉴번호:");
			int menuno = sc.nextInt();
			sc.nextLine();
			switch (menuno) {

			case 1:
				System.out.println("<1.리스트>");

				Writer wt = new FileWriter("C:\\javaStudy\\Phone.txt");
				BufferedWriter bw = new BufferedWriter(wt);

				int count =0;
				for(int i =0;i<pList.size();i++) {
					count = count +1;
					bw.write(pList.get(i).getName() + "," + pList.get(i).getHp() + "," + pList.get(i).getCompany());
					bw.newLine();
					System.out.println(count+ "." +"\t"+pList.get(i).getName() + "\t" + pList.get(i).getHp() + "\t" + pList.get(i).getCompany());
				}
				break;

			case 2:
				System.out.println("<2.등록>");

				System.out.print(">이름:");
				String name =sc.nextLine();
				System.out.print(">휴대전화:");
				String hp = sc.nextLine();
				System.out.print(">회사전화:");
				String company = sc.nextLine();
				
				Phone p02 = new Phone(name,hp,company);
				pList.add(p02);
				
				break;
			
			case 3:
				System.out.println("<3.삭제>");
				System.out.print(">번호:");
				int num = sc.nextInt();
				pList.remove(num-1);
				System.out.println("[삭제되었습니다]");
				
				break;
			case 4:
				System.out.print(">이름:");
				String ch = sc.nextLine();
				int newcount = 0;
				for(int i=0;i<pList.size();i++) {
					newcount = newcount + 1;
					if(pList.get(i).getName().contains(ch)) {
						System.out.println(newcount+ "." +"\t"+pList.get(i).getName() + "\t" + pList.get(i).getHp() + "\t" + pList.get(i).getCompany());
					}
				
				}
				break;

			}
		}

	}

}
