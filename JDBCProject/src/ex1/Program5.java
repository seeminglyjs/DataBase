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
			case 1: //����ȸ
				break;
			case 2: //����
				console.movePrevList();
				break;
			case 3:	//����
				console.moveNextList();
				break;
			case 4: //�۾���
				break;
			case 5: //�˻�
				console.inputSearchWord();
				break;
			case 6: //����
				System.out.println("Bye");	
				break loop;
			default:
				System.out.println("�߸��� �Է��Դϴ�.");
				break;
			}
		}
	
	}

}
