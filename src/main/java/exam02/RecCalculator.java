package exam02;
//재귀적 방식
public class RecCalculator implements Calculator{

    @Override
    public long factorial(long num) {

            if (num == 0) { //factorial 음수 X
                return 1;
            }
            return num * factorial(num - 1);
        }
}
