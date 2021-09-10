import java.io.*;
import java.util.List;

import com.ssafy.dao.HouseDealDao;
import com.ssafy.dao.HouseDealDaoImpl;
import com.ssafy.dto.HouseDealDto;

public class HouseDealMain {
	
	BufferedReader in;

	public HouseDealMain() {
		in = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public static void main(String[] args) {
		new HouseDealMain().menu();
	}

	private void menu() {
		boolean isContinue = true;
		while(isContinue) {
			System.out.println("*************** 메뉴 선택 ***************");
			System.out.println("1. 등록");
			System.out.println("2. 정보 변경");
			System.out.println("3. 삭제");
			System.out.println("4. 아이디로 검색");
			System.out.println("5. 모든 정보 출력 (100개 까지)");
			System.out.println("0. 종료");
			System.out.println("******************************************");
			System.out.print("번호 입력 : ");
			try {
				int num = Integer.parseInt(in.readLine());
				switch(num) {
				case 1 : register();break;
				case 2 : update();break;
				case 3 : delete();break;
				case 4 : searchById();break;
				case 5 : searchAll();break;
				default : isContinue = false;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("@@@@@@@@@@@ 프로그램 종료 @@@@@@@@@@@");
	}
	
	private void register() {
		try {
			System.out.println("--------------------- 하우스 정보 등록 ---------------------");
			System.out.print("동 : ");
			String dong = in.readLine();
			System.out.print("아파트 이름 : ");
			String aptName = in.readLine();
			System.out.print("시/군/구 코드 : ");
			String code = in.readLine();
			System.out.print("거래 금액 : ");
			String dealAmount = in.readLine();
			System.out.print("건축 년도 : ");
			String buildYear = in.readLine();
			System.out.print("거래 년도 : ");
			String dealYear = in.readLine();
			System.out.print("거래 월 : ");
			String dealMonth = in.readLine();
			System.out.print("거래 일 : ");
			String dealDay = in.readLine();
			System.out.print("면적 : ");
			String area = in.readLine();
			System.out.print("층 : ");
			String floor = in.readLine();
			System.out.print("지번 : ");
			String jibun = in.readLine();
			System.out.print("타입 : ");
			String type = in.readLine();
			System.out.print("월세 : ");
			String rentMoney = in.readLine();
			System.out.print("동 코드 : ");
			String dongCode = in.readLine();
			
			HouseDealDto houseDealDto = new HouseDealDto();
			houseDealDto.setDong(dong);
			houseDealDto.setAptName(aptName);
			houseDealDto.setCode(code);
			houseDealDto.setDealAmount(dealAmount);
			houseDealDto.setBuildYear(buildYear);
			houseDealDto.setDealYear(dealYear);
			houseDealDto.setDealMonth(dealMonth);
			houseDealDto.setDealDay(dealDay);
			houseDealDto.setArea(area);
			houseDealDto.setFloor(floor);
			houseDealDto.setJibun(jibun);
			houseDealDto.setType(type);
			houseDealDto.setRentMoney(rentMoney);
			houseDealDto.setDongCode(dongCode);
			
			HouseDealDao houseDealDao = HouseDealDaoImpl.getHouseDealDao();
			houseDealDao.register(houseDealDto);
			System.out.println("-------------------------------------------------");
			System.out.println("하우스 등록 성공!!!!!");
			System.out.println("-------------------------------------------------");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void update() {
		try {
			System.out.println("--------------------- 하우스 정보 변경 ---------------------");
			System.out.print("변경할 하우스 번호 : ");
			int no = Integer.parseInt(in.readLine());
			System.out.print("변경할 동 이름 : ");
			String dong = in.readLine();
			System.out.print("변경할 아파트 이름 : ");
			String aptName = in.readLine();
			System.out.print("변경할 시/군/구 코드 : ");
			String code = in.readLine();
			System.out.print("변경할 거래 금액 : ");
			String dealAmount = in.readLine();
			System.out.print("변경할 건축 년도 : ");
			String buildYear = in.readLine();
			System.out.print("변경할 거래 년도 : ");
			String dealYear = in.readLine();
			System.out.print("변경할 거래 월 : ");
			String dealMonth = in.readLine();
			System.out.print("변경할 거래 일 : ");
			String dealDay = in.readLine();
			System.out.print("변경할 면적 : ");
			String area = in.readLine();
			System.out.print("변경할 층 : ");
			String floor = in.readLine();
			System.out.print("변경할 지번 : ");
			String jibun = in.readLine();
			System.out.print("변경할 타입 : ");
			String type = in.readLine();
			System.out.print("변경할 월세 : ");
			String rentMoney = in.readLine();
			System.out.print("변경할 동코드 : ");
			String dongCode = in.readLine();
			
			HouseDealDto houseDealDto = new HouseDealDto();
			houseDealDto.setNo(no);
			houseDealDto.setDong(dong);
			houseDealDto.setAptName(aptName);
			houseDealDto.setCode(code);
			houseDealDto.setDealAmount(dealAmount);
			houseDealDto.setBuildYear(buildYear);
			houseDealDto.setDealYear(dealYear);
			houseDealDto.setDealMonth(dealMonth);
			houseDealDto.setDealDay(dealDay);
			houseDealDto.setArea(area);
			houseDealDto.setFloor(floor);
			houseDealDto.setJibun(jibun);
			houseDealDto.setType(type);
			houseDealDto.setRentMoney(rentMoney);
			houseDealDto.setDongCode(dongCode);
			
			HouseDealDaoImpl.getHouseDealDao().update(houseDealDto);
			System.out.println("-------------------------------------------------");
			System.out.println("하우스 정보 변경 성공!!!!!");
			System.out.println("-------------------------------------------------");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void delete() {
		try {
			System.out.println("--------------------- 하우스 삭제 ---------------------");
			System.out.print("삭제할 하우스 번호 : ");
			int no = Integer.parseInt(in.readLine());
			
			HouseDealDaoImpl.getHouseDealDao().delete(no);
			System.out.println("-------------------------------------------------");
			System.out.println("하우스 삭제 성공!!!!!");
			System.out.println("-------------------------------------------------");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void searchById() {
		try {
			System.out.print("검색할 하우스 아이디 : ");
			int no = Integer.parseInt(in.readLine());
			HouseDealDto houseDealDto = HouseDealDaoImpl.getHouseDealDao().searchById(no);
			showHouseDeal(houseDealDto);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void searchAll() {
		List<HouseDealDto> list = HouseDealDaoImpl.getHouseDealDao().searchAll();
		showList(list);
	}

	private void showHouseDeal(HouseDealDto houseDealDto) {
		if(houseDealDto != null) {
			System.out.println("============ 하우스 정보 ============");
			System.out.println("하우스 번호 : " + houseDealDto.getNo());
			System.out.println("동 : " + houseDealDto.getDong());
			System.out.println("아파트 이름 : " + houseDealDto.getAptName());
			System.out.println("시/군/구 코드 : " + houseDealDto.getCode());
			System.out.println("거래 금액 : " + houseDealDto.getCode());
			System.out.println("건축 년도 : " + houseDealDto.getBuildYear());
			System.out.println("거래 날짜 : " + houseDealDto.getDealYear() + '-' + houseDealDto.getDealMonth() + '-' + houseDealDto.getDealDay());
			System.out.println("면적 : " + houseDealDto.getArea());
			System.out.println("층 : " + houseDealDto.getFloor());
			System.out.println("지번 : " + houseDealDto.getJibun());
			System.out.println("타입 : " + houseDealDto.getType());
			System.out.println("월세 : " + houseDealDto.getRentMoney());
			System.out.println("동 코드 : " + houseDealDto.getDongCode());
			System.out.println("-------------------------------------------------");
		} else {
			System.out.println("-------------------------------------------------");
			System.out.println("해당 하우스가 존재하지 않습니다.");
			System.out.println("-------------------------------------------------");
		}
	}
	
	private void showList(List<HouseDealDto> list) {
		System.out.println("===================================== 하우스 목록 =====================================");
		System.out.println("번호\t동\t아파트 이름\t\t시군구 코드\t거래금액\t거래 날짜\t면적\t층\t지번\t타입\t월세\t동 코드");
		System.out.println("-------------------------------------------------------------------------------------");
		for(HouseDealDto houseDealDto : list) {
			System.out.println(houseDealDto);
		}
		System.out.println("-------------------------------------------------------------------------------------");
	}
}
