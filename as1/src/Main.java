public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        // Получаем экземпляр кафе через Singleton
        CafeManager cafeManager = CafeManager.getInstance();

        // Используем фабричный метод для создания Латте
        DrinkCreator.LatteCreator latteCreator = new DrinkCreator.LatteCreator();
        DrinkCreator.Coffee latte = latteCreator.createDrink();

        // Используем абстрактную фабрику для ингредиентов Латте
        IngredientProvider.LatteIngredientProvider latteIngredients = new IngredientProvider.LatteIngredientProvider();
        IngredientProvider.Milk milk = latteIngredients.createMilk();
        IngredientProvider.Syrup syrup = latteIngredients.createSyrup();

        // Создаём заказ с помощью Builder
        OrderPrototype customLatte = new CustomCoffeeBuilder()
                .selectCoffee(latte)
                .addMilk(milk)
                .addSyrup(syrup)
                .build();

        // Размещаем заказ в кафе
        cafeManager.placeOrder(customLatte);

        // Клонируем заказ (Prototype)
        OrderPrototype clonedOrder = customLatte.clone();
        cafeManager.placeOrder(clonedOrder);

        System.out.println("Active orders: " + cafeManager.getActiveOrders());
    }
}