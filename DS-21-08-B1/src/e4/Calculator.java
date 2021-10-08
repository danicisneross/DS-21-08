package e4;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private List<Operations> op;
    private List<Float> values;

    public enum Operations {
        SUMA("[+]"),
        RESTA("[-]"),
        MULTIPLICACION("[*]"),
        DIVISION("[/]");
        private String signo;

        public String getSigno(Operations operations) {
            return signo;
        }

        Operations(String signo) {
            this.signo = signo;
        }

        public float hacerOp(float value1, float value2) throws ArithmeticException {
            float result;

            switch (this) {
                case SUMA -> result = value1 + value2;
                case RESTA -> result = value1 - value2;
                case MULTIPLICACION -> result = value1 * value2;
                case DIVISION -> {
                    if (value2 == 0f) {
                        throw new ArithmeticException();
                    } else {
                        result = value1 / value2;
                    }
                }
                default -> throw new IllegalArgumentException();
            }
            return result;
        }
    }

    public Calculator() {
        this.op = new ArrayList<>();
        this.values = new ArrayList<>();
    }

    public void cleanOperations() {
        this.op.clear();
        this.values.clear();
    }

    public void addOperation(String operation, float... values) {

        if (this.values.size() == 0) {
            if (values.length == 2) {
                this.values.add(values[0]);
                this.values.add(values[1]);
            } else {
                throw new IllegalArgumentException();
            }
        } else {
            this.values.add(values[0]);
        }

        switch (operation) {
            case "+" -> this.op.add(Operations.SUMA);
            case "-" -> this.op.add(Operations.RESTA);
            case "*" -> this.op.add(Operations.MULTIPLICACION);
            case "/" -> this.op.add(Operations.DIVISION);
            default -> {
                this.cleanOperations();
                throw new IllegalArgumentException();
            }
        }
    }

    public float executeOperations() {
        float result = 0;

        for (int i = 0; i < op.size(); i++) {
            if (i == 0) {
                try {
                    result = op.get(0).hacerOp(values.get(0), values.get(1));

                } catch (ArithmeticException a) {
                    this.cleanOperations();
                    throw new ArithmeticException();
                }
            } else {
                try {
                    result = op.get(i).hacerOp(result, values.get(i + 1));
                } catch (ArithmeticException a) {
                    this.cleanOperations();
                    throw new ArithmeticException();
                }
            }
        }
        this.cleanOperations();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder opS = new StringBuilder("[STATE:");
        String condicion = "[STATE:]";

        for (Operations operations : op) {
            if (operations == Operations.SUMA) {
                opS.append(("[+]"));
            } else if (operations == Operations.RESTA) {
                opS.append(("[-]"));
            } else if (operations == Operations.MULTIPLICACION) {
                opS.append(("[*]"));
            } else if (operations == Operations.DIVISION) {
                opS.append(("[/]"));
            } else {
                opS.append("]");
            }
            if (!opS.equals(condicion)) {
                for (int j = 0; j < values.size(); j++) {
                    if (j == 0) {
                        opS.append(values.get(0) + "_" + values.get(1));
                    } else {
                        opS.append(values.get(j + 1) );
                    }
                }
                opS.append("]");
            }
        }
        return opS.toString();
    }
}