package com.example.andcalc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;

import java.math.BigDecimal;

public class MainActivity extends Activity {

    private static String firstNum = "";
    private static String secondNum = "";
    private static String tmpSecondNum = "";
    private static String tmpOper = "";
    private static String prevScreen = "";
    private static boolean error = false;
    private static boolean letsAddNewNumber = false;
    private final static String PLUS_OPER = "PLUS";
    private final static String MINUS_OPER = "MINUS";
    private final static String DIV_OPER = "DIV";
    private final static String MULT_OPER = "MULT";
    private final static String CANCEL_OPER = "CANCEL";
    private final static String EQUAL_OPER = "EQUAL";
    private final static String BACKSPACE_OPER = "BACKSPACE";
    private static TextView screen;
    private static Button bOne;
    private static Button bTwo;
    private static Button bThree;
    private static Button bFour;
    private static Button bFive;
    private static Button bSix;
    private static Button bSeven;
    private static Button bEight;
    private static Button bNine;
    private static Button bDot;
    private static Button bZero;
    private static Button bMinus;
    private static Button bPlus;
    private static Button bMult;
    private static Button bDiv;
    private static Button bEqual;
    private static Button bCancel;
    private static Button bBack;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        screen = (TextView) findViewById(R.id.textView);
        bOne = (Button) findViewById(R.id.button9);
        bTwo = (Button) findViewById(R.id.button10);
        bThree = (Button) findViewById(R.id.button11);
        bFour = (Button) findViewById(R.id.button5);
        bFive = (Button) findViewById(R.id.button6);
        bSix = (Button) findViewById(R.id.button7);
        bSeven = (Button) findViewById(R.id.button1);
        bEight = (Button) findViewById(R.id.button2);
        bNine = (Button) findViewById(R.id.button3);
        bDot = (Button) findViewById(R.id.button14);
        bZero = (Button) findViewById(R.id.button13);
        bMinus = (Button) findViewById(R.id.button8);
        bPlus = (Button) findViewById(R.id.button4);
        bMult = (Button) findViewById(R.id.button12);
        bDiv = (Button) findViewById(R.id.button15);
        bEqual = (Button) findViewById(R.id.button18);
        bCancel = (Button) findViewById(R.id.button16);
        bBack = (Button) findViewById(R.id.button17);

        setViewName();

