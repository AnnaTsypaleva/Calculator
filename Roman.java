package Calculator;

public class Roman extends Number {			// римские в арабские, затем считаем, затем обратно в римские

    private int firstRomanAsInt;			// римские цифры переведённые в арабские
    private int secondRomanAsInt;

    private String result;

    private final static String[] ROMANTENS = {"0","X","XX","XXX","XL","L","LX","LXX","LXXX","XC","C"};
    private final static String[] ROMANUNITS = {"0","I","II","III","IV","V","VI","VII","VIII","IX","X"};

    public static String[] getRomanUnits() {
        return ROMANUNITS;
    }

    public Roman(String firstRoman, String secondRoman) {
        firstRomanAsInt = toInt(firstRoman);
        secondRomanAsInt = toInt(secondRoman);
    }

    public void add() {
        result = toRoman(firstRomanAsInt + secondRomanAsInt);
    }
    public void subtract() {
        result = toRoman(firstRomanAsInt - secondRomanAsInt);
    }
    public void multiply() {
        result = toRoman(firstRomanAsInt * secondRomanAsInt);
    }
    public void divide() {
        result = toRoman(firstRomanAsInt / secondRomanAsInt);
    }

    public String getStringResult() {
        return result;
    }

    public int getResult() {
        return 5;
    }


    private int toInt(String roman) {
        int i = 0;
        while (!roman.equals(ROMANUNITS[i])) {
            i++;
        }
        return i;
    }

    private String toRoman(int arabic) {



        if (arabic == 100)
            return "C";

        if (arabic < 0) {
            return ("-" + ROMANUNITS[-arabic]);		// проверка для отрицательных чисел [-(-3)]
            // возвращается "-III"
        }

        int units = arabic % 10;					// 34 % 10 = 4 тогда в переменной tens 3 а в переменной units 4
        int tens = (arabic - units) / 10;

        String romanUnits = ROMANUNITS[units];			// "IV"
        String romanTens = ROMANTENS[tens];				// "XXX"

        if (tens == 0)
            return romanUnits;
        if (units == 0)
            return romanTens;

        return (romanTens + romanUnits);					// "XXX" + "IV" = "XXXIV"
    }
}


