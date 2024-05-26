package kr.sample.kopringsample

import kr.sample.kopringsample.product.application.service.ProductService
import kr.sample.kopringsample.product.infra.repository.ProductEntity
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ProductServiceTest {
    @Autowired
    lateinit var productService: ProductService

    @Test
    @DisplayName("상품 등록 테스트")
    fun createProductTest() {
        // given
        val productEntity = ProductEntity(
            name = "상품1",
            price = 1000
        )

        // when
        productService.createProduct(productEntity)

        // then
        val products = productService.getProducts()
        assert(products.isNotEmpty())
    }
}