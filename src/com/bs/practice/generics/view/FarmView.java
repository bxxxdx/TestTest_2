package com.bs.practice.generics.view;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import com.bs.practice.generics.controller.FarmController;
import com.bs.practice.generics.model.vo.Farm;
import com.bs.practice.generics.model.vo.Fruit;
import com.bs.practice.generics.model.vo.Nut;
import com.bs.practice.generics.model.vo.Vegetable;

public class FarmView {
	FarmController fc = new FarmController();
	Scanner sc = new Scanner(System.in);

	public void mainMenu() {
		do {
			System.out.println("========== BS 마트 ==========");
			System.out.println("******** 메인 메뉴 ********");
			System.out.println("1. 직원 메뉴");
			System.out.println("2. 손님 메뉴");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 입력 : ");
			int input = sc.nextInt();
			switch (input) {
			case 1:
				adminMenu();
				break;
			case 2:
				customerMenu();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				break;
			}
		} while (true);
	}

	public void adminMenu() {
		do {
			System.out.println("******* 직원 메뉴 *******");
			System.out.println("1. 새 농산물 추가");
			System.out.println("2. 종류 삭제");
			System.out.println("3. 수량 수정");
			System.out.println("4. 농산물 목록");
			System.out.println("9. 메인으로 돌아가기");
			System.out.print("메뉴 번호 입력 : ");
			int input = sc.nextInt();
			switch (input) {
			case 1:
				addNewKind();
				break;
			case 2:
				removeKind();
				break;
			case 3:
				changeAmount();
				break;
			case 4:
				printFarm();
				break;
			case 9:
				System.out.println("메인으로 돌아갑니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				break;
			}
		} while (true);
	}

	public void customerMenu() {
		do {
			System.out.println("현재 BS마트 농산물 수량");
			printFarm();
			System.out.println("******* 고객 메뉴 *******");
			System.out.println("1. 농산물 사기");
			System.out.println("2. 농산물 빼기");
			System.out.println("3. 구입한 농산물 보기");
			System.out.println("9. 메인으로 돌아가기");
			System.out.print("메뉴 번호 입력 : ");
			int input = sc.nextInt();
			switch (input) {
			case 1:
				buyParm();
				break;
			case 2:
				removeFarm();
				break;
			case 3:
				printByFarm();
				break;
			case 9:
				System.out.println("메인으로 돌아갑니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				break;
			}
		} while (true);

	}

	public void addNewKind() {
		do {
			System.out.println("1. 과일 / 2. 채소 / 3. 견과");
			System.out.print("추가할 종류 번호 : ");
			int kindInteger = sc.nextInt();
			Farm f;
			System.out.print("이름 : ");
			String name = sc.next();
			System.out.print("수량 : ");
			int ea = sc.nextInt();
			boolean ret = false;
			switch (kindInteger) {
			case 1:
				f = new Fruit("과일", name);
				ret = fc.addNewKind(f, ea);
				break;
			case 2:
				f = new Vegetable("채소", name);
				ret = fc.addNewKind(f, ea);
				break;
			case 3:
				f = new Nut("견과", name);
				ret = fc.addNewKind(f, ea);
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				break;
			}
			if (ret && (kindInteger == 1 || kindInteger ==2 || kindInteger ==3)) {
				System.out.println("새 농산물이 추가되었습니다.");
				break;
			}
			else {
				System.out.println("새 농산물 추가에 실패하였습니다. 다시 입력해주세요.");

			}
		} while (true);
	}

	public void removeKind() {
		do {
			System.out.println("1. 과일 / 2. 채소 / 3. 견과");
			System.out.print("삭제할 종류 번호 : ");
			int kindInteger = sc.nextInt();
			System.out.print("이름 : ");
			String name = sc.next();
			boolean ret = false;
			Farm f;
			switch (kindInteger) {
			case 1:
				f = new Fruit("과일", name);
				ret = fc.removeKind(f);
				break;
			case 2:
				f = new Vegetable("채소", name);
				ret = fc.removeKind(f);
				break;
			case 3:
				f = new Nut("견과", name);
				ret = fc.removeKind(f);
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				break;
			}
			if (ret && (kindInteger == 1 || kindInteger ==2 || kindInteger ==3)) {
				System.out.println("농산물 삭제에 성공하였습니다.");
				break;
			}
			else {
				System.out.println("농산물 삭제에 실패하였습니다. 다시 입력해주세요.");
			}
		} while (true);
	}

	public void changeAmount() {
		do {
			System.out.println("1. 과일 / 2. 채소 / 3. 견과");
			System.out.print("수정할 종류 번호 : ");
			int kindInteger = sc.nextInt();
			Farm f;
			System.out.print("이름 : ");
			String name = sc.next();
			System.out.print("수정할 수량 : ");
			int ea = sc.nextInt();
			boolean ret = false;
			switch (kindInteger) {
			case 1:
				f = new Fruit("과일", name);	
				ret = fc.changeAmount(f, ea);
				break;
			case 2:
				f = new Vegetable("채소", name);
				ret = fc.changeAmount(f, ea);
				break;
			case 3:
				f = new Nut("견과", name);
				ret = fc.changeAmount(f, ea);
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				break;
			}
			if (ret && (kindInteger == 1 || kindInteger ==2 || kindInteger ==3)) {
				System.out.println("새 농산물이 추가되었습니다.");
				break;
			}
			else {
				System.out.println("농산물 수정에 실패하였습니다. 다시 입력해주세요.");
			}
		} while (true);

	}

	public void printFarm() {
		Set<Farm> keys = fc.printFarm().keySet();
		Iterator it = keys.iterator();
		String kind = "";
		String name = "";
		while (it.hasNext()) {
			Farm f = (Farm) it.next();
			if (f instanceof Fruit) {
				kind = "과일";
				name = ((Fruit) f).getName();
			} else if (f instanceof Vegetable) {
				kind = "야채";
				name = ((Vegetable) f).getName();
			} else if (f instanceof Nut) {
				kind = "견과";
				name = ((Nut) f).getName();
			}
			System.out.println(kind + " : " + name + "(" + fc.printFarm().get(f) + "개)");
		}

	}

	public void buyParm() {
		do {
			System.out.println("1. 과일 / 2. 채소 / 3. 견과");
			System.out.print("구매 종류 번호 : ");
			int kindInteger = sc.nextInt();
			Farm f;
			System.out.print("구매할 것 : ");
			String name = sc.next();
			boolean ret = false;
			switch (kindInteger) {
			case 1:
				f = new Fruit("과일", name);
				ret = fc.buyFarm(f);
				break;
			case 2:
				f = new Vegetable("채소", name);
				ret = fc.buyFarm(f);
				break;
			case 3:
				f = new Nut("견과", name);
				ret = fc.buyFarm(f);
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				break;
			}
			if (ret && (kindInteger == 1 || kindInteger ==2 || kindInteger ==3)) {
				System.out.println("구매에 성공하였습니다.");
				break;
			}
			else {
				System.out.println("마트에 없는 물건이거나 수량이 없습니다.");
			}
		} while (true);

	}

	public void removeFarm() {
		do {
			System.out.println("1. 과일 / 2. 채소 / 3. 견과");
			System.out.print("취소할 종류 번호 : ");
			int kindInteger = sc.nextInt();
			Farm f;
			System.out.print("이름 : ");
			String name = sc.next();
			boolean ret = false;
			switch (kindInteger) {
			case 1:
				f = new Fruit("과일", name);
				ret = fc.removeFarm(f);
				break;
			case 2:
				f = new Vegetable("채소", name);
				ret = fc.removeFarm(f);
				break;
			case 3:
				f = new Nut("견과", name);
				ret = fc.removeFarm(f);
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				break;
			}
			if (ret && (kindInteger == 1 || kindInteger ==2 || kindInteger ==3)) {
				System.out.println("구매 취소에 성공하였습니다.");
				break;
			}
			else {
				System.out.println("구매 목록에 존재하지 않습니다. 다시 입력해주세요.");
			}
		} while (true);
	}

	public void printByFarm() {
		Iterator it = fc.printBuyFarm().iterator();
		String kind = "";
		String name = "";
		while (it.hasNext()) {
			Farm f = (Farm) it.next();
			if (f instanceof Fruit) {
				kind = "과일";
				name = ((Fruit) f).getName();
			} else if (f instanceof Vegetable) {
				kind = "야채";
				name = ((Vegetable) f).getName();
			} else if (f instanceof Nut) {
				kind = "견과";
				name = ((Nut) f).getName();
			}
			System.out.println(kind + " : " + name);
		}
	}

}
