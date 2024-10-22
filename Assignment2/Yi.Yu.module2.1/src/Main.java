public class Main {
    public static void main(String[] args) {
        Planet PlanetA = new Planet("Mars", PlanetType.TypeA);
        Planet PlanetB = new Planet("Mars",1000000,1023,PlanetType.TypeA);
        Planet PlanetC = new Planet("Earth",PlanetType.TypeB);
        System.out.println(PlanetA.equals(PlanetB));
        System.out.println(PlanetA.equals(PlanetC));

        System.out.println(PlanetB.toString());
    }
}