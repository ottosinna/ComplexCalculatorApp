public class Rational {
	int num;
    int den;

    public Rational(int m, int n) {
        int gcd = Utility.findGCD(m, n);
        m = m / gcd;
        n = n / gcd;
        num = m;
        den = n;
    }

    public Rational() {
        num = 1;
        den = 2;
    }

    public Rational(int n) {
        num = n;
        den = 1;
    }

    public Rational(String s) {
        s = s.trim();
        if (s.contains("/")) {
            String[] parts = s.split("/");
            if (parts.length == 2) {
                num = Integer.parseInt(parts[0]);
                den = Integer.parseInt(parts[1]);
            } else {
                throw new IllegalArgumentException("Invalid fraction format");
            }
        } else if (s.contains(".")) {
            double d = Double.parseDouble(s);
            Rational r = new Rational(d);
            num = r.num;
            den = r.den;
        } else {
            num = Integer.parseInt(s);
            den = 1;
        }
        simplify();
    }
    
    private void simplify() {
        int gcd = Utility.findGCD(Math.abs(num), Math.abs(den));
        num /= gcd;
        den /= gcd;
        if (den < 0) {
            num = -num;
            den = -den;
        }
    }

    public Rational(double d) {
        String s = String.valueOf(d);
        String[] rAt = s.split("\\.");

        if (Integer.parseInt(rAt[0]) != 0) {
            num = Integer.parseInt(rAt[0]);
        }
        String bond = "1";
        for (int i = 0; i < rAt[1].length(); i++) {
            bond += "0";
        }
        num = (Integer.parseInt(rAt[0]) * Integer.parseInt(bond)) + Integer.parseInt(rAt[1]);
        den = Integer.parseInt(bond);
        if (num != 0) {
            int c = Utility.findGCD(num, den);
            num = num / c;
            den = den / c;
        }
    }

    public String toString() {
        int whole = num / den;
        int rem = Math.abs(num % den);  
        String s = "";
        if (num < 0 && whole == 0) {
            s += "-";
        }
        if (whole != 0) {
            s += whole;
        }
        if (rem != 0) {
            if (whole != 0) {
                s += " ";
            }
            int gcd = Utility.findGCD(rem, den);
            int newNum = rem / gcd;
            int newDen = den / gcd;
            s += newNum + "/" + newDen;
        }
        if (s.isEmpty()) {
            s = "0";
        }
        return s;
    }
    public Rational add(Rational other) {
        int newNum = this.num * other.den + other.num * this.den;
        int newDen = this.den * other.den;
        return new Rational(newNum, newDen);
    }

    public Rational subtract(Rational other) {
        int newNum = this.num * other.den - other.num * this.den;
        int newDen = this.den * other.den;
        return new Rational(newNum, newDen);
    }

    public Rational multiply(Rational other) {
        return new Rational(this.num * other.num, this.den * other.den);
    }

    public Rational divide(Rational other) {
        return new Rational(this.num * other.den, this.den * other.num);
    }
}