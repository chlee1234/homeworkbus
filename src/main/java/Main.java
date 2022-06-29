import java.util.Scanner;

class Bus {
    int maxPsg; // 최대 승객수
    int curPsg; // 현재 승객수
    int fare; // 요금
    int busNum; //버스 번호
    int oil; // 주유량
    int speed; // 현재 속도
    String status; // 상태

    public Bus(int busNum, String status, int oil, int speed, int maxPsg, int curPsg, int fare) {
        this.busNum = busNum;
        this.status = status;
        this.oil = oil;
        this.speed = speed;
        this.maxPsg = maxPsg;
        this.curPsg = curPsg;
        this.fare = fare;
    }

    public void busInfo() { // 버스 번호
        System.out.println("버스번호는 " + busNum + "입니다.");
    }

    public void changeStatus() { //버스 상태 변경

        if (oil == 0 || status.equals("운행 종료")) {
            status = "차고지행";
            System.out.println("현재 상태는 " + status + "입니다.");
        }
        if (oil < 10) {
            System.out.println("주유가 필요합니다.");
        }

    }
    public void takeBus(){  //승객 탑승

        if(curPsg<maxPsg) {
            curPsg++;
            System.out.println("승객이 탑승했습니다.");
            System.out.println("현재 승객수는 "+curPsg+"명 입니다.");
            System.out.println("최대 승객수는 "+maxPsg+"명 입니다.");
        }else {
            System.out.println("만석으로 버스 탑승이 불가능합니다.");
        }


    }
    public void changeSpeed(){ // 속도 변경
        if(oil<10){
            System.out.println("주유량을 확인해 주세요.");
        }
        int chSpeed = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("현재 속도는 "+speed+"입니다. 변경할 속도를 입력해 주세요 speed :");
        chSpeed = sc.nextInt();
        speed = chSpeed;
        System.out.println("현재 속도는 "+speed+"입니다.");
    }


}
public class Main {
    public static void main(String[] args) {
        Bus bus = new Bus(651,"운행 중",0,30,30,10,1300);
        bus.busInfo();
        bus.changeStatus();
        if(bus.status.equals("운행 중")) {
            bus.takeBus();
            bus.changeSpeed();
        }
    }
}
