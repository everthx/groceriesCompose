package com.example.groceriescompose.data

class StockList {

    fun getFruits(): List<String> = listOf("Apples", "Bananas", "Peaches", "Grapes", "Oranges")

    fun getVegetables(): List<String> = listOf(
            "Carrots", "Potatoes", "Onions", "Eggs", "Tomatoes", "Lemon",
            "Broccoli", "Lettuce", "Cabbage", "Cauliflower", "Celery", "Mushrooms", "Basil", "Coriander", "Thyme",
            "Bell Pepper", "Jalapeno", "Radish", "Sweet Potato", "Spinach", "Zucchini"
    )

    fun getBread(): List<String> = listOf(
            "White Bread", "Wheat Bread", "Multi Grain Bread", "Diet Cereal", "Sugar Cereal", "Tortilla Chips", "Tortillas",
            "Coffee Blend", "Cappuccino Blend", "La Chata Beans", "Rice", "Pasta", "Log Cabin Honey", "Peas", "Tuna"
    )

    fun getDairy(): List<String> = listOf(
        "Milk Dad", "Milk Mom", "Milk Eddy", "Milk Fer", "Fresh Cheese", "Yellow Cheese", "Yogurt",
        "Diet Mayonnaise", "Regular Mayonnaise"
    )

    fun getMeat(): List<String> = listOf("Steak", "Ground Beef", "Sausage", "Ham", "Chorizo")

    fun getFrozen(): List<String> = listOf("Waffles", "Shrimp", "Ice Cream")
}