        // создание обработчика
        OnClickListener oclBtn = new OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.string.bOne: {
                        //if (!error)
                         //   pressedKey("1");
                        screen.setText("34123");
                        break;
                    }
                    case R.id.button8: {
//                        if (!error)
//                            pressedKey("2");
                        screen.setText("34123");
                        break;
                    }
                }

            }
        };
        bOne.setOnClickListener(oclBtn);
        bTwo.setOnClickListener(oclBtn);
    }

    private void setViewName() {
        screen.setText(R.string.screen);
        bOne.setText(R.string.bOne);
        bTwo.setText(R.string.bTwo);
        bThree.setText(R.string.bThree);
        bFour.setText(R.string.bFour);
        bFive.setText(R.string.bFive);
        bSix.setText(R.string.bSix);
        bSeven.setText(R.string.bSeven);
        bEight.setText(R.string.bEight);
        bNine.setText(R.string.bNine);
        bDot.setText(R.string.bDot);
        bZero.setText(R.string.bZero);
        bMinus.setText(R.string.bMinus);
        bPlus.setText(R.string.bPlus);
        bMult.setText(R.string.bMult);
        bDiv.setText(R.string.bDiv);
        bEqual.setText(R.string.bEqual);
        bCancel.setText(R.string.bCancel);
        bBack.setText(R.string.bBack);
    }

    private static String parseDot0(String str) {
        String integerPart;
        String fractionalPart;
        if (str.contains(".") && !str.contains("E")) {
            integerPart = str.substring(0, str.indexOf("."));
            fractionalPart = str.substring(str.indexOf("."));
            for (int i = fractionalPart.length() - 1; i != -1; i--) {
                if (fractionalPart.charAt(i) == '0') {
                    continue;
                } else {
                    fractionalPart = fractionalPart.substring(0, i + 1);
                    if (fractionalPart.charAt(i) == '.')
                        return integerPart;
                    return integerPart.concat(fractionalPart);
                }
            }
        }
        return str;
    }

    private static void displayResult(String result) {
        String out;
        clearScreen();
        out = dotsCountChecker(result);
        out = trim(out, true);
        out = expChecker(out);
        screen.setText(out);
        prevScreen = (String) screen.getText();
    }

    private static void displayOperand(String operand) {
        String out;
        if (letsAddNewNumber) {
            clearScreen();
            letsAddNewNumber = false;
        }
        out = dotsCountChecker(operand);
        out = trim(out, false);
        out = expChecker(out);
        screen.setText(out);
        prevScreen = (String) screen.getText();
    }

    private static String dotsCountChecker(String in) {
        String out;
        if (!in.equals(".")) {
            if (!screen.getText().equals("0"))
                out = screen.getText() + in;
            else out = in;
        } else {
            if (screen.getText().equals("")) {
                out = "0.";
            } else if (screen.getText().toString().contains(".")) {
                out = screen.getText() + in;
            } else {
                out = (String) screen.getText();
            }
        }
        return out;
    }

    private static String expChecker (String in) {
        if (in.contains("E")) {
            in = "e" + prevScreen;
            error = true;
        }
        return in;
    }

    private static String trim(String out, boolean isAnswer) {
        if (out.contains(".")) {
            int intPartLength = out.substring(0, out.indexOf(".")).length();
            int fractPartLength = out.substring(out.indexOf(".")).length();
            if (intPartLength + fractPartLength > 10) {
                if (intPartLength >= 10) {
                    if (intPartLength == 10 && fractPartLength >= 1)
                        out = out.substring(0, 10);
                    else out = out.substring(0, 11);
                    if (isAnswer) {
                        out = "e" + out + ".";
                        error = true;
                    }
                } else {
                    out = out.substring(0, 11);
                }
            }
        } else if (out.length() > 11) {
            out = out.substring(0, 11);
            if (isAnswer) {
                out = "e" + out;
                error = true;
            }
        }
        return out;
    }

    private void pressedKey(String instruction) {
        /* number button was pressed */
        if (!isOperation(instruction)) {
            displayOperand(instruction);
        }
        /* operation button was pressed */
        else {
            if (instruction.equals(EQUAL_OPER)) {
                secondNum = (String) screen.getText();
                if (tmpSecondNum.length() == 0)
                    tmpSecondNum = secondNum;
                secondNum = tmpSecondNum;
                displayResult(parseDot0(doCalc(firstNum, secondNum, tmpOper)));
                firstNum = (String) screen.getText();
                letsAddNewNumber = true;
            } else if (instruction.equals(CANCEL_OPER)) {
                clearParams();
            } else if (instruction.equals(BACKSPACE_OPER)) {
                backSpace();
            } else {
                letsAddNewNumber = true;
                firstNum = (String) screen.getText();
                tmpOper = instruction;
                tmpSecondNum = "";
            }
        }
    }

    private static String doCalc(String firstNum, String secondNum, String operation) {
        String result = "";
        BigDecimal f = new BigDecimal(firstNum);
        BigDecimal s = new BigDecimal(secondNum);
        if (operation.equals(PLUS_OPER)) {
            f = f.add(s);
            result = String.valueOf(f);
        } else if (operation.equals(MINUS_OPER)) {
            f = f.subtract(s);
            result = String.valueOf(f);
        } else if (operation.equals(MULT_OPER)) {
            f = f.multiply(s);
            result = String.valueOf(f);
        } else if (operation.equals(DIV_OPER)) {
            BigDecimal bd3 = f.divide(s, 9, BigDecimal.ROUND_HALF_UP);
            result = String.valueOf(bd3);
        }
        return result;
    }

    private static boolean isOperation(String instruction) {
        boolean isOper = false;
        if (instruction.equals(EQUAL_OPER) || instruction.equals(CANCEL_OPER) || instruction.equals(PLUS_OPER) ||
                instruction.equals(MINUS_OPER) || instruction.equals(DIV_OPER) || instruction.equals(MULT_OPER) ||
                instruction.equals(BACKSPACE_OPER)) {
            isOper = true;
        }
        return isOper;
    }

    private static void clearParams() {
        firstNum = "";
        secondNum = "";
        tmpSecondNum = "";
        error = false;
        screen.setText("0");
    }

    private static void backSpace() {
        if (letsAddNewNumber)
            return;
        if (error) {
            error = false;
            screen.setText(screen.getText().subSequence(1, screen.length() - 1));
        } else {
            if (screen.getText().length() > 1)
                screen.setText(screen.getText().subSequence(0, screen.getText().length() - 1));
            else screen.setText("0");
        }
    }

    private static void clearScreen() {
        screen.setText("");
    }

}

