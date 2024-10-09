/**
 * Klasa GeometryCalculator zawiera metody do obliczeń geometrycznych,
 * takich jak obliczanie pola kwadratu oraz pola koła.
 * <p>
 * Jest to prosta klasa, której celem jest pokazanie zastosowania dokumentacji JavaDoc.
 */
public class geometricCalculator {

    /**
     * Oblicza pole kwadratu na podstawie długości boku.
     *
     * @param side długość boku kwadratu (typu double)
     * @return pole kwadratu (typu double)
     * @throws IllegalArgumentException jeśli długość boku jest mniejsza niż zero
     */
    public static double calculateSquareArea(double side) {
        if (side < 0) {
            throw new IllegalArgumentException("Długość boku kwadratu musi być dodatnia.");
        }
        return side * side;
    }

    /**
     * Oblicza pole koła na podstawie promienia.
     *
     * @param radius promień koła (typu double)
     * @return pole koła (typu double)
     * @throws IllegalArgumentException jeśli promień jest mniejszy niż zero
     */
    public static double calculateCircleArea(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Promień koła musi być dodatni.");
        }
        return Math.PI * radius * radius;
    }

    /**
     * Główna metoda programu, która demonstruje użycie metod calculateSquareArea i calculateCircleArea.
     *
     * @param args argumenty wiersza poleceń
     */
    public static void main(String[] args) {
        double squareSide = 5.0;
        double circleRadius = 3.0;

        try {
            double squareArea = calculateSquareArea(squareSide);
            double circleArea = calculateCircleArea(circleRadius);

            System.out.println("Pole kwadratu o boku " + squareSide + " wynosi: " + squareArea);
            System.out.println("Pole koła o promieniu " + circleRadius + " wynosi: " + circleArea);
        } catch (IllegalArgumentException e) {
            System.err.println("Błąd: " + e.getMessage());
        }
    }
}
