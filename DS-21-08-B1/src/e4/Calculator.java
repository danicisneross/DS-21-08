package e4;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    /**
     * Lists where we will have the operations and the values
     * that we will use for said operations.
     */
    private final List<Operations> op;
    private final List<Float> values;

    /**
     * Public enum containing the operations that
     * can be used on the calculator.
     * hacerOp: allows us to determine what operation we are going to do.
     */

    public enum Operations {
        SUMA("+"),
        RESTA("-"),
        MULTIPLICACION("*"),
        DIVISION("/");
        private final String signo;

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

    /**
     * Public constructor of the calculator.
     */

    public Calculator() {
        this.op = new ArrayList<>();
        this.values = new ArrayList<>();
    }

    /**
     * Clean the internal state of the calculator.
     */

    public void cleanOperations() {
        this.op.clear();
        this.values.clear();
    }

    /**
     * Add a new operation to the internal state of the calculator.
     * It is worth mentioning that the calculator behaves in an accumulative way,
     * thus only first operation has two operands.
     * The rest of computations work with the accumulated value and only an extra
     * new operand. Second input value must be ignored if the operation does not
     * correspond to the first one.
     * @param operation operation to add , as string , "+" , " -" , "*" , "/".
     * @param values Operands of the new operation ( one or two operands ).
     * Uses the varargs feature.
     * @throws IllegalArgumentException If the operation does not exist.
     */

    public void addOperation(String operation, float... values) {
        //Operation op = Calculator.getSigno;

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

    /**
     * Execute the set of operations of the internal state of the calculator.
     * Once execution is finished , internal state (operands and operations)
     * is restored (EVEN if exception occurs).
     * This calculator works with " Batches " of operations.
     * @return result of the execution.
     * @throws ArithmeticException If the operation returns an invalid value (division by zero).
     */

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
    // Iterator<Operation> operationIterator = operationList.iterator();  //manera de recorrer un array list
    //con operationIterator.hasNext()
    //con operationIterator.next();

    /**
     * Current internal state of calculator is printed.
     * FORMAT:
     * "[{+/ -/"/"/*}] value1_value2 [{+/ -/"/"/*}] value1 [{+/ -/"/"/*}] value1 {...}".
     * @return String of the internal state of the calculator.
     */

    @Override
    public String toString() {
        StringBuilder opS = new StringBuilder("[STATE:");
        String condicion = "[STATE:]";

        try {
            for (int j = 0; j < values.size(); j++) {
                for (Operations operations : op) {
                    if (operations == Operations.SUMA) {
                        opS.append(("[+]"));
                        j++;
                    } else if (operations == Operations.RESTA) {
                        opS.append(("[-]"));
                        j++;
                    } else if (operations == Operations.MULTIPLICACION) {
                        opS.append(("[*]"));
                        j++;
                    } else if (operations == Operations.DIVISION) {
                        opS.append(("[/]"));
                        j++;
                    } else {
                        opS.append("]");
                    }
                    if (!opS.equals(condicion)) {
                        if (j == 1) {
                            opS.append(values.get(0) + "_" + values.get(1));
                        } else {
                            opS.append(values.get(j));
                        }
                    }
                }
            }
            opS.append("]");
        } catch (ArithmeticException a){
            opS.append("]");
        }
        return opS.toString();
    }
}