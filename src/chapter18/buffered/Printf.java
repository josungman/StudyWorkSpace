package chapter18.buffered;

//이것이 자바다 1042p printf 메서드 사용 예
public class Printf {

	public static void main(String[] args) {

		//데이터의 포멧 결정
		System.out.printf("상품의 가격:%d원\n",123);	
		System.out.printf("상품의 가격:%6d원\n",123);
		System.out.printf("상품의 가격:%-6d원\n",123);
		System.out.printf("상품의 가격:%06d원\n",123);
		
		// 형식화된 문자열(format)과 아규먼트 간의 순서가 매칭되어 출력된다.
		System.out.printf("반지름이 %d인 원의 넓이:%10.2f\n",10,Math.PI*10*10);
		
		
	}

}
