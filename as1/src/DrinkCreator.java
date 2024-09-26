public class DrinkCreator {

    interface Coffee {
        String getCoffeeName();
    }

    static class EspressoLatte implements Coffee {
        @Override
        public String getCoffeeName() {
            return "Espresso Latte";
        }
    }

    interface DrinkCreatorInterface {
        Coffee createDrink();
    }

    static class LatteCreator implements DrinkCreatorInterface {
        @Override
        public Coffee createDrink() {
            return new EspressoLatte();  // Создает и возвращает Латте
        }
    }
}