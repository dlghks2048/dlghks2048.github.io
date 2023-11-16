package org.javaro.house;
import java.util. *;
public class CafeMenu {
	public static void main(String[] args) {
		CafeStore cafeStore = new CafeStore("카페");
		int menu;
		boolean check = true;
		Scanner scan = new Scanner(System.in);
		do{
			System.out. println(" ----메뉴----");
			System.out. println("1. 음료 주문");
			System.out. println("2. 알콜 주문");
			System.out.println("3. 영수증");
			System.out. println("4. 종료");
			System.out. println("메뉴 선택:");
			menu = scan.nextInt();
			switch (menu) {
			case 1:
				System.out.println("1. 음료 주문 선택함");
				System.out. println("음료 이름 입력:");
				String product = scan.next();
				System.out. println("가격 입력:");
				int price = scan.nextInt();
				System.out.println("갯수 입력:");
				int quantity = scan.nextInt();
				BeverageX beverage = new BeverageX(product, price, quantity);
				cafeStore.addBeverage(beverage);
				break;
			case 2:
				System.out.println("2. 알콜 주문 선택함");
				System.out. println("알콜 이름입력:");
				product = scan.next();
				System.out.println("가격 입력:");
				price = scan.nextInt();
				System.out. println("갯수 입력:");
					quantity = scan.nextInt();
					System.out. println("알콜 도수 입력:");
					float alcohol = scan.nextFloat();
					Liquor liquor = new Liquor(product, price, quantity, alcohol);
					cafeStore.addLiquor(liquor);
					break;
			case 3:
					System.out.println("3. 영수증 인쇄 선택함");
					cafeStore.printReceipt();
					break;
			case 4:
				System.out. println("4. 종료 선택하였습니다");
				check = false;
				break;
			default:
				System.out. println("잘못된 입력함 새로 입력하세요");
			}
		} while(check);
	scan.close();
		}
}

class CafeStore {
	String storeName; // store 이름
	ArrayList<BeverageX> beverages; //<BeverageX> 음료 ArrayList 선언
	ArrayList<Liquor> liquors; // <Liquor> 주류 ArrayList 선언
	CafeStore(String storeName) {
		this.storeName = storeName; // 카페 이름
		beverages= new ArrayList<BeverageX>();// beverages ArrayList 할당
		liquors = new ArrayList<Liquor>(); // liquors ArrayList 할당
	}
	public String getStoreName(){
		return this.storeName;
	}
	public ArrayList<BeverageX> getBeverages(){
		return this.beverages;
	}

	public ArrayList<Liquor> getLiquors(){
		return this.liquors;
	}
	// add() 이용 beverages 리스트의 마지막에 음료 추가
	public void addBeverage(BeverageX beverage) {
		this.beverages.add(beverage); 
	}
	// add() 이용 liquors 리스트의 마지막에 liquor 추가
	public void addLiquor(Liquor liquor) {
		this.liquors.add(liquor);
	}
	// 영수증 인쇄
	public void printReceipt(){
		System.out.println("--영수증--"); //영수증
		int sum=0; 
		if (this.getBeverages().isEmpty() == false) {
			System.out.println("제품명 \t\t단가\t수량\t금액");
			for(BeverageX aBeverage: this.getBeverages()) { // 음료 모두 인쇄
				sum = sum + aBeverage.price * aBeverage.quantity;
				System.out.println(aBeverage.product+"\t\t"+aBeverage.price
					+"\t"+aBeverage.quantity+"\t"+aBeverage.getTotal());
			}
		}
		if(this.getLiquors().isEmpty() == false) {
			System.out.println("제품명(알콜) \t단가\t수량\t금액");
			for(Liquor aLiquor : this.getLiquors()){// 알콜 모두 인쇄
				sum = sum + aLiquor.price * aLiquor.quantity;
				System.out.println(aLiquor.product+"\t\t"+aLiquor.price + "\t" + aLiquor.quantity+"\t"+ aLiquor.getTotal());
			}
			if(this.getBeverages().isEmpty() == false || this.getLiquors().isEmpty() == false) {
				System.out.println("총 영수금액="+sum);
			}
		}
	}
}



class BeverageX{ //클래스 선언
	String product; int price; int quantity;
	public BeverageX(String product, int price, int quantity) {
		this.product = product;
		this.price=price;this.quantity=quantity;
	}
	public String getProduct(){
		return this.product;
	}
	public int getPrice(){
		return this.price;
	}
	public int getQuantity() {
		return this.quantity;
	}
	public int getTotal() {
		return this.price*this.quantity;
	}
	void printTitle() {
		System.out.println("제품명 \t\t단가\t수량\t금액");
	}
	void printData() {
		System.out. println(product+"\t\t"+price
				+"\t"+quantity+"\t"+getTotal());
	}
}

class Liquor extends BeverageX{
	// 알콜도수 추가 
	float alcohol;
	public Liquor(String product, int price, int quantity, float alcohol) { //생성자
		super(product, price, quantity);
		this.alcohol = alcohol;
	}
	void printTitle() {
 		System.out.println("제품명(알콜) \t단가\t수량\t금액");
	}
	void printData() {
		System.out.println(product+"\t\t"+price + "\t" + quantity+"\t"+ getTotal());
	}
}
