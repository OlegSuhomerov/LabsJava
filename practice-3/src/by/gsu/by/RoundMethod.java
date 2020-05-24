package by.gsu.by;

public enum RoundMethod {
    FLOOR{
        double roundFunction(double number){
            return Math.floor(number);
        }
    },
    ROUND{
        double roundFunction(double number){
            return Math.round(number);
        }
    },
    CEIL{
        double roundFunction(double number){
            return Math.ceil(number);
        }
    };
	
    abstract double roundFunction(double number);
    int round(double roundedValue, int d) {
		int tenPow = pow10( d);
		int result = (int) roundFunction(roundedValue / tenPow) * tenPow;
		return result;
	}
    static int pow10 (int d) {
        if(d == 0) return 1;
        int result = 10;
        for(int i = 1; i < d; i++) {
            result *= 10;
        }
        return result;
    }
}
