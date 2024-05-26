package kr.sample.kopringsample.product.application

import kr.sample.kopringsample.product.application.dto.CreateOrUpdateProductDto
import kr.sample.kopringsample.product.application.service.ProductService
import kr.sample.kopringsample.product.infra.repository.ProductEntity
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/products")
class ProductController(
    private val productService: ProductService,
) {
    @GetMapping("/")
    suspend fun getProducts(): List<ProductEntity> {
        return productService.getProducts()
    }

    @PostMapping("/create")
    suspend fun createProduct(
        @RequestBody createOrUpdateProductDto: CreateOrUpdateProductDto
    ): String {
        productService.createProduct(createOrUpdateProductDto.toEntity())
        return "success"
    }

    @DeleteMapping("/delete/{id}")
    suspend fun deleteProduct(
        @PathVariable id: Long
    ): ResponseEntity<String> {
        productService.deleteProduct(id)
        return ResponseEntity.noContent().build()
    }

    @PutMapping("/update/{id}")
    suspend fun updateProduct(
        @PathVariable id: Long,
        @RequestBody createOrUpdateProductDto: CreateOrUpdateProductDto
    ): ResponseEntity<String> {
        productService.updateProduct(id, createOrUpdateProductDto)
        return ResponseEntity.noContent().build()
    }
}