package Calculator;

public class Arabic extends Number {
    private int first;
    private int second;
    private int result;

    public Arabic(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public void add() {
        this.result = first + second;
    }

    public void subtract() {
        this.result = first - second;
    }

    public void multiply() {
        this.result = first * second;
    }

    public void divide() {
        this.result = first / second;
    }

    public int getResult() {
        return result;
    }

    public String getStringResult() {
        return Integer.toString(result);
    }


}
