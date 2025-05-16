package com.pdmtaller2.katyaherrera00188119.data.dummy

import com.pdmtaller2.katyaherrera00188119.data.model.Dish
import com.pdmtaller2.katyaherrera00188119.data.model.Restaurant


val restaurants = listOf(
    Restaurant(
        id = 1,
        name = "Pizza Planet",
        description = "Las mejores pizzas del universo",
        imageUrl = "https://assets.surlatable.com/m/15a89c2d9c6c1345/72_dpi_webp-REC-283110_Pizza.jpg",
        categories = listOf("Pizzas", "Comida Italiana", "Vegetariano"),
        menu = listOf(
            Dish(
                id = 1,
                name = "Pizza Pepperoni",
                description = "Clásica pizza con pepperoni y queso.",
                imageUrl = "https://www.foodandwine.com/thmb/4qg95tjf0mgdHqez5OLLYc0PNT4=/750x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/classic-cheese-pizza-FT-RECIPE0422-31a2c938fc2546c9a07b7011658cfd05.jpg"
            ),
            Dish(
                id = 2,
                name = "Pizza Vegetariana",
                description = "Pizza saludable con verduras frescas.",
                imageUrl = "https://assets.surlatable.com/m/15a89c2d9c6c1345/72_dpi_webp-REC-283110_Pizza.jpg"
            )
        )
    ),
    Restaurant(
        id = 2,
        name = "Burger King Kong",
        description = "Las hamburguesas más monstruosas",
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRZPlBII-jP3HidNdYCyPbSu5p77M-Z3XZkBA&s",
        categories = listOf("Pizzas", "Comida Italiana", "Vegetariano"),
        menu = listOf(
            Dish(
                id = 3,
                name = "Hamburguesa Doble Queso",
                description = "Doble carne, doble queso, doble sabor.",
                imageUrl = "https://b.zmtcdn.com/data/pictures/6/20529116/1b39c4665c00eb96f5bb4542ae0b1fe2_featured_v2.jpg"
            ),
            Dish(
                id = 4,
                name = "Hamburguesa Vegana",
                description = "Una opción deliciosa y saludable.",
                imageUrl = "https://b.zmtcdn.com/data/pictures/6/20529116/1b39c4665c00eb96f5bb4542ae0b1fe2_featured_v2.jpg"
            )
        )
    ),
    Restaurant(
        id = 3,
        name = "China Wok",
        description = "Comida facil, caliente y a tu alcance",
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTg71mWaO0Ncay-Q9kAs5QlpygJLJLn07SfDA&s",
        categories = listOf("Vegetariano", "Comida China", "Vegetariano"),
        menu = listOf(
            Dish(
                id = 4,
                name = "Plato woki",
                description = "Doble pollo, doble vegetal, doble sabor.",
                imageUrl = "https://comelongo.com/wp-content/uploads/2021/02/136630447_3575448069159456_733720005356781400_n-580x360.png"
            ),
            Dish(
                id = 5,
                name = "Festival camaron",
                description = "Una opción deliciosa y saludable.",
                imageUrl = "https://www.chinawok.com.sv/static/media/images/products/webp/CMB_1051_SM_17-03-2023-14-13.webp"
            )
        )
    ),
    Restaurant(
        id = 4,
    name = "Don Pollo",
    description = "Pollo rico, caliente y a tu alcance",
    imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRAtyxWbgiwniCjb2utwq7g2hZ2fCZcuL1XCA&s",
    categories = listOf("Nada vegetariano", "Comida rapida", "Fritura"),
    menu = listOf(
        Dish(
            id = 5,
            name = "Pollito Loco",
            description = "Doble pollo, doble vegetal, doble sabor.",
            imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSZGTaARc_jKWg3-88qlcVvf1SvuFIcPqvtXg&s"
        ),
        Dish(
            id = 6,
            name = "Plato personal",
            description = "Una opción deliciosa y saludable.",
            imageUrl = "https://comelongo.com/wp-content/uploads/2021/01/137496884_3479706068821445_892071447319784994_o-580x408.png"
        )
    )
)

)
