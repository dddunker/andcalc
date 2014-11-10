package com.example.andcalc;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
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

        screen = (TextView) findViewById(R.id.screen);
        bOne = (Button) findViewById(R.id.bOne);
        bTwo = (Button) findViewById(R.id.bTwo);
        bThree = (Button) findViewById(R.id.bThree);
        bFour = (Button) findViewById(R.id.bFour);
        bFive = (Button) findViewById(R.id.bFive);
        bSix = (Button) findViewById(R.id.bSix);
        bSeven = (Button) findViewById(R.id.bSeven);
        bEight = (Button) findViewById(R.id.bEight);
        bNine = (Button) findViewById(R.id.bNine);
        bDot = (Button) findViewById(R.id.bDot);
        bZero = (Button) findViewById(R.id.bZero);
        bMinus = (Button) findViewById(R.id.bMinus);
        bPlus = (Button) findViewById(R.id.bPlus);
        bMult = (Button) findViewById(R.id.bMult);
        bDiv = (Button) findViewById(R.id.bDiv);
        bEqual = (Button) findViewById(R.id.bEqual);
        bCancel = (Button) findViewById(R.id.bCancel);
        bBack = (Button) findViewById(R.id.bBack);

        setViewName();
        colorize();
        screen.setGravity(Gravity.CENTER_VERTICAL | Gravity.RIGHT);


        // создание обработчика
        OnClickListener oclBtn = new OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.bOne: {
                        if (!error)
                            pressedButton("1");
                        break;
                    }
                    case R.id.bTwo: {
                        if (!error)
                            pressedButton("2");
                        break;
                    }
                    case R.id.bThree: {
                        if (!error)
                            pressedButton("3");
                        break;
                    }
                    case R.id.bFour: {
                        if (!error)
                            pressedButton("4");
                        break;
                    }
                    case R.id.bFive: {
                        if (!error)
                            pressedButton("5");
                        break;
                    }
                    case R.id.bSix: {
                        if (!error)
                            pressedButton("6");
                        break;
                    }
                    case R.id.bSeven: {
                        if (!error)
                            pressedButton("7");
                        break;
                    }
                    case R.id.bEight: {
                        if (!error)
                            pressedButton("8");
                        break;
                    }
                    case R.id.bNine: {
                        if (!error)
                            pressedButton("9");
                        break;
                    }
                    case R.id.bDot: {
                        if (!error)
                            pressedButton(".");
                        break;
                    }
                    case R.id.bZero: {
                        if (!error)
                            pressedButton("0");
                        break;
                    }
                    case R.id.bDiv: {
                        if (!error)
                            pressedButton(DIV_OPER);
                        break;
                    }
                    case R.id.bMult: {
                        if (!error)
                            pressedButton(MULT_OPER);
                        break;
                    }
                    case R.id.bMinus: {
                        if (!error)
                            pressedButton(MINUS_OPER);
                        break;
                    }
                    case R.id.bPlus: {
                        if (!error)
                            pressedButton(PLUS_OPER);
                        break;
                    }
                    case R.id.bEqual: {
                        if (!error)
                            pressedButton(EQUAL_OPER);
                        break;
                    }
                    case R.id.bCancel: {
                        pressedButton(CANCEL_OPER);
                        break;
                    }
                    case R.id.bBack: {
                        pressedButton(BACKSPACE_OPER);
                        break;
                    }
                }
            }
        };
        bOne.setOnClickListener(oclBtn);
        bTwo.setOnClickListener(oclBtn);
        bThree.setOnClickListener(oclBtn);
        bFour.setOnClickListener(oclBtn);
        bFive.setOnClickListener(oclBtn);
        bSix.setOnClickListener(oclBtn);
        bSeven.setOnClickListener(oclBtn);
        bEight.setOnClickListener(oclBtn);
        bNine.setOnClickListener(oclBtn);
        bDot.setOnClickListener(oclBtn);
        bZero.setOnClickListener(oclBtn);
        bDiv.setOnClickListener(oclBtn);
        bMult.setOnClickListener(oclBtn);
        bMinus.setOnClickListener(oclBtn);
        bPlus.setOnClickListener(oclBtn);
        bEqual.setOnClickListener(oclBtn);
        bCancel.setOnClickListener(oclBtn);
        bBack.setOnClickListener(oclBtn);
    }

    private void colorize() {
        screen.setBackgroundColor(getResources().getColor(R.color.screen));
        screen.setTextColor(getResources().getColor(R.color.screenText));
        bOne.setBackgroundResource(R.drawable.num_buttons);
        bTwo.setBackgroundResource(R.drawable.num_buttons);
        bThree.setBackgroundResource(R.drawable.num_buttons);
        bFour.setBackgroundResource(R.drawable.num_buttons);
        bFive.setBackgroundResource(R.drawable.num_buttons);
        bSix.setBackgroundResource(R.drawable.num_buttons);
        bSeven.setBackgroundResource(R.drawable.num_buttons);
        bEight.setBackgroundResource(R.drawable.num_buttons);
        bNine.setBackgroundResource(R.drawable.num_buttons);
        bDot.setBackgroundResource(R.drawable.num_buttons);
        bZero.setBackgroundResource(R.drawable.num_buttons);
        bDiv.setBackgroundResource(R.drawable.calc_buttons);
        bMult.setBackgroundResource(R.drawable.calc_buttons);
        bMinus.setBackgroundResource(R.drawable.calc_buttons);
        bPlus.setBackgroundResource(R.drawable.calc_buttons);
        bEqual.setBackgroundResource(R.drawable.oper_buttons);
        bCancel.setBackgroundResource(R.drawable.oper_buttons);
        bBack.setBackgroundResource(R.drawable.oper_buttons);

        bCancel.setTextColor(getResources().getColor(R.color.buttonText));
        bBack.setTextColor(getResources().getColor(R.color.buttonText));
        bEqual.setTextColor(getResources().getColor(R.color.buttonText));
        bPlus.setTextColor(getResources().getColor(R.color.buttonText));
        bMinus.setTextColor(getResources().getColor(R.color.buttonText));
        bDiv.setTextColor(getResources().getColor(R.color.buttonText));
        bMult.setTextColor(getResources().getColor(R.color.buttonText));
        bOne.setTextColor(getResources().getColor(R.color.buttonText));
        bTwo.setTextColor(getResources().getColor(R.color.buttonText));
        bThree.setTextColor(getResources().getColor(R.color.buttonText));
        bFour.setTextColor(getResources().getColor(R.color.buttonText));
        bFive.setTextColor(getResources().getColor(R.color.buttonText));
        bSix.setTextColor(getResources().getColor(R.color.buttonText));
        bSeven.setTextColor(getResources().getColor(R.color.buttonText));
        bEight.setTextColor(getResources().getColor(R.color.buttonText));
        bNine.setTextColor(getResources().getColor(R.color.buttonText));
        bZero.setTextColor(getResources().getColor(R.color.buttonText));
        bDot.setTextColor(getResources().getColor(R.color.buttonText));
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
            } else if (!screen.getText().toString().contains(".")) {
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

    private void pressedButton(String instruction) {
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

