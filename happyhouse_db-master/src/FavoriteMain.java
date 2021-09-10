import java.io.*;
import java.util.List;

import com.ssafy.dao.FavoriteDao;
import com.ssafy.dao.FavoriteDaoImpl;
import com.ssafy.dto.FavoriteDto;

public class FavoriteMain {
	
	BufferedReader in;

	public FavoriteMain() {
		in = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public static void main(String[] args) {
		new FavoriteMain().menu();
	}

	private void menu() {
		boolean isContinue = true;
		while(isContinue) {
			System.out.println("*************** 메뉴 선택 ***************");
			System.out.println("1. 등록");
			System.out.println("2. 아이디로 검색");
			System.out.println("3. 관심정보 삭제");
			System.out.println("4. 모든 관심정보 출력");
			System.out.println("0. 종료");
			System.out.println("******************************************");
			System.out.print("번호 입력 : ");
			try {
				int num = Integer.parseInt(in.readLine());
				switch(num) {
				case 1 : register();break;
				case 2 : searchById();break;
				case 3 : deleteFavorite();break;
				case 4 : searchAll();break;
				default : isContinue = false;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("@@@@@@@@@@@ 프로그램 종료 @@@@@@@@@@@");
	}
	
	private void register() {
//		System.out.println("register");
//		유효성 검사는 생략할게요!!!
		try {
			System.out.println("--------------------- 관심 정보 등록 ---------------------");
			System.out.print("관심 정보 아이디 : ");
			String user_id = in.readLine();
			System.out.print("관심 동네 코드 : ");
			String dongcode = in.readLine();
			
			FavoriteDto FavoriteDto = new FavoriteDto();
			FavoriteDto.setUser_id(user_id);
			FavoriteDto.setDongcode(dongcode);
			
			FavoriteDao FavoriteDao = FavoriteDaoImpl.getFavoriteDao();
			FavoriteDao.register(FavoriteDto);
			System.out.println("-------------------------------------------------");
			System.out.println("관심 정보 등록 성공!!!!!");
			System.out.println("-------------------------------------------------");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void deleteFavorite() {
//		System.out.println("deleteFavorite");
		try {
			System.out.println("--------------------- 관심 정보 삭제 ---------------------");
			System.out.print("아이디 : ");
			String user_id = in.readLine();
			System.out.print("삭제할 관심 동 코드  : ");
			String dongcode = in.readLine();
			
			FavoriteDaoImpl.getFavoriteDao().deleteFavorite(user_id, dongcode);
			System.out.println("-------------------------------------------------");
			System.out.println("관심 정보 삭제 성공!!!!!");
			System.out.println("-------------------------------------------------");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void searchById() {
//		System.out.println("searchById");
		try {
			System.out.print("조회할 아이디 : ");
			String user_id = in.readLine();
			List<FavoriteDto> list = FavoriteDaoImpl.getFavoriteDao().searchById(user_id);
			showList(list);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void searchAll() {
//		System.out.println("searchAll");
		List<FavoriteDto> list = FavoriteDaoImpl.getFavoriteDao().searchAll();
		showList(list);
	}

	private void showFavorite(FavoriteDto FavoriteDto) {
		if(FavoriteDto != null) {
			System.out.println("============ 관심 정보 정보 ============");
			System.out.println("회원 아이디 : " + FavoriteDto.getUser_id());
			System.out.println("관심 동네 코드 : " + FavoriteDto.getDongcode());
			System.out.println("-------------------------------------------------");
		} else {
			System.out.println("-------------------------------------------------");
			System.out.println("관심 정보이 존재하지 않습니다.");
			System.out.println("-------------------------------------------------");
		}
	}
	
	private void showList(List<FavoriteDto> list) {
		System.out.println("===================================== 관심 정보 목록 =====================================");
		System.out.println("회원 아이디\t\t관심 동네 코드");
		System.out.println("-------------------------------------------------------------------------------------");
		for(FavoriteDto FavoriteDto : list) {
			System.out.println(FavoriteDto);
		}
		System.out.println("-------------------------------------------------------------------------------------");
	}
}
