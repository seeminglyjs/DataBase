package ex1;

import java.sql.SQLException;

import com.seeminglyjs.app.console.NoticeConsole;

public class Program5 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		NoticeConsole console = new NoticeConsole();
			loop: 
			while(true) {
			console.printNoticeList();
			int menu = console.inputNoticeMenu();
			
			switch(menu) {
			case 1: //상세조회
				break;
			case 2: //이전
				console.movePrevList();
				break;
			case 3:	//다음
				console.moveNextList();
				break;
			case 4: //글쓰기
				break;
			case 5: //검색
				console.inputSearchWord();
				break;
			case 6: //종료
				System.out.println("Bye");	
				break loop;
			default:
				System.out.println("잘못된 입력입니다.");
				break;
			}
		}
	
	}

}
