package exercise3;

public class Questions {
    
    public enum Operation {
        PLUS,
        MINUS,
        TIMES,
        DIVIDE;
    
        double calculate(double x, double y) {
            switch (this) {
                case PLUS:
                    return x + y;
                case MINUS:
                    return x - y;
                case TIMES:
                    return x * y;
                case DIVIDE:
                    return x / y;
                default:
                    throw new AssertionError("Unknown operations " + this);
            }
        }
    }

    public static double doStuff(Operation o, double x, double y) {
        return o.calculate(x, y);
    }

    public static void main(String[] args) {

        Operation op = Operation.DIVIDE;

        double result = Questions.doStuff(op, 1, 2);
        System.out.println(result); //3.0

    }
}