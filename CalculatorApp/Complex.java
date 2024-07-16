public class Complex {
    
    Rational real;
    Rational image;
    //
    Complex(Rational a) {
        real = a;
        image = new Rational(); 
    }
    Complex(Rational a, Rational b) {
        real = a;
        image = b;
    }
    Complex(double a, double b) {
        real = new Rational(a);
        image = new Rational(b);
    }
    //
    public String toString() {
        String plus = "";
        int whole = image.num / image.den;
        int rem = Math.abs(image.num % image.den);
        String s = "";
        if (image.num > 0) {
            plus = "+";
        }
        if (image.num < 0) {
            if (real.num != 0) {
                return real + "-" + plus + (-1 * image.num) + "i";
            } else {
                if (rem < 0) {
                    rem *= -1;
                    whole *= -1;
                }
                return whole + " " + rem + "/" + image.den + "i";
            }
        }
        if (image.num == 0 && real.num != 0) {
            return real.toString();
        }
        if (image.num == 0 && real.num == 0) {
            return "0";
        }
    
        if (whole != 0) {
            s += whole;
        }
        if (rem != 0) {
            if (whole != 0) {
                s += " ";
            }
            int gcd = Utility.findGCD(rem, image.den);
            int mixedNum = rem / gcd;
            int mixedDen = image.den / gcd;
            s += mixedNum + "/" + mixedDen;
        }
        return real + plus + s + "i";
    }
    //
  public Complex(String s) {
    s = s.replaceAll("\\s+", "");

    if (s.contains("+")) {
        String[] parts = s.split("\\+");
        this.real = new Rational(parts[0]);
        this.image = parts[1].endsWith("i") ? new Rational(parts[1].replace("i", "")) : new Rational(parts[1]);
    } 
    else if (s.contains("-")) {
        if (s.lastIndexOf("-") > 0) {
            String realPart = s.substring(0, s.lastIndexOf("-"));
            String imagPart = s.substring(s.lastIndexOf("-"));
            this.real = new Rational(realPart);
            this.image = new Rational(imagPart.replace("i", ""));
        }
        else {
            if (s.endsWith("i")) {
                this.real = new Rational(0);
                this.image = new Rational(s.replace("i", ""));
            } else {
                this.real = new Rational(s);
                this.image = new Rational(0);
            }
        }
    } 
    else if (s.contains("i")) {
        this.real = new Rational(0);
        this.image = s.equals("i") ? new Rational(1) : new Rational(s.replace("i", ""));
    } 
    else {
        this.real = new Rational(s);
        this.image = new Rational(0);
    }
}

    public Complex add(Complex other) {
        return new Complex(
            this.real.add(other.real),
            this.image.add(other.image)
        );
    }

    public Complex subtract(Complex other) {
        return new Complex(
            this.real.subtract(other.real),
            this.image.subtract(other.image)
        );
    }

    public Complex multiply(Complex other) {
        Rational realPart = this.real.multiply(other.real).subtract(this.image.multiply(other.image));
        Rational imagPart = this.real.multiply(other.image).add(this.image.multiply(other.real));
        return new Complex(realPart, imagPart);
    }

    public Complex divide(Complex other) {
        Rational denominator = other.real.multiply(other.real).add(other.image.multiply(other.image));
        Rational realPart = this.real.multiply(other.real).add(this.image.multiply(other.image)).divide(denominator);
        Rational imagPart = this.image.multiply(other.real).subtract(this.real.multiply(other.image)).divide(denominator);
        return new Complex(realPart, imagPart);
    }
}