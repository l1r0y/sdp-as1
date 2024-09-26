public class IngredientProvider {

    interface Milk {
        String getMilkType();
    }

    interface Syrup {
        String getSyrupType();
    }

    static class WholeMilk implements Milk {
        @Override
        public String getMilkType() {
            return "Whole Milk";
        }
    }

    static class VanillaSyrup implements Syrup {
        @Override
        public String getSyrupType() {
            return "Vanilla Syrup";
        }
    }

    interface IngredientProviderInterface {
        Milk createMilk();
        Syrup createSyrup();
    }

    static class LatteIngredientProvider implements IngredientProviderInterface {
        @Override
        public Milk createMilk() {
            return new WholeMilk();
        }

        @Override
        public Syrup createSyrup() {
            return new VanillaSyrup();
        }
    }
}