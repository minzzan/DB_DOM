import java.io.*;
import java.util.List;

import com.ssafy.dao.EcoDao;
import com.ssafy.dao.EcoDaoImpl;
import com.ssafy.dto.EcoDto;

public class EcoMain {
	
	BufferedReader in;

	public EcoMain() {
		in = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public static void main(String[] args) {
		new EcoMain().menu();
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
			System.out.println("--------------------- 환경 정보 등록 ---------------------");
			System.out.print("업체명 : ");
			String companyName = in.readLine();
			System.out.print("인허가번호 : ");
			String licenseNumber = in.readLine();
			System.out.print("업종 코드 : ");
			String businessCode = in.readLine();
			System.out.print("업종명 : ");
			String businessName = in.readLine();
			System.out.print("지도점검일 : ");
			String inspectionDate = in.readLine();
			System.out.print("점검기관코드 : ");
			String agencyCode = in.readLine();
			System.out.print("점검기관명 : ");
			String agencyName = in.readLine();
			System.out.print("처분대상여부 : ");
			String isDisposed = in.readLine();
			System.out.print("점검사항 : ");
			String inspection = in.readLine();
			System.out.print("도로명 주소 : ");
			String roadAddress = in.readLine();

			
			EcoDto ecoDto = new EcoDto();
			ecoDto.setAgencyCode(agencyCode);
			ecoDto.setAgencyName(agencyName);
			ecoDto.setBusinessCode(businessCode);
			ecoDto.setBusinessName(businessName);
			ecoDto.setCompanyName(companyName);
			ecoDto.setInspection(inspection);
			ecoDto.setInspectionDate(inspectionDate);
			ecoDto.setIsDisposed(isDisposed);
			ecoDto.setLicenseNumber(licenseNumber);
			ecoDto.setRoadAddress(roadAddress);
			
			EcoDao ecoDao = EcoDaoImpl.getEcoDao();
			ecoDao.register(ecoDto);
			System.out.println("-------------------------------------------------");
			System.out.println("환경 등록 성공!!!!!");
			System.out.println("-------------------------------------------------");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void update() {
		try {
			System.out.println("--------------------- 환경 정보 변경 ---------------------");
			System.out.print("변경할 환경 번호 : ");
			int idx = Integer.parseInt(in.readLine());
			System.out.print("변경할 업체명 : ");
			String companyName = in.readLine();
			System.out.print("변경할 인허가번호 : ");
			String licenseNumber = in.readLine();
			System.out.print("변경할 업종 코드 : ");
			String businessCode = in.readLine();
			System.out.print("변경할 업종명 : ");
			String businessName = in.readLine();
			System.out.print("변경할 지도점검일 : ");
			String inspectionDate = in.readLine();
			System.out.print("변경할 점검기관코드 : ");
			String agencyCode = in.readLine();
			System.out.print("변경할 점검기관명 : ");
			String agencyName = in.readLine();
			System.out.print("변경할 처분대상여부 : ");
			String isDisposed = in.readLine();
			System.out.print("변경할 점검사항 : ");
			String inspection = in.readLine();
			System.out.print("변경할 도로명 주소 : ");
			String roadAddress = in.readLine();
			
			EcoDto ecoDto = new EcoDto();
			ecoDto.setIdx(idx);
			ecoDto.setAgencyCode(agencyCode);
			ecoDto.setAgencyName(agencyName);
			ecoDto.setBusinessCode(businessCode);
			ecoDto.setBusinessName(businessName);
			ecoDto.setCompanyName(companyName);
			ecoDto.setInspection(inspection);
			ecoDto.setInspectionDate(inspectionDate);
			ecoDto.setIsDisposed(isDisposed);
			ecoDto.setLicenseNumber(licenseNumber);
			ecoDto.setRoadAddress(roadAddress);
			
			EcoDaoImpl.getEcoDao().update(ecoDto);
			System.out.println("-------------------------------------------------");
			System.out.println("환경 정보 변경 성공!!!!!");
			System.out.println("-------------------------------------------------");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void delete() {
		try {
			System.out.println("--------------------- 환경 삭제 ---------------------");
			System.out.print("삭제할 환경 번호 : ");
			int no = Integer.parseInt(in.readLine());
			
			EcoDaoImpl.getEcoDao().delete(no);
			System.out.println("-------------------------------------------------");
			System.out.println("환경 삭제 성공!!!!!");
			System.out.println("-------------------------------------------------");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void searchById() {
		try {
			System.out.print("검색할 환경 아이디 : ");
			int no = Integer.parseInt(in.readLine());
			EcoDto ecoDto = EcoDaoImpl.getEcoDao().searchById(no);
			showEco(ecoDto);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void searchAll() {
		List<EcoDto> list = EcoDaoImpl.getEcoDao().searchAll();
		showList(list);
	}

	private void showEco(EcoDto ecoDto) {
		if(ecoDto != null) {
			System.out.println("============ 환경 정보 ============");
			System.out.println("업체명 : " + ecoDto.getCompanyName());
			System.out.println("인허가번호 : " + ecoDto.getLicenseNumber());
			System.out.println("업종코드 : " + ecoDto.getBusinessCode());
			System.out.println("업종명 : " + ecoDto.getBusinessName());
			System.out.println("지도점검일 : " + ecoDto.getInspectionDate());
			System.out.println("점검기관코드 : " + ecoDto.getAgencyCode());
			System.out.println("점검기관명 : " + ecoDto.getAgencyName());
			System.out.println("처분대상여부 : " + ecoDto.getIsDisposed());
			System.out.println("점검사항: " + ecoDto.getInspection());
			System.out.println("도로명주소 : " + ecoDto.getRoadAddress());

			System.out.println("-------------------------------------------------");
		} else {
			System.out.println("-------------------------------------------------");
			System.out.println("해당 환경이 존재하지 않습니다.");
			System.out.println("-------------------------------------------------");
		}
	}
	
	private void showList(List<EcoDto> list) {
		System.out.println("===================================== 환경 목록 =====================================");
		System.out.println("업체명\t인허가번호\t\t업종코드\t업종명\t지도점검일\t점검기관코드\t점검기관명\t처분대상여부\t점검사항\t도로명주소");
		System.out.println("-------------------------------------------------------------------------------------");
		for(EcoDto ecoDto : list) {
			System.out.println(ecoDto);
		}
		System.out.println("-------------------------------------------------------------------------------------");
	}
}
