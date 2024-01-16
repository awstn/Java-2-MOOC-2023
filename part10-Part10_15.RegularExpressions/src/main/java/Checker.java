

public class Checker {
    
    public boolean isDayOfWeek(String string){
        return (string.matches("mon|tue|wed|thu|fri|sat|sun"));

    }
    
    public boolean allVowels(String string){
        return (string.matches("[aeiou]*"));
    }
    
    public boolean timeOfDay(String string){
        return (string.matches("([0-1][0-9]|[0-2][0-3]):([0-5][0-9]):([0-5][0-9])"));
    }

}

/*
 

public class Checker {

 

    public boolean isDayOfWeek(String string) {

        return string.matches("mon|tue|wed|thu|fri|sat|sun");

    }

 

    public boolean allVowels(String string) {

        return string.matches("[aeiou]*");

    }

 

    public boolean timeOfDay(String string) {

        return string.matches("([01][0123456789]|2[0123]):[012345][0123456789]:[012345][0123456789]");

    }

}
*/