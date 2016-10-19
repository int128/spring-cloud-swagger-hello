package example.server.api

import example.client.petstore.api.PetsApiClient
import example.server.model.Product
import example.server.model.Products
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductsApiImpl implements ProductsApi {

    @Autowired
    public PetsApiClient petsApiClient

    @Override
    Products productsGet() {
        def products = new Products()
        products.addAll(petsApiClient.listPets(10).body.collect { pet ->
            def product = new Product()
            product.id = pet.id
            product.name = pet.name
            product
        })
        products
    }

}
