import java.io.*;
import java.util.List;

import com.ssafy.dao.ShopDaoImpl;
import com.ssafy.dto.ShopDto;

public class ShopMain {
	
	BufferedReader in;

	public ShopMain() {
		in = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public static void main(String[] args) {
		new ShopMain().menu();
	}

	private void menu() {
		boolean isContinue = true;
		while(isContinue) {
			System.out.println("*************** 메뉴 선택 ***************");
			System.out.println("1. 동으로 조회하기");
			System.out.println("2. 모든 상권 출력");
			System.out.println("0. 종료");
			System.out.println("******************************************");
			System.out.print("번호 입력 : ");
			try {
				int num = Integer.parseInt(in.readLine());
				switch(num) {
				case 1 : searchBydong();break;
				case 2 : searchAll();break;
				default : isContinue = false;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("@@@@@@@@@@@ 프로그램 종료 @@@@@@@@@@@");
	}

	
	private void searchBydong() {
//		System.out.println("searchById");
		try {
			System.out.print("조회할 동 코드 : ");
			String dongcode = in.readLine();
			List<ShopDto> list = ShopDaoImpl.getshopDao().searchBydong(dongcode);
			showList(list);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void searchAll() {
//		System.out.println("searchAll");
		List<ShopDto> list = ShopDaoImpl.getshopDao().searchAll();
		showList(list);
	}

	
	private void showList(List<ShopDto> list) {
		System.out.println("===================================== 가게 목록 =====================================");
		System.out.println("가게동코드\t\t가게이름\t\t가게 대분류\t\t가게 주소");
		System.out.println("-------------------------------------------------------------------------------------");
		for(ShopDto ShopDto : list) {
			System.out.println(ShopDto);
		}
		System.out.println("-------------------------------------------------------------------------------------");
	}
}
